package com.chenk.springstarter;

import lombok.Data;

/**
 * @Author chenk
 * @create 2020/11/18 9:12
 */
@Data
public class Student {
    private String stuId;
    private String name;

    public Student(String stuId, String name){
        this.stuId = stuId;
        this.name = name;
    }

    public String sayHello() {
        return "Hello " + name;
    }
}
