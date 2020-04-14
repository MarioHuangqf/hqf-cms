package com.cms.yxf.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    //欢迎页面
    @RequestMapping("/helloPage")
    public String hello(){
        return "hello";
    }

    //登录页面
    @RequestMapping("/loginPage")
    public String login(){
        return "login";
    }

    //主页
    @RequestMapping("/home")
    public String index(Model model){
        model.addAttribute("msg","主页");
        return "home";
    }

}
