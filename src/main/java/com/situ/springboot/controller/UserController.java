package com.situ.springboot.controller;

import com.situ.springboot.mapper.UserMapper;
import com.situ.springboot.pojo.User;
import com.situ.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        userService.deleteById(id);
        return "redirect:/user/selectAll";
    }
    @RequestMapping("/selectAll")
    //@ResponseBody//return json

    public String selectAll(Model model) {

        System.out.println("UserController.selectAll");
        List<User>list = userService.selectAll();
        //store data to memory
        model.addAttribute("list",list);
        //转发到user——list界面
        return "user_list";
    }
}
