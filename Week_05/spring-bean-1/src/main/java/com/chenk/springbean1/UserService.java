package com.chenk.springbean1;

/**
 * @Author chenk
 * @create 2020/11/17 14:36
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public String get(String name) {
        return userDao.get(name);
    }
}
