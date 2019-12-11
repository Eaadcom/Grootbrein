package com.ipsen2.api.Mapper;

import com.ipsen2.api.Login;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps login variables resultset and creates new login
 * @author Melissa Basgol
 */

public class LoginMapper implements ResultSetMapper<Login> {

    @Override
    public Login map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Login(resultSet.getString("email"),
                resultSet.getString("password"));
    }
}
