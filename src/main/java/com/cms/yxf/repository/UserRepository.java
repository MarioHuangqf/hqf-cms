package com.cms.yxf.repository;

import com.cms.yxf.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> , JpaSpecificationExecutor<UserEntity> {

    List<UserEntity> findAll();

    @Query("select u.name,u.address,u from UserEntity u group by u.name,u.address")
    List findUsers();
}
