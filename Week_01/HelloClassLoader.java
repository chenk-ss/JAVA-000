package com.chenk.java000;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author chenk
 * @create 2020/10/19 21:32
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class helloClass = new HelloClassLoader().findClass("Hello");
        Object instance = helloClass.newInstance();
        Method method = helloClass.getMethod("hello");
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name){
        byte[] bytes = getFileBytes("D:\\IdeaProject\\java000\\src\\main\\java\\com\\chenk\\java000\\Hello.xlass");
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] getFileBytes(String path){
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < bytes.length; i ++){
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
