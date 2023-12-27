package com.situ.springboot.service.impl;

import com.situ.springboot.mapper.UserMapper;
import com.situ.springboot.pojo.User;
import com.situ.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {

        return userMapper.selectAll();
    }
}