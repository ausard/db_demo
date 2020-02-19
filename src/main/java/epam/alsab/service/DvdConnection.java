package epam.alsab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DvdConnection {
    private final String url = "jdbc:postgresql://18.196.55.0:5432/dvdrental";
    private final String user = "postgres";
    private final String password = "pg";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
