package com.cms.yxf.service;


import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.model.entity.UserEntity;

import java.util.Map;

public interface UserService {

    String addUser(UserDTO userDTO);

    Map<String, Map<String, UserEntity>> getusers();
}
