package az.turing.dto;

import az.turing.model.Passenger;

import java.util.List;

public class BookingDto {
    private long flightId;
    private List<Passenger> passengers;

    public BookingDto(long flightId, List<Passenger> passengers) {
        this.flightId = flightId;
        this.passengers = passengers;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "BookingRequestDto{" +
                "flightId=" + flightId +
                ", passengers=" + passengers +
                '}';
    }
}
