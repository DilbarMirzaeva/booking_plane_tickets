package az.turing.mapper;

import az.turing.dto.FlightDto;
import az.turing.model.Flight;

public class FlightMapper implements EntityMapper<Flight, FlightDto> {
    @Override
    public Flight toEntity(FlightDto flightDto) {
        return new Flight(flightDto.getDestination(),flightDto.getDate(), flightDto.getTotalSeats(), flightDto.getPassengerCount());
    }

    @Override
    public FlightDto toDto(Flight flight) {
        return new FlightDto(flight.getDestination(),flight.getDateTime(), flight.getTotalSeats(), flight.getAvailableSeats());
    }
}
