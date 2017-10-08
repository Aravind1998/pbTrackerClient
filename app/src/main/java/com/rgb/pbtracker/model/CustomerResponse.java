
package com.rgb.pbtracker.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerResponse {
    @SerializedName("results")
    private List<Customer> customers = null;

    private final static long serialVersionUID = 1175983464839928144L;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
