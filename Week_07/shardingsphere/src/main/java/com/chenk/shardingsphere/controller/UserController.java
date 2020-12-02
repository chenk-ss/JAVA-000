package com.chenk.shardingsphere.controller;

import com.chenk.shardingsphere.pojo.User;
import com.chenk.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @Author chenk
 * @create 2020/12/2 21:29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/queryAll")
    List<User> queryAll(){
        return userService.queryAll();
    }

    @GetMapping("/add")
    User add(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(user.getId().substring(0,5));
        return userService.add(user);
    }
}
