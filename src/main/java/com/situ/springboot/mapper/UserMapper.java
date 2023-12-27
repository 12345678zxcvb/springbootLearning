package com.situ.springboot.mapper;

import com.situ.springboot.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
