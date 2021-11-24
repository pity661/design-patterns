package com.wenky.反射和内省;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-03-02 17:00
 */
// @Data
public class JSONToBean {

  public static void main(String[] args) {
    JSONObject jsonObject = new JSONObject();
    // jsonObject.put("bo",Boolean.TRUE);
    jsonObject.put("str", "aaa");
    // jsonObject.put("in",1);
    // jsonObject.put("lo",1l);
    //       System.out.println(jsonObject.toJSONString());
    //    System.out.println(jsonObject.toString());

    // String jsonStr = "{str:\"aaa\",a\":true,\"lo\":1,\"in\":1}";
    BaseDO baseDO = JSON.parseObject(jsonObject.toJSONString(), BaseDO.class);
    System.out.println(baseDO);
    JSONObject jsonObject1 = JSON.parseObject(jsonObject.toJSONString());
    System.out.println(jsonObject1);

    //
  }
}
