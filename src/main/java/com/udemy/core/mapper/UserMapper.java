package com.udemy.core.mapper;

import com.udemy.core.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {

        public User map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
        {
            return new User(resultSet.getLong("ID"), resultSet.getString("FIRSTNAME"),
                    resultSet.getString("LASTNAME")resultSet.getString("EMAIL")
                    resultSet.getString("ROLE"));
        }
}
