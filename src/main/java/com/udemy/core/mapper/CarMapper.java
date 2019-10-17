package com.udemy.core.mapper;

import com.udemy.core.Car;
        import org.skife.jdbi.v2.StatementContext;
        import org.skife.jdbi.v2.tweak.ResultSetMapper;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class CarMapper implements ResultSetMapper<Car> {
    public Car map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Car(resultSet.getLong("ID"), resultSet.getString("FIRSTNAME"),
                resultSet.getString("LASTNAME")resultSet.getString("EMAIL")
                resultSet.getString("ROLE"));
    }
}
