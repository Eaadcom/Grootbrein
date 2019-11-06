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
            "    JOIN   userhasproject up ON p.projectId = up.projectId\n" +
            "    JOIN   user u ON u.userId = up.userId\n" +
            "    WHERE  u.userId = :userId ")
    List<Project> getProjectsByUserId(@Bind("userId") int userId);

    @SqlQuery("SELECT project_name\n" +
            "    FROM   project p\n" +
            "    JOIN   userhasproject up ON p.projectId = up.projectId\n" +
            "    JOIN   user u ON u.userId = up.userId\n" +
            "    WHERE  u.userId = :userId ")
    List<String> getProjectNamesByUserId(@Bind("userId") int userId);

}
