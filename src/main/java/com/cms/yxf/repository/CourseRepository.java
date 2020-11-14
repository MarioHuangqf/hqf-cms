package com.cms.yxf.repository;

import com.cms.yxf.repository.entity.CourseEntity;
import com.cms.yxf.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> , JpaSpecificationExecutor<UserEntity> {

    CourseEntity findById(int id);
}
