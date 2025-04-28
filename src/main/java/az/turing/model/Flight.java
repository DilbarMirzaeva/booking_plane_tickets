package az.turing.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    private Long id;
    private String destination;
    private LocalDateTime dateTime;
    private int totalSeats;
    private int availableSeats;

    public Flight(Long id, String destination, LocalDateTime dateTime, int totalSeats, int availableSeats) {
        this.id = id;
        this.destination = destination;
        this.dateTime = LocalDateTime.parse(dateTime.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public Flight(String destination, LocalDateTime dateTime, int totalSeats, int availableSeats) {
        this.destination = destination;
        this.dateTime = dateTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public Flight(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", dateTime=" + dateTime +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
