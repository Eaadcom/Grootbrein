package com.ipsen2.db;

import com.ipsen2.api.*;
import com.ipsen2.api.Mapper.CarMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Has the queries to interact with the table "car" from the database
 * @author Melissa Basgol
 */

@RegisterMapper(CarMapper.class)
public interface CarDAO {

    /**
     * Gets the license plates of a user
     * @author Melissa Basgol
     */
    @SqlQuery("select * from car where user_id = :userId")
    List<Car> getCarsOfUser(@Bind("userId") String userId);


    @SqlQuery("select * from car")
    List<Car> getAll();

    /**
     * Inserts new car into the table "car"
     * @author Melissa Basgol
     */

    @SqlUpdate("delete from car where license_id = :license_id")
    int deleteById(@Bind("license_id") String license_id);

    @SqlUpdate("insert into car(license_plate, trade_name, user_id) values (:licensePlate, :tradeName, :userId)")
    int insert(@BindBean Car car);



}
