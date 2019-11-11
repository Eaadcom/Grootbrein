package com.udemy.db;

import com.udemy.api.Mapper.TripMapper;
import com.udemy.api.Trip;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Has the queries to interact with the table "trip" from the database
 * @author Melissa Basgol
 */

@RegisterMapper(TripMapper.class)
public interface TripDAO {

    //werkt
    @SqlQuery("select * from trip")
    List<Trip> getAll();

    /**
     * Gets the trips of a user
     * @author Melissa Basgol
     */
    @SqlQuery("select * from trip where user_id = :user_id")
    List<Trip> getTripsByUserId(@Bind("user_id") String user_id);

    /**
     * Inserts a trip into the table "trip"
     * @author Melissa Basgol
     */
    //werkt
    @SqlUpdate("insert into trip (user_id, start_cords, end_cords, distance, project_id) values (:user_id, :start_cords, :end_cords, :distance, :project_id)")
    int insert(@BindBean Trip trip);

    //@SqlUpdate("delete from trip where trip_id = :trip_id")
    //int deleteTripById(@Bind("trip_id") String trip_id);
}

