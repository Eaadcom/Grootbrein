package com.udemy.api.Mapper;

import com.udemy.api.Person;
import com.udemy.api.Project;
import com.udemy.api.Trip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements ResultSetMapper<Trip> {
    @Override
    public Trip map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Trip(resultSet.getInt("tripId"), resultSet.getInt("userId"),resultSet.getInt("projectId"),
                resultSet.getString("timeStamp"), resultSet.getString("startCoord"),
                resultSet.getString("endCoord"),resultSet.getInt("km"));
    }
}