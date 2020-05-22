package com.wenky.基础.java基础.反射访问私有变量;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-06-03 14:57
 */
public class Person {
    private String username = "Tom";

    private void playGame() {
        System.out.println(username + "玩游戏了");
    }

    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
            NoSuchFieldException {
        Person person = new Person();
        Class c = person.getClass();
        Method method = c.getDeclaredMethod("playGame");
        method.setAccessible(true);
        method.invoke(person);
        Field field = c.getDeclaredField("username");
        field.setAccessible(true);
        field.set(person, "John");
        method.invoke(person);
    }
}
