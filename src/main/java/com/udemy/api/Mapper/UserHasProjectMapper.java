package com.udemy.api.Mapper;

import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHasProjectMapper implements ResultSetMapper<UserHasProject> {
    @Override
    public UserHasProject map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserHasProject(resultSet.getInt("user_id"), resultSet.getInt("project_id"));
    }
}

