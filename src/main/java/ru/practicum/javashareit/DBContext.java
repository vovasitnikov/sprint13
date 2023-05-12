package ru.practicum.javashareit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBContext {

    @Bean
    public Connection getNewConection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "root");
    }
}
