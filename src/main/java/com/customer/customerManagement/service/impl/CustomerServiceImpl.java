package com.customer.customerManagement.service.impl;

import com.customer.customerManagement.dto.CustomerDto;
import com.customer.customerManagement.modal.Customer;
import com.customer.customerManagement.repository.CustomerRepository;
import com.customer.customerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setDealer(customerDto.getDealer());

        Customer newCustomer = customerRepository.save(customer);

        CustomerDto customerResponse = new CustomerDto();
        customerResponse.setId(newCustomer.getId());
        customerResponse.setName(newCustomer.getName());
        customerResponse.setPhone(newCustomer.getPhone());
        customerResponse.setAddress(newCustomer.getAddress());
        customerResponse.setDealer(newCustomer.getDealer());

        return customerResponse;
    }
}
