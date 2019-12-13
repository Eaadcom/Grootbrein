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
    @SqlQuery("select * from car where user_id = :user_id")
    List<Car> getCarsOfUser(@Bind("user_id") String user_id);

    /**
     * Removes License where user is
     * @author Matthijs
     */
    @SqlQuery("delete from car where user_id = :user_id and license_plate = :license_plate")
    String deleteCarsOfUser(@Bind("user_id") String user_id,@Bind("license_plate") String license_plate);


    @SqlQuery("select * from car")
    List<Car> getAll();

    /**
     * Inserts new car into the table "car"
     * @author Melissa Basgol
     */

    @SqlUpdate("insert into car(license_plate, user_id) values (:license_plate, :user_id)")
    int insert(@BindBean Car car);

    @SqlUpdate("update user set license_plate = :license_plate where user_id = :user_id")
    int updateFunction(@BindBean Car car);
}
