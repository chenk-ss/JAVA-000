package com.chenk.springstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author chenk
 * @create 2020/11/18 21:37
 */
@Configuration
@ConditionalOnClass(Student.class)
@EnableConfigurationProperties(StuProperties.class)
public class StuAutoConfiguration {
    /**
     * 注入属性配置类
     */
    @Resource
    private StuProperties stuProperties;

    @Bean
    @ConditionalOnMissingBean(Student.class)
    @ConditionalOnProperty(prefix = "stu", value = "enabled", havingValue = "true")
    public Student msgService() {
        return new Student(stuProperties.getStuId(), stuProperties.getName());
    }
}
