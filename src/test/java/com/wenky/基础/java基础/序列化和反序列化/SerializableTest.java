package com.wenky.基础.java基础.序列化和反序列化;

public class SerializableTest {
    public static void main(String[] args) throws Exception {
        //user.dir指定了当前的路径
        System.out.println(System.getProperty("user.dir"));
        Test.seserialize("/Users/huwenqi/Desktop/test.ser");
    }
}