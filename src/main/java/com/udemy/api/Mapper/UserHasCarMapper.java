package com.udemy.api.Mapper;

import com.udemy.api.UserHasCar;
import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHasCarMapper implements ResultSetMapper<UserHasCar> {
    @Override
    public UserHasCar map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserHasCar(resultSet.getInt("userId"), resultSet.getString("licensePlate"));
    }
}
