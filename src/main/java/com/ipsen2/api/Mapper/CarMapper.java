package com.ipsen2.api.Mapper;

import com.ipsen2.api.Car;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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