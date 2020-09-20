package com.sda.carrent.controller;

import com.sda.carrent.dto.Response;
import com.sda.carrent.dto.ResponseMapper;
import com.sda.carrent.dto.CustomerDTO;
import com.sda.carrent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rest/customer.svc")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;
    private final ResponseMapper responseMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ResponseMapper responseMapper) {
        this.customerService = customerService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/customer")
    public Response response (@Valid @RequestBody CustomerDTO customerDTO) {
        if (customerService.doesEmailExist(customerDTO.getEmail())) {
            return responseMapper.mapFail("Email: " + customerDTO.getEmail() + " already exists!", "WARNING");
        }
        return responseMapper
                .mapSuccess(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/customers")
    public Response getAllCustomers() {
        return responseMapper
                .mapSuccess(customerService.getCustomers());
    }

    @GetMapping("/customer({id})")
    public Response getCustomerById(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(customerService.getCustomerById(id));
    }

    @PutMapping("/customer")
    public Response updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return responseMapper
                .mapSuccess(customerService.updateCustomer(customerDTO));
    }

    @PostMapping("/customers/search")
    public Response search(@RequestBody CustomerDTO customerDTO) {
        return responseMapper
                .mapSuccess(customerService.search(customerDTO));
    }

    @DeleteMapping("/customer({id})")
    public Response deleteCustomer(@PathVariable("id") Long id) {
        if (customerService.doesCustomerHasBookings(id) == true) {
            return responseMapper
                    .mapFail("Can't delete customer. Check bookings.", "ERROR");
        }
        return responseMapper
                    .mapSuccess(customerService.deleteCustomer(id));
    }


}
