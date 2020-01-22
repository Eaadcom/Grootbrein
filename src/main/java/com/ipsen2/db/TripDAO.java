package com.ipsen2.db;

import com.ipsen2.api.Mapper.TripMapper;
import com.ipsen2.api.Trip;
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

    @SqlQuery("select * from trip")
    List<Trip> getAll();

    /**
     * Gets the trips of a user
     * @author Melissa Basgol
     */
    @SqlQuery("SELECT *\n" +
            "    FROM   trip t\n" +
            "    JOIN   project p ON p.project_id = t.project_id\n" +
            "    WHERE  t.user_id = :userId ")
    List<Trip> getTripsByUserId(@Bind("userId") String userId);


    //"select * from trip where user_id = :userId"
    /**
     * Inserts a trip into the table "trip"
     * @author Melissa Basgol, Edward Deen
     */
    //werkt
    @SqlUpdate("insert into trip (user_id, start_coordinates, end_coordinates, distance, license_plate, project_id) values (:userId, :startCords, :endCords, :distance, :licensePlate, :projectId)")
    int insert(@BindBean Trip trip);

    @SqlUpdate("delete from trip where trip_id = :tripId")
    int deleteTripById(@Bind("tripId") String tripId);
}
