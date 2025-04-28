package az.turing.dao.impl.database;

import az.turing.dao.impl.inter.BookingDao;
import az.turing.model.Booking;

import java.util.List;

public class BookingDB extends BookingDao {

    @Override
    public boolean existsByFlightId(Long id) {
        return false;
    }

    @Override
    public List<Booking> getAll() {
        return List.of();
    }

    @Override
    public Booking create(Booking entity) {
        return null;
    }

    @Override
    public void update(Booking entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Booking getById(Long id) {
        return null;
    }
}
