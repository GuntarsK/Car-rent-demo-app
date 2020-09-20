package com.sda.carrent.service;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.mapper.BookingMapper;
import com.sda.carrent.model.Booking;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.Customer;
import com.sda.carrent.model.userTypeEnum.CarStatus;
import com.sda.carrent.repository.BookingRepository;
import com.sda.carrent.repository.CarRepository;
import com.sda.carrent.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final CarService carService;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, CarService carService, CarRepository carRepository, CustomerRepository customerRepository, CustomerService customerService) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.carService = carService;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.fromDTO(bookingDTO);

        Customer customerFromDB = customerRepository.getOne(bookingDTO.getCustomerPk());
        Set<Booking> customerBookings = customerFromDB.getBookings();
        customerBookings.add(booking);
        customerFromDB.setBookings(customerBookings);
        customerRepository.save(customerFromDB);

        Car carFromDB = carRepository.getOne(bookingDTO.getCarPk());
        carFromDB.setCarStatus(CarStatus.RENTED);
        Set<Booking> carBookings = carFromDB.getBookings();
        carBookings.add(booking);
        carFromDB.setBookings(carBookings);
        carRepository.save(carFromDB);

        Double pricePerDay = carFromDB.getAmount();
        Long start = bookingDTO.getDateFrom().getTime();
        Long end = bookingDTO.getDateTo().getTime();
        Long days = (end-start) / 1000 / 60 / 60 / 24;
        if (days<1) {days = 1L;};
        booking.setAmount(pricePerDay * days);

        Booking createdBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(createdBooking);
    }

    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(bookingMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        Booking booking = optionalBooking.orElseGet(Booking::new);
        return bookingMapper.toDTO(booking);
    }

    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Booking bookingToUpdate = bookingMapper.fromDTO(bookingDTO);
        Booking bookingFromDB = bookingRepository.getOne(bookingDTO.getBookingPk());
        BeanUtils.copyProperties(bookingToUpdate, bookingFromDB, "bookingPk");
        bookingRepository.save(bookingFromDB);
        return bookingMapper.toDTO(bookingFromDB);
    }

    public List<BookingDTO> search(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.fromDTO(bookingDTO);
        Example<Booking> bookingExample = Example.of(booking);
        List<Booking> bookings = bookingRepository.findAll(bookingExample);
        return bookings.stream()
                .map(bookingMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public BookingDTO deleteBooking(Long id) {
        Booking booking = bookingRepository.getOne(id);

        Car carFromDB = carRepository.getOne(booking.getCar().getCarPk());
        carFromDB.setCarStatus(CarStatus.AVAILABLE);
        carFromDB.getBookings().remove(booking);
        carRepository.save(carFromDB);

        Customer customerFromDB = customerRepository.getOne(booking.getCustomer().getCustomerPk());
        customerFromDB.getBookings().remove(booking);
        customerRepository.save(customerFromDB);

        booking.setStatusInDb("DELETED");
        bookingMapper.toDTO(booking);
        Booking deletedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(deletedBooking);
    }

//    public void calculateAmount(BookingDTO bookingDTO) {
//        Booking booking = bookingMapper.fromDTO(bookingDTO);
//        Car carFromDB = carRepository.getOne(bookingDTO.getCarPk());
//
//        Double pricePerDay = carFromDB.getAmount();
//        Long start = bookingDTO.getDateFrom().getTime();
//        Long end = bookingDTO.getDateTo().getTime();
//        Long days = (end-start) / 1000 / 60 / 60 / 24;
//        booking.setAmount(pricePerDay * days);
//    }


}
