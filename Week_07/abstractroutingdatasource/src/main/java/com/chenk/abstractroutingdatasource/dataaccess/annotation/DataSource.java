package com.chenk.abstractroutingdatasource.dataaccess.annotation;

import com.chenk.abstractroutingdatasource.dataaccess.common.ContextConst;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource  {
    ContextConst.DataSourceType value() default ContextConst.DataSourceType.MASTER;
}