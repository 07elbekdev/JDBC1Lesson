package org.example.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private final Connection connection;

    public DatabaseConnection() throws Exception {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "iamnumber1");
    }

    public Connection getConnection() {
        return connection;
    }

}