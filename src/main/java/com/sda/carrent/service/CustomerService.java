package com.sda.carrent.service;

import com.sda.carrent.dto.CustomerDTO;
import com.sda.carrent.mapper.CustomerMapper;
import com.sda.carrent.model.Customer;
import com.sda.carrent.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDTO(customerDTO);
        Customer createdCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(createdCustomer);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customerToUpdate = customerMapper.fromDTO(customerDTO);
        Customer customerFromDB = customerRepository.getOne(customerDTO.getCustomerPk());
        BeanUtils.copyProperties(customerToUpdate, customerFromDB, "customerPk");
        customerRepository.save(customerFromDB);
        return customerMapper.toDTO(customerFromDB);
    }

    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(id);
        Customer customer = optionalCustomer.orElseGet(Customer::new);
        return customerMapper.toDTO(customer);
    }

    public List<CustomerDTO> search(CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDTO(customerDTO);
        Example<Customer> customerExample = Example.of(customer);
        List<Customer> customers = customerRepository.findAll(customerExample);
        return customers.stream()
                .map(customerMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public Boolean doesEmailExist(String email) {
        Customer customer = customerRepository.findByEmail(email);
        return customer != null;
    }

    public CustomerDTO deleteCustomer(Long id) {
        Customer customer = customerRepository.getOne(id);
        customer.setStatusInDb("DELETED");
        customerMapper.toDTO(customer);
        Customer deletedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(deletedCustomer);
    }

}
