package com.udemy.api.Mapper;

import com.udemy.api.Person;
import com.udemy.api.Project;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements ResultSetMapper<Project> {

    @Override
    public Project map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Project(resultSet.getInt("project_id"),
                resultSet.getString("project_name"));
    }
}