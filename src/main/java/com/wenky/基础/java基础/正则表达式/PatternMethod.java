package com.wenky.基础.java基础.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-06-03 10:19
 **/
public class PatternMethod {

  public static void main(String[] args) {
      String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 111_3 like Mac OSOSS X) OS like Mac 211_3 OS X OS 311_3  OS X OS 411_3  OS X AppleWebKit/605.1.15";

      String s = "OS (.*?) like Mac";

      Pattern p = Pattern.compile("(OS)(.*?) like Mac"); // 正则表达式，取OS 和 like Mac之间的字符串
      Matcher m = p.matcher(userAgent);
      // 第一次匹配到的
      //m.find();
      // 从第二次匹配到的开始
      while (m.find()) {
        System.out.println(m.group());
        // group方法默认取数组下表为0的数组对象，既compile整个匹配规则命中的结果值
        System.out.println(m.group(1));
        // 整个匹配规则中的子规则部分，既被括号包裹的部分匹配结果
        System.out.println(m.group(2));
        //System.out.println(m.group(1));
        //System.out.println(m.group(2));
        //System.out.println(m.group(3));
      }

    //
  }


}
