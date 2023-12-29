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
    @Override
    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }
    public void add(User user){
        userMapper.add(user);
    }
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }
    public void update(User user){
        userMapper.update(user);
    }

}
