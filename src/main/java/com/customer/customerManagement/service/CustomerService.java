package com.customer.customerManagement.service;

import com.customer.customerManagement.dto.CustomerDto;
import com.customer.customerManagement.modal.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomer(int id);
}
