package com.cms.user.domian.converter;

import org.springframework.core.convert.converter.Converter;

import com.cms.user.domian.dto.UserDTO;
import com.cms.user.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

// 提供给page分页转换DTO page.map(userConverter::convert)
@Component
public class UserConverter implements Converter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity source) {
        return UserDTO.convertToDTO(source);
    }
}
