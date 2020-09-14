package com.sda.carrent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingDTO extends DtoHolder {

    @JsonProperty("booking_pk")
    private Long bookingPk;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("date_of_booking")
    private Date dateOfBooking;

    @JsonProperty("customer_pk")
    private Long customerPk;

    @JsonProperty("car_pk")
    private Long carPk;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("date_from")
    private Date dateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("date_to")
    private Date dateTo;

    @JsonProperty("amount")
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
}
