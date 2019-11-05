package com.udemy.db;

import com.udemy.api.Mapper.UserHasProjectMapper;
import com.udemy.api.UserHasProject;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(UserHasProjectMapper.class)
public interface UserHasProjectDAO {

    //@SqlQuery("select *  from (select projectId from userhasproject where userId = :userId")
    //List<UserHasProject> getProjectsOfUser(@Bind("userId") int userId);

//"select project.name, userhasproject.userId from project, userhasproject where userhasproject.userId = :userId " +
//            "and userhasproject.projectId = project.projectId"



}
