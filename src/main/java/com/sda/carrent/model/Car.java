package com.sda.carrent.model;

import com.sda.carrent.model.userTypeEnum.CarBodyType;
import com.sda.carrent.model.userTypeEnum.CarStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_pk")
    private Long carPk;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "car_body_type")
    @Enumerated(EnumType.STRING)
    private CarBodyType carBodyType;

    @Column(name = "year_of_production")
    private Integer yearOfProduction;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status_in_db")
    private String statusInDb;

    @OneToOne(mappedBy = "car")
    private Booking booking;

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

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
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

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carPk=" + carPk +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", carBodyType=" + carBodyType +
                ", yearOfProduction=" + yearOfProduction +
                ", mileage=" + mileage +
                ", carStatus=" + carStatus +
                ", amount=" + amount +
                ", statusInDb='" + statusInDb + '\'' +
                ", booking=" + booking +
                '}';
    }
}
