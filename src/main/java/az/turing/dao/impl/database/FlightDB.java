package az.turing.dao.impl.database;

import az.turing.config.DatabaseConfig;
import az.turing.dao.impl.inter.FlightDao;
import az.turing.model.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static query.FlightQuery.*;

public class FlightDB extends FlightDao {

    private final DatabaseConfig config;

    public FlightDB(DatabaseConfig config) {
        this.config = config;
    }

    @Override
    public boolean existsTimeAndDestination(String destination, LocalDateTime time) {
        try(Connection connection= config.connection()){
            PreparedStatement ps=connection.prepareStatement(EXISTS_TIME_DESTINATION);
            ps.setString(1,destination);
            ps.setTimestamp(2, Timestamp.valueOf(time));
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights=new ArrayList<>();
        try(Connection connection= config.connection()){
            PreparedStatement ps=connection.prepareStatement(SELECT_FROM_FLIGHT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Flight flight=new Flight();
                findFlight(rs,flight);
                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    private void findFlight(ResultSet rs,Flight flight) throws SQLException {
        flight.setId(rs.getLong("flight_id"));
        flight.setDestination(rs.getString("destination"));
        flight.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
        flight.setTotalSeats(rs.getInt("total_seats"));
        flight.setAvailableSeats(rs.getInt("available_seats"));
    }

    @Override
    public Flight create(Flight entity) {
        try(Connection connection= config.connection()){
            PreparedStatement ps=connection.prepareStatement(INSERT_BOOKING);
            ps.setString(1, entity.getDestination());
            ps.setTimestamp(2, Timestamp.valueOf(entity.getDateTime()));
            ps.setInt(3,entity.getTotalSeats());
            ps.setInt(4,entity.getAvailableSeats());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void update(Flight entity) {
        try(Connection connection= config.connection()){
            PreparedStatement ps=connection.prepareStatement(UPDATE_FLIGHT);
            ps.setString(1,entity.getDestination());
            ps.setTimestamp(2,Timestamp.valueOf(entity.getDateTime()));
            ps.setInt(3,entity.getTotalSeats());
            ps.setInt(4,entity.getAvailableSeats());
            ps.setLong(5,entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection= config.connection()) {
            PreparedStatement ps= connection.prepareStatement(DELETE_FLIGHT);
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flight getById(Long id) {
        Flight flight=new Flight();
        try(Connection connection=config.connection()){
            PreparedStatement ps=connection.prepareStatement(GET_BY_ID);
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                findFlight(rs,flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flight;
    }
}
