package com.ipsen2.api.Mapper;

import com.ipsen2.api.Trip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps trip resultset and creates new trip
 * @author Melissa Basgol
 */

public class TripMapper implements ResultSetMapper<Trip> {
    @Override
    public Trip map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Trip(resultSet.getInt("trip_id"), resultSet.getString("user_id"),
                resultSet.getTimestamp("reg_date"),
                resultSet.getString("start_coordinates"), resultSet.getString("end_coordinates"),
                resultSet.getInt("distance"),resultSet.getString("license_plate"),
                resultSet.getInt("project_id"));
    }
}
