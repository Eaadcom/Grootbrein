package com.udemy.db;

import com.udemy.api.*;
import com.udemy.api.Mapper.CarMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;


@RegisterMapper(CarMapper.class)
public interface CarDAO {

    @SqlQuery("select license_plate  from car where user_id = :user_id")
    List<String> getCarsOfUser(@Bind("user_id") String user_id);

    //werkt
    @SqlQuery("select * from car")
    List<Car> getAll();

    //toevoegen werkt
    @SqlUpdate("insert into car(license_plate, user_id) values (:license_plate, :user_id)")
    int insert(@BindBean Car car);

}
