package com.cms.yxf.model.converter;

import org.springframework.core.convert.converter.Converter;

import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

// 提供给page分页转换DTO page.map(userConverter::convert)
@Component
public class UserConverter implements Converter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity source) {
        return UserDTO.convertToDTO(source);
    }
}
