package com.chenk.springstartertest;

import com.chenk.springstarter.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author chenk
 * @create 2020/11/18 21:51
 */
@RestController
public class TestController {
    @Resource
    private Student student;

    @RequestMapping("/sayHello")
    public String sendMsg(){
        return student.sayHello();
    }
}
