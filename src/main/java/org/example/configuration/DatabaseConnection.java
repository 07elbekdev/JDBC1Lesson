package org.example.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private final Connection connection;

    public DatabaseConnection() throws Exception {
        connection = DriverManager.getConnection(
                "right url postgresql",
                "user name you're postgresql",
                "and password" );
    }

    public Connection getConnection(){
        return connection;
    }

}
