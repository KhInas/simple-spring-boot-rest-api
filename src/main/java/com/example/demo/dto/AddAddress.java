package com.example.demo.dto;

import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;

public class AddAddress {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String postalCode;



}
