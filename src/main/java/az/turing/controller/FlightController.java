package az.turing.controller;

import az.turing.dto.FlightDto;
import az.turing.service.FlightService;
import az.turing.service.impl.FlightServiceImpl;

import java.util.List;

public class FlightController {
    private  final FlightServiceImpl flightService;

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    public List<FlightDto> getAll() {
        return flightService.getAll();
    }

    public FlightDto getById(long id) {
        return flightService.getById(id);
    }

    public FlightDto create(FlightDto flightDto) {
        return flightService.save(flightDto);
    }

    public void delete(long id) {
         flightService.delete(id);
    }

    public void update(FlightDto flightDto) {
         flightService.update(flightDto);
    }
}
