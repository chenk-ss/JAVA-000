package com.chenk.abstractroutingdatasource.dataaccess.datasource;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder {

    private static final String DEFAULT_DATASOURCE = "SLAVE";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSource(String dbType){
        log.info("切换到["+dbType+"]数据源");
        contextHolder.set(dbType);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}