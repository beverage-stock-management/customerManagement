package com.customer.customerManagement.service.impl;

import com.customer.customerManagement.dto.CustomerDto;
import com.customer.customerManagement.exceptions.CustomerNotFoundException;
import com.customer.customerManagement.modal.Customer;
import com.customer.customerManagement.repository.CustomerRepository;
import com.customer.customerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customer = customerRepository.findAll();
        return customer.stream().map(customer1 -> mapToDto(customer1)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer cannot be found"));
        return mapToDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer cannot be updated"));

        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setDealer(customerDto.getDealer());

        Customer updatedCustomer = customerRepository.save(customer);
        return mapToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer canot be deleted"));
        customerRepository.delete(customer);
    }

    private CustomerDto mapToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setPhone(customer.getPhone());
        customerDto.setAddress(customer.getAddress());
        customerDto.setDealer(customer.getDealer());
        return customerDto;
    }
}
