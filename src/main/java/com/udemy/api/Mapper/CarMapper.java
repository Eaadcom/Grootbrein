package com.udemy.api.Mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udemy.api.Car;
import com.udemy.api.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Maps car resultset and creates new Car
 * @author Melissa Basgol
 */

public class CarMapper implements ResultSetMapper<Car> {

    @Override
    public Car map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Car(resultSet.getInt("license_id"),resultSet.getString("license_plate"),
                resultSet.getString("user_id"),resultSet.getTimestamp("reg_date"));
    }

}