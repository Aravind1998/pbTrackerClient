package com.rgb.pbtracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import info.androidhive.retrofit.R;
import com.rgb.pbtracker.model.Customer;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customers;
    private int rowLayout;
    private Context context;


    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        LinearLayout customerLayout;
        TextView customerTitle;
        TextView data;
        TextView customerDescription;
        TextView rating;


        public CustomerViewHolder(View v) {
            super(v);
            customerLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            customerTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            customerDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public CustomerAdapter(List<Customer> customers, int rowLayout, Context context) {
        this.customers = customers;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CustomerAdapter.CustomerViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CustomerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CustomerViewHolder holder, final int position) {
        holder.customerTitle.setText(customers.get(position).getName());
        holder.data.setText(customers.get(position).getPhone());
        holder.customerDescription.setText(customers.get(position).getDelTime());
        holder.rating.setText(customers.get(position).getDelivered());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }
}