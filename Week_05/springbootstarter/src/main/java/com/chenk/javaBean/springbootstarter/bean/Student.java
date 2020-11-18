package com.chenk.javaBean.springbootstarter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenk
 * @create 2020/11/18 9:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Configuration
@ConfigurationProperties(prefix = "student")
public class Student {
    private String id;
    private String name;
}
