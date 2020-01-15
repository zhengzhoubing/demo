package com.bin.demo.service;

import com.bin.demo.dao.UserMapper;
import com.bin.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package: com.bin.demo.service
 * class: UserService
 * description: TODO用一句话描述该文件做什么
 * date 2020/1/15 15:44
 *
 * @author ZhengZhouBin
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryUser() {
        return userMapper.queryUser();
    }
}
