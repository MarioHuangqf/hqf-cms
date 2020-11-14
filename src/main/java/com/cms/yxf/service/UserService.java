package com.cms.yxf.service;


import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.repository.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {

    String addUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    Page<UserDTO> getUserByPage(Pageable pageable);
}
