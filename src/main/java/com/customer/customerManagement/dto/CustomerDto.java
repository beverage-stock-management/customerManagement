package com.customer.customerManagement.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String dealer;
}
