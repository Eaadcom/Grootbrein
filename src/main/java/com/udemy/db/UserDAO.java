package com.udemy.db;
import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Person;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(PersonMapper.class)
public interface UserDAO {

    @SqlQuery("select * from user")
    List<Person> getAll();

    @SqlUpdate("delete from user where user_id = :user_id")
    int deleteById(@Bind("user_id") String user_id);

    @SqlQuery("select * from user where user_id = :user_id")
    Person findById(@Bind("user_id") String user_id);

    @SqlQuery("select * from user where email = :email")
    Person findByEmail(@Bind("email") String email);

    @SqlUpdate("insert into user (user_id, first_name, last_name, email, password) values " +
            "(:user_id, :first_name, :last_name, :email, :password)")
    int insert(@BindBean Person user);

    @SqlUpdate("update user set email = :email where user_id = :user_id")
    int updateEmail(@BindBean Person user);

}
