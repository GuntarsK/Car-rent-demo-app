package com.sda.carrent.controller;

import com.sda.carrent.dto.BookingDTO;
import com.sda.carrent.dto.Response;
import com.sda.carrent.dto.ResponseMapper;
import com.sda.carrent.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rest/booking.svc")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;
    private final ResponseMapper responseMapper;


    @Autowired
    public BookingController(BookingService bookingService, ResponseMapper responseMapper) {
        this.bookingService = bookingService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/booking")
    public Response createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return responseMapper
                .mapSuccess(bookingService.createBooking(bookingDTO));
    }

    @GetMapping("/booking")
    public Response getAllBookings() {
        return responseMapper
                .mapSuccess(bookingService.getBookings());
    }

    @GetMapping("/booking({pk})")
    public Response getBookingById(@PathVariable("pk") Long pk) {
        return responseMapper
                .mapSuccess(bookingService.getBookingById(pk));
    }

    @PostMapping("/booking/search")
    public Response search(@RequestBody BookingDTO bookingDTO) {
        return responseMapper
                .mapSuccess(bookingService.search(bookingDTO));
    }

    @PutMapping("/booking")
    public void updateBooking(@RequestBody BookingDTO bookingDTO) {
        bookingService.updateBooking(bookingDTO);
    }


}
