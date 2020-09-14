package com.sda.carrent.service;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.mapper.BookingMapper;
import com.sda.carrent.model.Booking;
import com.sda.carrent.repository.BookingRepository;
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

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public BookingDTO createBooking(BookingDTO reservationDTO) {
        Booking booking = bookingMapper.fromDTO(reservationDTO);
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

    public void updateBooking(BookingDTO bookingDTO) {
        Booking bookingToUpdate = bookingMapper.fromDTO(bookingDTO);
        Booking bookingFromDB = bookingRepository.getOne(bookingDTO.getBookingPk());
        BeanUtils.copyProperties(bookingToUpdate, bookingFromDB, "bookingPk");
        bookingRepository.save(bookingFromDB);
    }

    public List<BookingDTO> search(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.fromDTO(bookingDTO);
        Example<Booking> bookingExample = Example.of(booking);
        List<Booking> bookings = bookingRepository.findAll(bookingExample);
        return bookings.stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }



}
