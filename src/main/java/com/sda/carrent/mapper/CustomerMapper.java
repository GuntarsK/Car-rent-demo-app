package com.sda.carrent.mapper;

import com.sda.carrent.dto.CustomerDTO;
import com.sda.carrent.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer fromDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCustomerPk(customerDTO.getCustomerPk());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        return customer;
    }


    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerPk(customer.getCustomerPk());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAddress(customer.getAddress());

        return customerDTO;
    }

}
