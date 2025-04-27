package az.turing.dao.impl.inter;

import az.turing.dao.Dao;
import az.turing.model.Booking;

public abstract class BookingDao implements Dao<Booking,Long> {
    public abstract boolean existsByFlightId(Long id);
}
