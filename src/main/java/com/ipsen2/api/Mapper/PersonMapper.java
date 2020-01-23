package com.ipsen2.api.Mapper;

import com.ipsen2.api.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps person resultset and creates new person
 * @author Melissa Basgol
 */

public class PersonMapper implements ResultSetMapper<Person> {

    @Override
    public Person map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Person(resultSet.getString("user_id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"),resultSet.getString("email"),
                resultSet.getString("password"), resultSet.getTimestamp("reg_date"), resultSet.getString("role"));
    }
}