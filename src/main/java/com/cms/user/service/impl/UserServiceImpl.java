package com.cms.user.service.impl;

import com.cms.user.exception.APIException;
import com.cms.user.domian.converter.UserConverter;
import com.cms.user.domian.dto.UserDTO;
import com.cms.user.repository.entity.UserEntity;
import com.cms.user.repository.UserRepository;
import com.cms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired UserConverter userConverter;

    @Override
    public String addUser(UserDTO userDTO) {
        if(userDTO.getId() == 123) {
            throw new APIException("service错误");
        }
        return "保存成功";
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(u -> UserDTO.convertToDTO(u)).collect(Collectors.toList());
    }

    @Override
    public Page<UserDTO> getUserByPage(Pageable pageable) {
        Page<UserEntity> page = userRepository.findAll(pageable);
        return page.map(userConverter::convert);
    }
}
