package az.turing.dao.impl.file;

import az.turing.dao.impl.inter.FlightDao;
import az.turing.model.Flight;
import az.turing.util.FileUtil;

import java.time.LocalDateTime;
import java.util.List;

public class FlightFile extends FlightDao {
    
    private final FileUtil<Flight> flightFileUtil;

    public FlightFile(FileUtil<Flight> flightFileUtil) {
        this.flightFileUtil = flightFileUtil;
    }

    @Override
    public boolean existsTimeAndDestination(String destination, LocalDateTime time) {
        return flightFileUtil.readFromFile()
                .stream().anyMatch(f->f.getDestination().equals(destination)||f.getDateTime().equals(time));
    }

    @Override
    public List<Flight> getAll() {
        return flightFileUtil.readFromFile();
    }

    @Override
    public Flight create(Flight entity) {
        List<Flight> flights=flightFileUtil.readFromFile();
        flights.add(entity);
        flightFileUtil.writeToFile(flights);
        return entity;
    }

    @Override
    public void update(Flight entity) {
        List<Flight> flights=flightFileUtil.readFromFile();
        flights.stream()
                .filter(f->f.getId().equals(entity.getId()))
                .findFirst()
                .ifPresent(f->{
                    f.setId(entity.getId());
                    f.setDestination(entity.getDestination());
                    f.setAvailableSeats(entity.getAvailableSeats());
                    f.setTotalSeats(entity.getTotalSeats());
                    f.setDateTime(entity.getDateTime());
                    flightFileUtil.writeToFile(flights);
        });
    }

    @Override
    public void delete(Long id) {
        List<Flight> flights=flightFileUtil.readFromFile();
        flights.removeIf(flight -> flight.getId().equals(id));
        flightFileUtil.writeToFile(flights);

    }

    @Override
    public Flight getById(Long id) {
        return flightFileUtil.readFromFile().stream().filter(f->f.getId().equals(id)).findFirst().orElse(null);
    }
}
