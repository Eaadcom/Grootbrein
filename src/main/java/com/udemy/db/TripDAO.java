package com.udemy.db;

import com.udemy.api.Mapper.TripMapper;
import com.udemy.api.Trip;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TripMapper.class)
public interface TripDAO {

    //werkt
    @SqlQuery("select * from trip")
    List<Trip> getAll();

    @SqlQuery("select * from trip where user_id = :user_id")
    List<Trip> getTripsByUserId(@Bind("user_id") String user_id);

    //werkt
    @SqlUpdate("insert into trip (user_id, start_cords, end_cords, distance) values (:user_id, :start_cords, :end_cords, :distance)")
    int insert(@BindBean Trip trip);

    //delete trip binnen 20 sec ofzo en dan na de timer verdwijnt het knopje ofzo
    //werkt
    @SqlUpdate("delete from trip where trip_id = :trip_id")
    int deleteTripById(@Bind("trip_id") String trip_id);
}

