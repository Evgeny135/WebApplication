package com.app.coursesapp.dao;

import com.app.coursesapp.entity.Airport;
import com.app.coursesapp.entity.Ticket;
import com.app.coursesapp.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportDao implements Dao<String, Airport>{

    private static final AirportDao INSTANCE = new AirportDao();
    private String FIND_AIRPORT_BY_CODE = """
            SELECT *
            FROM airport
            WHERE code=?
            """;



    public List<Airport> findAllByCode(String code) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_AIRPORT_BY_CODE)) {
            preparedStatement.setObject(1, code);

            var resultSet = preparedStatement.executeQuery();
            List<Airport> airports = new ArrayList<>();
            while (resultSet.next()) {
                airports.add(buildAirport(resultSet));
            }

            return airports;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public static AirportDao getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Airport> findAll() {
        return null;
    }

    @Override
    public Optional<Airport> findById(String id) throws SQLException {
        return Optional.empty();
    }

    private Airport buildAirport(ResultSet resultSet){
        try {
            return new Airport(
                    resultSet.getObject("code",String.class),
                    resultSet.getObject("country",String.class),
                    resultSet.getObject("city",String.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void update(Airport entity) {

    }

    @Override
    public Airport save(Airport entity) {
        return null;
    }

    private AirportDao(){}
}
