package query;

public class FlightQuery {
    public static final String SELECT_FROM_FLIGHT ="SELECT * FROM flight";
    public static final String INSERT_BOOKING ="INSERT INTO flight(destination,date_time,total_seats,available_seats) VALUES(?,?,?,?)";
    public static final String UPDATE_FLIGHT="UPDATE flight SET destination=?,date_time=?,total_seats=?,available_seats=? WHERE id=?";
    public static final String DELETE_FLIGHT="DELETE FROM flight WHERE id=?";
    public static final String GET_BY_ID="SELECT * FROM flight WHERE id=?";
    public static final String EXISTS_TIME_DESTINATION="SELECT COUNT(*) FROM flights WHERE destination = ? AND time = ?";
}
