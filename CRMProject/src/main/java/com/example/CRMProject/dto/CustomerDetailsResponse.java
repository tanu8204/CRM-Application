package com.example.CRMProject.dto;

import com.example.CRMProject.entity.Customer;
import com.example.CRMProject.entity.Order;

import java.util.List;

public class CustomerDetailsResponse {
    private Customer customer;
    private List<Order> orders;

    public CustomerDetailsResponse(Customer customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    // getters and setters
}
