package com.situ.springboot.service;

import com.situ.springboot.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();
    void deleteById(Integer id);
    void add(User user);

    User selectById(Integer id);

    void update(User user);
    User loginIdentify(String name, String password);
}
