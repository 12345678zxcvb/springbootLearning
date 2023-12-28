package com.situ.springboot.service;

import com.situ.springboot.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();
    void deleteById(Integer id);
    void add(User user);
}
