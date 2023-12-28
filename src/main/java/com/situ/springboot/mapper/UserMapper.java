package com.situ.springboot.mapper;

import com.situ.springboot.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    void deleteById(Integer id);
    void add(User user);
}
