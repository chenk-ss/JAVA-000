package com.chenk.springbean3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chenk
 * @create 2020/11/17 14:36
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public String get(String name) {
        return userDao.get(name);
    }
}
