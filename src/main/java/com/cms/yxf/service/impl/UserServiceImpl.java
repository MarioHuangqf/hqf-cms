package com.cms.yxf.service.impl;

import com.cms.yxf.exception.APIException;
import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public String addUser(UserDTO userDTO) {
        if(userDTO.getId() == 123) {
            throw new APIException("service错误");
        }
        return "保存成功";
    }
}
