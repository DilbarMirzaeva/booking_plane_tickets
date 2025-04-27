package az.turing.dao.impl.inter;

import az.turing.dao.Dao;
import az.turing.model.Flight;

import java.time.LocalDateTime;

public abstract class FlightDao implements Dao<Flight,Long> {
    public abstract boolean existsTimeAndDestination(String destionation, LocalDateTime time);
}
