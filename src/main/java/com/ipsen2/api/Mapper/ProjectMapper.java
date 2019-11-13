package com.ipsen2.api.Mapper;

import com.ipsen2.api.Project;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps project resultset and creates new project
 * @author Melissa Basgol
 */

public class ProjectMapper implements ResultSetMapper<Project> {

    @Override
    public Project map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Project(resultSet.getInt("project_id"),
                resultSet.getString("project_name"));
    }
}