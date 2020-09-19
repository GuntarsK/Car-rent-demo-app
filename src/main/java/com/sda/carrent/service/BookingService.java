package com.sda.carrent.service;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.mapper.BookingMapper;
import com.sda.carrent.model.Booking;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.userTypeEnum.CarStatus;
import com.sda.carrent.repository.BookingRepository;
import com.sda.carrent.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final CarService carService;
    private final CarRepository carRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, CarService carService, CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.carService = carService;
        this.carRepository = carRepository;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        // new lines
        Car carToUpdate = new Car();
        Car carFromDB = carRepository.getOne(bookingDTO.getCarPk());
        carFromDB.setCarStatus(CarStatus.RENTED);
//        carService.setCarBookingStatusToRented(bookingDTO.getCarPk());
        carRepository.save(carFromDB);

        Booking booking = bookingMapper.fromDTO(bookingDTO);
        Booking createdBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(createdBooking);
    }

    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(bookingMapper::toDTO)
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
                .collect(Collectors.toList());
    }

    public BookingDTO deleteBooking(Long id) {
        Booking booking = bookingRepository.getOne(id);
        booking.setStatusInDb("DELETED");
        bookingMapper.toDTO(booking);
        Booking deletedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(deletedBooking);
    }


}
