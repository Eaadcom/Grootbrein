package com.udemy.DAO;

import com.udemy.core.mapper.ProjectMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ProjectMapper.class)

public interface ProjectDAO {
}
