package com.situ.springboot.service;

import com.situ.springboot.pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> selectAll();
}
