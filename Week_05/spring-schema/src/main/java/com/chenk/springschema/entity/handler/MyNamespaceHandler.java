package com.chenk.springschema.entity.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("student",new StudentBeanDefinitionParser());
    }
}