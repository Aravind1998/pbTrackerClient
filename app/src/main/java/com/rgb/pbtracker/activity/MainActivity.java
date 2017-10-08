package com.rgb.pbtracker.activity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rgb.pbtracker.adapter.CustomerAdapter;
import com.rgb.pbtracker.model.Customer;
import com.rgb.pbtracker.model.CustomerResponse;
import com.rgb.pbtracker.rest.APIClient;
import com.rgb.pbtracker.rest.APIInterface;

import java.util.List;

import info.androidhive.retrofit.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static final String TAG = "MainActivity";
    private TextView locationText;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        locationText = (TextView)findViewById(R.id.location);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Call<String> outbound = apiService.makeOutboundCalls();
                getLocation();
//                outbound.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        int statusCode = response.code();
//                        Snackbar.make(view, "Calling Numbers.."+statusCode, Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        // Log error here since request failed
//                        Log.e(TAG, t.toString());
//                        Snackbar.make(view, t.toString(), Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//                });
            }
        });

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<CustomerResponse> call = apiService.getCustomerData();
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                int statusCode = response.code();
                List<Customer> customers = response.body().getCustomers();
                recyclerView.setAdapter(new CustomerAdapter(customers, R.layout.list_item_customer, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        locationText.setText("Current Location: " + location.getLatitude() + ", " + location.getLongitude());
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MainActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

}
