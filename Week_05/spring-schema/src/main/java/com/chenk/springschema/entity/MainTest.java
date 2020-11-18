package com.chenk.springschema.entity;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author chenk
 * @create 2020/11/17 14:36
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("student.xml");
        Student student =(Student) context.getBean("student1");
        System.out.println(student.toString());
        Student student1 =(Student) context.getBean("student2");
        System.out.println(student1.toString());
    }
}
