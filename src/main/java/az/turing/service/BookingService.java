package az.turing.service;

import az.turing.dto.BookingDto;

import java.util.List;

public interface BookingService {

    List<BookingDto> getAll();
    BookingDto create(BookingDto entity);
    void update(BookingDto entity);
    void delete(long id);
    BookingDto getById(long id);
}
