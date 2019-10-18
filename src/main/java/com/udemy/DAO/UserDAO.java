package com.udemy.DAO;

import com.udemy.core.Trip;
import com.udemy.core.User;
import com.udemy.core.mapper.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)

public interface UserDAO {
    //@SqlUpdate("create table employee (id int primary key, name varchar(100))")
    //void createEmployTable();



    @SqlUpdate("insert into user (userId,firstName,lastName,email,role) values (:userId,:firstName,:lastName,:email,:role)")
    int insertUser(@BindBean User user);


    @SqlUpdate("insert into car (userId,firstName,lastName,email,role) values (:userId,:firstName,:lastName,:email,:role)")
    int insertTrip(@BindBean Trip trip);

   // @SqlUpdate("insert into userhascar set carId = :carId where userId = :userId")
  //  int insertNewLicense(@BindBean Project car);

   // @SqlUpdate("insert into userhasproject set carId = :carId where userId = :userId")
   // int insertNewLicense(@BindBean Project car);

   // @SqlUpdate
    // "update userhascar set carId = :carId where userId = :userId" to update
   // @SqlUpdate("insert into car (userId,firstName,lastName,email,role) values (:userId,:firstName,:lastName,:email,:role)")
   // int insertProject(@BindBean Project car);

    @SqlQuery("select name from something where id = :id")
    String findNameById(@Bind("id") int id);
}

   // final UserDAO dao = database.onDemand(UserDAO.class);
