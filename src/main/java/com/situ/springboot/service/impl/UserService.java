package com.situ.springboot.service.impl;

import com.situ.springboot.mapper.UserMapper;
import com.situ.springboot.pojo.User;
import com.situ.springboot.service.IUserService;
import com.situ.springboot.util.PageInfo;
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
    @Override
    public void add(User user){
        userMapper.add(user);
    }
    @Override
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }
    @Override
    public void update(User user){
        userMapper.update(user);
    }
    @Override

    public User loginIdentify(String name, String password) {
        return userMapper.loginIdentify(name,password);
    }
    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        // limit
        int offset = (pageNo - 1) * pageSize;
        //查找当前也数据
        List<User> list = userMapper.selectByPage(offset, pageSize);
        //查找总的数量，目的是为了算总的页数totalPage
        int totalCount = userMapper.selectTotalCount();
        int totalPage = (int)Math.ceil((double) totalCount / pageSize);

        return new PageInfo(list, totalPage, pageNo, pageSize);
    }
}
