package com.cms.yxf.controller.resource;

import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid UserDTO userDTO) {
        // 去掉BindingResult，交给全局异常处理
//        for (ObjectError objectError : bindingResult.getAllErrors()) {
//            System.out.println(objectError.getDefaultMessage());
//            return objectError.getDefaultMessage();
//        }
        return userService.addUser(userDTO);
    }

    @GetMapping("/getUser")
    public UserDTO getUser() {
        UserDTO userDTO = UserDTO.builder()
                                .id(1L)
                                .account("111111")
                                .password("111111")
                                .email("874887643@qq.com")
                                .build();
        return userDTO;
    }
}
