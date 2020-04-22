package com.cms.yxf.service.impl;

import com.cms.yxf.exception.APIException;
import com.cms.yxf.model.converter.UserConverter;
import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.repository.entity.UserEntity;
import com.cms.yxf.repository.UserRepository;
import com.cms.yxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserDTO userDTO) {
        if(userDTO.getId() == 123) {
            throw new APIException("service错误");
        }
        return "保存成功";
    }

    @Override
    public Map<String, Map<String, UserEntity>> getusers() {
        List list = userRepository.findUsers();
        Map<String, Map<String, UserEntity>> map = new HashMap<>();
        for (Object row:list) {
            Object[] cells = (Object[]) row;
            Map<String, UserEntity> map1 = new HashMap<>();
            map1.put((String) cells[1], (UserEntity)cells[2]);
            map.put((String)cells[0], map1);
        }

        System.out.println("email:"+Optional.ofNullable(map).map(e -> e.get("1")).map(e -> e.get("1")).map(e -> e.getEmail()).orElse(""));

        return map;
    }
}
