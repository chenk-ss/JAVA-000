package com.chenk.springbean2;

import org.springframework.stereotype.Repository;

/**
 * @Author chenk
 * @create 2020/11/17 14:36
 */
@Repository
public class UserDao {
    public String get(String name){
        return "Hello " + name;
    }
}
