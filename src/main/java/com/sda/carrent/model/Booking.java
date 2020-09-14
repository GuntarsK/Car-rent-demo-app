package com.sda.carrent.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_pk")
    private Long bookingPk;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_of_booking")
    private Date dateOfBooking;

    @Column(name = "customer_pk")
    private Long customerPk;

    @Column(name = "car_pk")
    private Long carPk;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_from")
    private Date dateFrom;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "amount")
    private Double amount;

    public Long getBookingPk() {
        return bookingPk;
    }

    public void setBookingPk(Long bookingPk) {
        this.bookingPk = bookingPk;
    }

    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Long getCustomerPk() {
        return customerPk;
    }

    public void setCustomerPk(Long customerPk) {
        this.customerPk = customerPk;
    }

    public Long getCarPk() {
        return carPk;
    }

    public void setCarPk(Long carPk) {
        this.carPk = carPk;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingPk=" + bookingPk +
                ", dateOfBooking=" + dateOfBooking +
                ", customerPk=" + customerPk +
                ", carPk=" + carPk +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", amount=" + amount +
                '}';
    }
}
