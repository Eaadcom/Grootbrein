package com.udemy.core.mapper;


import com.udemy.core.Project;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements ResultSetMapper<Project> {
    public Project map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Project(resultSet.getLong("ID"), resultSet.getString("FIRSTNAME"),
                resultSet.getString("LASTNAME")resultSet.getString("EMAIL")
                resultSet.getString("ROLE"));
    }
}
