package az.turing.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightDto {
    private String destination;
    private LocalDateTime date;
    private int totalSeats;
    private int passengerCount;

    public FlightDto(String destination, LocalDateTime date,int totalSeats, int passengerCount) {
        this.destination = destination;
        this.date = LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.passengerCount = passengerCount;
        this.totalSeats=totalSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "destination='" + destination + '\'' +
                ", date=" + date +
                ", totalSeats=" + totalSeats +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
