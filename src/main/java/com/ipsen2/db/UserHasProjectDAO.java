package com.ipsen2.db;

import com.ipsen2.api.Mapper.UserHasProjectMapper;
import com.ipsen2.api.UserHasProject;
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


    /**
     * Returns a list with the projects of a user
     * @author Melissa Basgol
     */
    @SqlQuery("select * from user_has_project")
    List<UserHasProject> getAll();

    /**
     * Inserts into table "user_has_project"
     * @author Melissa Basgol
     */
    @SqlUpdate("insert into user_has_project (user_id, project_id) values " +
            "(:userId, :projectId)")
    int insert(@BindBean UserHasProject userHasProject);

    @SqlUpdate("delete from user_has_project where user_id = :userId and project_id = :projectId")
    int deleteById(@Bind("userId") String userId, @Bind("projectId") int projectId);

}
