package az.turing.dao.impl.database;

import az.turing.dao.impl.inter.FlightDao;
import az.turing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class FlightDB extends FlightDao {
    @Override
    public boolean existsTimeAndDestination(String destionation, LocalDateTime time) {
        return false;
    }

    @Override
    public List<Flight> getAll() {
        return List.of();
    }

    @Override
    public Flight create(Flight entity) {
        return null;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Flight getById(Long id) {
        return null;
    }
}
