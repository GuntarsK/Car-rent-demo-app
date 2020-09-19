package com.sda.carrent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CustomerDTO extends DtoHolder {

    @JsonProperty("customer_pk")
    private Long customerPk;

    @NotBlank(message = "Please provide First name")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "Please provide Last name")
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank(message = "Please provide email address")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Please provide phone number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("password_hash")
    private String passwordHash;

    @JsonProperty("status_in_db")
    private String statusInDb;

    public Long getCustomerPk() {
        return customerPk;
    }

    public void setCustomerPk(Long customerPk) {
        this.customerPk = customerPk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getStatusInDb() {
        return statusInDb;
    }

    public void setStatusInDb(String statusInDb) {
        this.statusInDb = statusInDb;
    }
}
