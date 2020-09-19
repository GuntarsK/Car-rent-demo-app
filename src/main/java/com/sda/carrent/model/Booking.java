package com.sda.carrent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sda.carrent.service.BookingService;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_pk")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_pk")
    private Car car;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_from")
    private Date dateFrom;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status_in_db")
    private String statusInDb;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public String getStatusInDb() {
        return statusInDb;
    }

    public void setStatusInDb(String statusInDb) {
        this.statusInDb = statusInDb;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingPk=" + bookingPk +
                ", dateOfBooking=" + dateOfBooking +
                ", customer=" + customer +
                ", car=" + car +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", amount=" + amount +
                ", statusInDb='" + statusInDb + '\'' +
                '}';
    }
}
