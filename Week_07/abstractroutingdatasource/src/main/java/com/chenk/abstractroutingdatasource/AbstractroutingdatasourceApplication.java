package com.chenk.abstractroutingdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AbstractroutingdatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbstractroutingdatasourceApplication.class, args);
    }

}
