package com.chenk.springstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author chenk
 * @create 2020/11/18 21:35
 */
@Data
@ConfigurationProperties(prefix = "stu")
public class StuProperties {
    private String stuId;
    private String name;
}
