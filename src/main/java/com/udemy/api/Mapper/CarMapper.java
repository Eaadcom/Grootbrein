package com.udemy.api.Mapper;

import com.udemy.api.Car;
import com.udemy.api.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements ResultSetMapper<Car> {

    @Override
    public Car map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Car(resultSet.getInt("userId"), resultSet.getString("licensePlate"));
    }
}