package com.sda.carrent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CarDTO extends DtoHolder {

    @JsonProperty("car_pk")
    private Long carPk;

    @NotBlank(message = "Please provide bike manufacturer")
    @JsonProperty("make")
    private String make;

    @NotBlank(message = "Please provide bike model")
    @JsonProperty("model")
    private String model;

    @NotBlank(message = "Please provide bike category")
    @JsonProperty("car_body_type")
    private String carBodyType;

    @JsonProperty("year_of_production")
    private Integer yearOfProduction;

    @JsonProperty("mileage")
    private Integer mileage;

    @JsonProperty("status")
    private String status;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("status_in_db")
    private String statusInDb;

    public Long getCarPk() {
        return carPk;
    }

    public void setCarPk(Long carPk) {
        this.carPk = carPk;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(String carBodyType) {
        this.carBodyType = carBodyType;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatusInDb() {
        return statusInDb;
    }

    public void setStatusInDb(String statusInDb) {
        this.statusInDb = statusInDb;
    }
}


