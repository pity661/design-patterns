package com.wenky.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-12 21:29
 */
public class GsonFirst {

    public static void main(String[] args) {
        System.out.println("123".substring(3 - 1));
        //
        String jsonString = "{\"name\":\"wenky\",\"age\":\"23\"}";

        // 创建Gson对象，可重用对象
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        // 将字符串反序列化为对象
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(jsonString);

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        System.out.println(jsonObject.get("name").getAsString());
    }
}
