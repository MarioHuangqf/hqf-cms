package com.cms.user.service;


import com.cms.user.domian.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    String addUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    Page<UserDTO> getUserByPage(Pageable pageable);
}
