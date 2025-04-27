package az.turing.service.impl;

import az.turing.dao.impl.inter.FlightDao;
import az.turing.dto.FlightDto;
import az.turing.exception.AlreadyExistException;
import az.turing.exception.NotEnoughSeatsException;
import az.turing.mapper.FlightMapper;
import az.turing.model.Flight;
import az.turing.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightDao flightDao;
    private final FlightMapper flightMapper;

    public FlightServiceImpl(FlightDao flightDao, FlightMapper flightMapper) {
        this.flightDao = flightDao;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDto> getAll() {
        return flightDao.getAll().stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public FlightDto save(FlightDto entity) {
        Flight flight=flightMapper.toEntity(entity);
        if (flight.getAvailableSeats()>flight.getTotalSeats()){
            throw new NotEnoughSeatsException("Cannot book " + flight.getAvailableSeats() + " passengers for flight to " + flight.getDestination() + ". Only " + flight.getDestination() + " seats available.");
        } else if (flightDao.existsTimeAndDestination(flight.getDestination(), flight.getDateTime())) {
            throw new AlreadyExistException("FLight already Contains!");
        }
        flightDao.create(flight);
        return entity;
    }

    @Override
    public void update(FlightDto entity) {
        Flight flight=flightMapper.toEntity(entity);
        if(flight.getAvailableSeats()>flight.getTotalSeats()){
            throw new NotEnoughSeatsException("Cannot book " + flight.getAvailableSeats() + " passengers for flight to " + flight.getDestination() + ". Only " + flight.getDestination() + " seats available.");
        }
        flightDao.update(flight);
    }

    @Override
    public void delete(long id) {
        flightDao.delete(id);
    }

    @Override
    public FlightDto getById(long id) {
        Flight flight= flightDao.getById(id);
        return flightMapper.toDto(flight);
    }
}
