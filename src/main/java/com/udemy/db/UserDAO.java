package com.udemy.db;
import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Person;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(PersonMapper.class)
public interface UserDAO {

    @SqlUpdate("CREATE TRIGGER after_user_deleted_id " +
            "  AFTER DELETE ON user " +
            "  FOR EACH ROW " +
            "BEGIN " +
            "  DELETE FROM userhasproject where userId = OLD.userId; " +
            "END")
    void createTrigger();

    @SqlQuery("select * from user")
    List<Person> getAll();


    @SqlUpdate("create table something (id int primary key, name varchar(100))")
    void createSomethingTable();

    @SqlUpdate("delete from user where userId = :userId")
    int deleteById(@Bind("userId") int userId);

    @SqlQuery("select * from user where userId = :userId")
    Person findById(@Bind("userId") int userId);

    @SqlQuery("select * from user where email = :email")
    Person findByEmail(@Bind("email") String email);

    @SqlUpdate("insert into user (user_id, first_name, last_name, email, password) values " +
            "(:user_id, :first_name, :last_name, :email, :password)")
    int insert(@BindBean Person user);

    @SqlUpdate("update user set email = :email where userId = :userId")
    int updateEmail(@BindBean Person user);

}
