package com.ipsen2.db;
import com.ipsen2.api.Mapper.PersonMapper;
import com.ipsen2.api.Person;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Has the queries to interact with the table "user" from the database
 * @author Melissa Basgol
 */

@RegisterMapper(PersonMapper.class)
public interface UserDAO {

    @SqlQuery("select * from user")
    List<Person> getAll();

    @SqlUpdate("delete from user where user_id = :userId")
    int deleteById(@Bind("userId") String userId);

    @SqlQuery("select * from user where user_id = :userId")
    Person findById(@Bind("userId") String userId);

    /**
     * Gets a user with the email of the user.
     * @author Melissa Basgol
     */
    @SqlQuery("select * from user where email = :email")
    Person findByEmail(@Bind("email") String email);

    /**
     * Inserts a user into the table "user"
     * @author Melissa Basgol
     */
    @SqlUpdate("insert into user (user_id, first_name, last_name, email, password, role) values " +
            "(:userId, :firstName, :lastName, :email, :password, :role)")
    int insert(@BindBean Person user);

    @SqlUpdate("update user set email = :email where userId = :userId")
    int updateEmail(@BindBean Person user);

}
