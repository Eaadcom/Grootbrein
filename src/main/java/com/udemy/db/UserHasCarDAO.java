package com.udemy.db;

import com.udemy.api.Mapper.UserHasCarMapper;
import com.udemy.api.Mapper.UserHasProjectMapper;
import com.udemy.api.Project;
import com.udemy.api.Trip;
import com.udemy.api.UserHasCar;
import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(UserHasCarMapper.class)
public interface UserHasCarDAO {

    @SqlQuery("select *  from userhascar where userId = :userId")
    List<UserHasCar> getCarsOfUser(@Bind("userId") int userId);

    //werkt
    @SqlQuery("select * from userhascar")
    List<UserHasCar> getAll();

    //toevoegen werkt
    @SqlUpdate("insert into userhascar values (:userId, :licensePlate)")
    int insert(@BindBean UserHasCar userHasCar);

    //inserten met userid van de header etc. met authenticatie kan dat gedaanworden
}
