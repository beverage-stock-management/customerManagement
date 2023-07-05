package com.customer.customerManagement.service;

import com.customer.customerManagement.dto.CustomerDto;
import com.customer.customerManagement.modal.Customer;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);
}
