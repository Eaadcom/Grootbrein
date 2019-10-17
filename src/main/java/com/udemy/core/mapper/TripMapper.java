package com.udemy.core.mapper;

import com.udemy.api.Trip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements ResultSetMapper<Trip> {
    public Trip map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {/*
            return new User(resultSet.getLong("ID"), resultSet.getString("FIRSTNAME"),
                    resultSet.getString("LASTNAME"),resultSet.getString("EMAIL"),
                    resultSet.getString("ROLE"));
        */
        return null;}
}
