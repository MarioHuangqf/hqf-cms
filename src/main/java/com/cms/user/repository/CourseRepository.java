package com.cms.user.repository;

import com.cms.user.repository.entity.CourseEntity;
import com.cms.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> , JpaSpecificationExecutor<UserEntity> {

    CourseEntity findById(int id);
}
