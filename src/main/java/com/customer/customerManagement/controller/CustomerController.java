package com.customer.customerManagement.controller;

import com.customer.customerManagement.dto.CustomerDto;
import com.customer.customerManagement.modal.Customer;
import com.customer.customerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("customer/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return  new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("customers")
    public ResponseEntity<List <CustomerDto>> getCustomers(){
        return  new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }
}
