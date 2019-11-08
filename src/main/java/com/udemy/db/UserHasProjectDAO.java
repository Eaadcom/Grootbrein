package com.udemy.db;

import com.udemy.api.Mapper.UserHasProjectMapper;
import com.udemy.api.Person;
import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Has the queries to interact with the table "userhasproject" from the database
 * @author Melissa Basgol
 */

@RegisterMapper(UserHasProjectMapper.class)
public interface UserHasProjectDAO {

//insert voor de employer

    @SqlQuery("select * from user_has_project")
    List<UserHasProject> getAll();

    @SqlUpdate("insert into user_has_project (user_id, project_id) values " +
            "(:user_id, :project_id)")
    int insert(@BindBean UserHasProject userHasProject);

    @SqlUpdate("delete from user_has_project where user_id = :user_id and project_id = :project_id")
    int deleteById(@Bind("user_id") String user_id, @Bind("project_id") String project_id);

    //@Bind("user_id") String user_id, @Bind("project_id") String project_id
}
