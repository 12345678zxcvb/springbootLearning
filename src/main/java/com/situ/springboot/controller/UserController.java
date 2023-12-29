package com.situ.springboot.controller;

import com.situ.springboot.pojo.User;
import com.situ.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user_login";
    }
    @RequestMapping("login")
    public String login(String name, String password, HttpSession session){
        User user = userService.loginIdentify(name,password);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/";
        }else {
            return "redirect:/user/toLogin";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/toLogin";
    }
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        userService.deleteById(id);
        return "redirect:/user/selectAll";
    }
    @RequestMapping("/toAdd")
    public String toadd(){
        return "user_toadd";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Model model) {
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/selectAll";
    }
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);

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
