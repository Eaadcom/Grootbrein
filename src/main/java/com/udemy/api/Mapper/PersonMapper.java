package com.udemy.api.Mapper;

import com.udemy.api.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements ResultSetMapper<Person> {

    @Override
    public Person map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Person(resultSet.getString("user_id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"),resultSet.getString("email"),
                resultSet.getString("password"), resultSet.getTimestamp("reg_date"));
    }

}