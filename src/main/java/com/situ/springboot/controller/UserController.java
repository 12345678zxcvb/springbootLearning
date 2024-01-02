package com.situ.springboot.controller;

import com.situ.springboot.pojo.User;
import com.situ.springboot.service.impl.UserService;
import com.situ.springboot.util.PageInfo;
import com.situ.springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/login")
    @ResponseBody //返回json格式数据要加这个注解 @ResponseBody
    public Result login(String name, String password,String code,HttpSession session) {
        String codeInSession = (String) session.getAttribute("codeInSession");
        if (!codeInSession.equalsIgnoreCase(code)) {
            return Result.error("验证码错误");
        }
        User user = userService.loginIdentify(name, password);
        if (user != null) {
            if (user.getStatus() == 0) {
                //这个用户禁用
                return Result.error("该用户已经禁用");
            }
            session.setAttribute("user", user);

            return Result.ok("登录成功");
        } else {
            //登录失败，跳转到登录界面
            return Result.error("用户名或密码错误");
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
        return "redirect:/user/selectByPage";
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
        return "redirect:/user/selectByPage";
    }
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);

        return "redirect:/user/selectByPage";
    }

    //@ResponseBody//return json

    @RequestMapping("/selectByPage")
    public String selectByPage(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "5") Integer pageSize, Model model) {
        System.out.println("UserController.selectByPage");
        PageInfo pageInfo = userService.selectByPage(pageNo, pageSize);

        //把pageInfo数据放到内存里面
        model.addAttribute("pageInfo", pageInfo);
        //转发到user_list界面展示
        return "user_list";
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
