package com.udemy.DAO;

import com.udemy.api.Car;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;


public interface CarDAO{

    @SqlQuery("select * from car")
    List<Car> getAll();

    //@SqlQuery("select * from PERSON where ID = :id")
   // Person findById(@Bind("id") int id);

    @SqlUpdate("insert into car (userId,firstName,lastName,email,role) values (:userId,:firstName,:lastName,:email,:role)")
    int insertCar(@BindBean Car car);

}
