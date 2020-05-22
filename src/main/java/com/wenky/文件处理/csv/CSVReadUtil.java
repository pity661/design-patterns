package com.wenky.文件处理.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-19 09:54
 **/
public class CSVReadUtil {
    public static void main(String[] args) {
        try {
            File csv = new File("/Users/huwenqi/Desktop/a.csv"); // CSV数据文件
            //BufferedReader reader = new BufferedReader(new FileReader("/Users/huwenqi/Desktop/a.csv"));//换成你的文件名
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "GBK"));
            //reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String last = item[item.length - 1];//这就是你要的数据了
                // int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                System.out.println(last);
                // List<String> list = Arrays.asList(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
