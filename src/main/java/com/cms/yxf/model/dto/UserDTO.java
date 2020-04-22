package com.cms.yxf.model.dto;

import com.cms.yxf.repository.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotNull(message = "用户ID不能为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须为6-11字符")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    public static UserDTO convertToDTO(UserEntity source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(source.getEmail());
        return userDTO;
    }
}
