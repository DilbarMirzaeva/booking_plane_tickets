package az.turing.controller;

import az.turing.dto.BookingDto;
import az.turing.dto.FlightDto;
import az.turing.service.impl.BookingServiceImpl;
import az.turing.service.impl.FlightServiceImpl;

import java.util.List;

public class BookingController {

    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    public List<BookingDto> getAll() {
        return bookingService.getAll();
    }

    public BookingDto getById(long id) {
        return bookingService.getById(id);
    }

    public BookingDto create(BookingDto bookingDto) {
        return bookingService.create(bookingDto);
    }

    public void delete(long id) {
        bookingService.delete(id);
    }

    public void update(BookingDto bookingDto) {
        bookingService.update(bookingDto);
    }
}
