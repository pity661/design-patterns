package com.wenky.文件处理.csv;

import java.io.*;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-19 09:54
 **/
public class CSVWriteUtil {
    public static void main(String[] args) {
        try {
            File csv = new File("/Users/huwenqi/Desktop/a.csv"); // CSV数据文件
            //BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csv), "GBK")) ;// 附加
            // 添加新的数据行
            bw.write("\"李四\"" + "," + "\"1988\"" + "," + "\"1992\"");
            bw.newLine();
            bw.close();
        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter在关闭对象捕捉异常
            e.printStackTrace();
        }
    }
}
