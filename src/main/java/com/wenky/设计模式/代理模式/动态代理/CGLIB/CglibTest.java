package com.wenky.设计模式.代理模式.动态代理.CGLIB;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-28 16:34
 **/
public class CglibTest {

    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();

        // 代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();

        proxy.save();
    }
}
