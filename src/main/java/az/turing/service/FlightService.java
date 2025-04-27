package az.turing.service;

import az.turing.dto.BookingDto;
import az.turing.dto.FlightDto;

import java.util.List;

public interface FlightService {
    List<FlightDto> getAll();
    FlightDto save(FlightDto entity);
    void update(FlightDto entity);
    void delete(long id);
    FlightDto getById(long id);
}
