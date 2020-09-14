package com.sda.carrent.mapper;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public Booking fromDTO(BookingDTO bookingDTO) {
        Booking booking = new Booking();

        booking.setBookingPk(bookingDTO.getBookingPk());
        booking.setDateOfBooking(bookingDTO.getDateOfBooking());
        booking.setCustomerPk(bookingDTO.getCustomerPk());
        booking.setCarPk(bookingDTO.getCarPk());
        booking.setDateFrom(bookingDTO.getDateFrom());
        booking.setDateTo(bookingDTO.getDateTo());
        booking.setAmount(bookingDTO.getAmount());

        return booking;
    }

    public BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingPk(booking.getBookingPk());
        bookingDTO.setDateOfBooking(booking.getDateOfBooking());
        bookingDTO.setCustomerPk(booking.getCustomerPk());
        bookingDTO.setCarPk(booking.getCarPk());
        bookingDTO.setDateFrom(booking.getDateFrom());
        bookingDTO.setDateTo(booking.getDateTo());
        bookingDTO.setAmount(booking.getAmount());

        return bookingDTO;
    }


}
