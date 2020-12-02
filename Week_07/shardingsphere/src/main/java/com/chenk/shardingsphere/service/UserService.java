package com.chenk.shardingsphere.service;

import com.chenk.shardingsphere.pojo.User;

import java.util.List;

/**
 * @Author chenk
 * @create 2020/12/2 21:29
 */
public interface UserService {
    List<User> queryAll();

    User add(User user);
}
