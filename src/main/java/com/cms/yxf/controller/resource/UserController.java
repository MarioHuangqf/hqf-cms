package com.cms.yxf.controller.resource;

import com.cms.yxf.model.dto.UserDTO;
import com.cms.yxf.repository.CourseRepository;
import com.cms.yxf.repository.UserRepository;
import com.cms.yxf.repository.entity.CourseEntity;
import com.cms.yxf.repository.entity.UserEntity;
import com.cms.yxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid UserDTO userDTO) {
        // 去掉BindingResult，交给全局异常处理
//        for (ObjectError objectError : bindingResult.getAllErrors()) {
//            return objectError.getDefaultMessage();
//        }
        return userService.addUser(userDTO);
    }

    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        return userService.getUsers();
    }

    @GetMapping("/test")
    @Transactional
    public void test() {
        UserEntity userEntity = new UserEntity();

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(2L);
        List list = new ArrayList();
//        list.add(courseEntity);
        userEntity.setCourseEntities(list);
        userRepository.save(userEntity);
    }

    // 获取用户分页
    @PostMapping()
    public Page<UserDTO> getUserByPage(
//            @PageableDefault(size = 1, page = 0, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
//              Pageable pageable) {
                @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        Pageable pageable = null;

        if (page == null || size == null ) {
            pageable = Pageable.unpaged();
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<UserDTO> userByPage = userService.getUserByPage(pageable);
        return userByPage;
    }
}
