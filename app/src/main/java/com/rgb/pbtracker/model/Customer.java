
package com.rgb.pbtracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Customer implements Serializable
{

    @SerializedName("delivered")
    @Expose
    private String delivered;
    @SerializedName("del_time")
    @Expose
    private String delTime;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("social")
    @Expose
    private String social;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cust_id")
    @Expose
    private String custId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("ord_id")
    @Expose
    private String ordId;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = -926230406898520563L;

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
