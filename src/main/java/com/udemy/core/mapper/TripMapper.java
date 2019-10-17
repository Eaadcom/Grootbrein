package com.udemy.core.mapper;

import com.udemy.core.Car;
import com.udemy.core.Trip;
import com.udemy.core.Trip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements ResultSetMapper<Trip> {
    public Trip map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Trip(resultSet.getLong("ID"), resultSet.getString("FIRSTNAME"),
                resultSet.getString("LASTNAME"),resultSet.getString("EMAIL")
                resultSet.getString("ROLE"));
    }
}
