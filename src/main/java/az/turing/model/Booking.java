package az.turing.model;

import java.util.List;

public class Booking {
    private Long id;
    private Long flightId;
    private List<Passenger> passengers;

    public Booking(Long id, Long flightId, List<Passenger> passengers) {
        this.id = id;
        this.flightId = flightId;
        this.passengers = passengers;
    }

    public Booking(Long flightId, List<Passenger> passengers) {
        this.flightId = flightId;
        this.passengers = passengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
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
        return "Booking{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", passengers=" + passengers +
                '}';
    }
}
