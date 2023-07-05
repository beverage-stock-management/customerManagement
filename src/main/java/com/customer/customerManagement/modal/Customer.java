package com.customer.customerManagement.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("CustomerData")
public class Customer {

    @Id
    private int id;
    private String name;
    private String phone;
    private String address;
    private String dealer;

}
