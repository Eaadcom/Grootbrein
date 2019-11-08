package com.udemy.api.Mapper;

import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps resultset of user_has_project and creates new UserHasProject
 * @author Melissa Basgol
 */

public class UserHasProjectMapper implements ResultSetMapper<UserHasProject> {
    @Override
    public UserHasProject map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserHasProject(resultSet.getString("user_id"), resultSet.getString("project_id"));
    }
}

