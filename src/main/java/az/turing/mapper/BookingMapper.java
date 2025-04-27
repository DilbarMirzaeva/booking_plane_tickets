package az.turing.mapper;

import az.turing.dto.BookingDto;
import az.turing.model.Booking;

public class BookingMapper implements EntityMapper<Booking, BookingDto> {

    @Override
    public Booking toEntity(BookingDto bookingDto) {
        return new Booking(bookingDto.getFlightId(),bookingDto.getPassengers());
    }

    @Override
    public BookingDto toDto(Booking booking) {
        return new BookingDto(booking.getFlightId(),booking.getPassengers());
    }
}
