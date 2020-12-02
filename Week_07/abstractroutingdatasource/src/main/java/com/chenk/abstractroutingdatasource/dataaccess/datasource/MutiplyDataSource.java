package com.chenk.abstractroutingdatasource.dataaccess.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.chenk.abstractroutingdatasource.dataaccess.common.ContextConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class MutiplyDataSource {


    @Bean(name = "dataSourceXunjian")
    @ConfigurationProperties(prefix = "spring.datasource.shop-master")
    public DataSource masterDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceHr")
    @ConfigurationProperties(prefix = "spring.datasource.shop-slave")
    public DataSource slaveDataSource() {
        return new DruidDataSource();
    }


    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(slaveDataSource());

        //配置多数据源
        HashMap<Object, Object> dataSourceMap = new HashMap();
        dataSourceMap.put(ContextConst.DataSourceType.MASTER.name(), masterDataSource());
        dataSourceMap.put(ContextConst.DataSourceType.SLAVE.name(), slaveDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事务
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
