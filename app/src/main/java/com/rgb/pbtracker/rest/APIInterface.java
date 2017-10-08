package com.rgb.pbtracker.rest;

import com.rgb.pbtracker.model.CustomerResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface {
    @GET("get-list")
    Call<CustomerResponse> getCustomerData();

    @GET("make-outbount-calls")
    Call<String> makeOutboundCalls();
}
