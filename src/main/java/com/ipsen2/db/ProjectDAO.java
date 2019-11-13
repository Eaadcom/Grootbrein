package com.ipsen2.db;

import com.ipsen2.api.Mapper.ProjectMapper;
import com.ipsen2.api.Project;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Has the queries to interact with the table "project" from the database
 * @author Melissa Basgol
 */

@RegisterMapper(ProjectMapper.class)
public interface ProjectDAO {


    //@SqlQuery("select * from project")
    //List<Project> getAll();

    /**
     * Gets the projects of a user
     * @author Melissa Basgol
     */
    @SqlQuery("SELECT *\n" +
            "    FROM   project p\n" +
            "    JOIN   user_has_project up ON p.project_id = up.project_id\n" +
            "    JOIN   user u ON u.user_id = up.user_id\n" +
            "    WHERE  u.user_id = :user_id ")
    List<Project> getProjectsByUserId(@Bind("user_id") String user_id);

    @SqlQuery("SELECT project_name\n" +
            "    FROM   project p\n" +
            "    JOIN   user_has_project up ON p.project_id = up.project_id\n" +
            "    JOIN   user u ON u.user_id = up.user_id\n" +
            "    WHERE  u.user_id = :user_id ")
    List<String> getProjectNamesByUserId(@Bind("user_id") String user_id);

    /**
     * Inserts project into the table "project"
     * @author Melissa Basgol
     */
    @SqlUpdate("insert into project (project_id, project_name) values (:project_id, :project_name)")
    int insert(@BindBean Project project);

}
