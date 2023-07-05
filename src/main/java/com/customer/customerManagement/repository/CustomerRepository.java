package com.customer.customerManagement.repository;

import com.customer.customerManagement.modal.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
