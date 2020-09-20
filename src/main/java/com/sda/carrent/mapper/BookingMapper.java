package com.sda.carrent.mapper;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.model.Booking;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.Customer;
import com.sda.carrent.repository.CarRepository;
import com.sda.carrent.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;

    public BookingMapper(CustomerRepository customerRepository, CarRepository carRepository) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }

    public Booking fromDTO(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        Customer customer = customerRepository.getOne(bookingDTO.getCustomerPk());
        Car car = carRepository.getOne(bookingDTO.getCarPk());

        booking.setBookingPk(bookingDTO.getBookingPk());
        booking.setDateOfBooking(bookingDTO.getDateOfBooking());
        booking.setCustomer(customer);
        booking.setCar(car);
        booking.setDateFrom(bookingDTO.getDateFrom());
        booking.setDateTo(bookingDTO.getDateTo());
        booking.setStatusInDb(bookingDTO.getStatusInDb());

        return booking;
    }

    public BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingPk(booking.getBookingPk());
        bookingDTO.setDateOfBooking(booking.getDateOfBooking());
        bookingDTO.setCustomerPk(booking.getCustomer().getCustomerPk());
        bookingDTO.setCarPk(booking.getCar().getCarPk());
        bookingDTO.setDateFrom(booking.getDateFrom());
        bookingDTO.setDateTo(booking.getDateTo());
        bookingDTO.setAmount(booking.getAmount());
        bookingDTO.setStatusInDb(booking.getStatusInDb());

        return bookingDTO;
    }


}
