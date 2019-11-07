package com.udemy.db;

import com.udemy.api.Mapper.PersonMapper;
import com.udemy.api.Mapper.ProjectMapper;
import com.udemy.api.Person;
import com.udemy.api.Project;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ProjectMapper.class)
public interface ProjectDAO {

    @SqlQuery("select * from project")
    List<Project> getAll();

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

}
