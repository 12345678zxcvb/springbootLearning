package com.situ.springboot.controller;

import com.situ.springboot.mapper.UserMapper;
import com.situ.springboot.pojo.User;
import com.situ.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/selectAll")
    @ResponseBody

    public List<User> selectAll() {

        System.out.println("UserController.selectAll");
        return userService.selectAll();
    }
}
