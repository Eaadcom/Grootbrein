package com.udemy.db;

import com.udemy.api.Mapper.TripMapper;
import com.udemy.api.Person;
import com.udemy.api.Project;
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

    //werkt
    @SqlUpdate("insert into trip values (:tripId, :userId, :projectId, :timeStamp, :startCoord, :endCoord, :km)")
    int insert(@BindBean Trip trip);

    //delete trip binnen 20 sec ofzo en dan na de timer verdwijnt het knopje ofzo
    //werkt
    @SqlUpdate("delete from trip where tripId = :tripId")
    int deleteTripById(@Bind("tripId") int tripId);
}