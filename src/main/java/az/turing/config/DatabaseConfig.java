package az.turing.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public Connection connection() throws SQLException {
        String url=System.getenv("jdbc:postgresql://localhost:5432/hotel_booking");
        String username=System.getenv("postgres");
        String password=System.getenv("Dlbarmirze5678.");
        return DriverManager.getConnection(url,username,password);
    }
}
