package com.chenk.abstractroutingdatasource.service;

import com.chenk.abstractroutingdatasource.pojo.User;

import java.util.List;

/**
 * @Author chenk
 * @create 2020/12/2 20:30
 */
public interface UserService {
    List<User> queryAll();

    User add(User user);
}
