package com.wenky.文件处理.file;

import java.io.*;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-20 18:26
 */
public class ReadFile {
  private static final int BUFFER_SIZE = 1024 * 4;

  public void fileInput() throws IOException {
    FileInputStream in = new FileInputStream(new File("/Users/huwenqi/Desktop/api错误日志信息.txt"));
    System.out.println(new String(toByteArray(in)));
    // 二进制数组转化为字节流
    InputStream inputStream = new ByteArrayInputStream(toByteArray(in));
    // in.close();
    InputStreamReader inReader = new InputStreamReader(in);
    BufferedReader bufferedReader = new BufferedReader(inReader);
    /** 按行处理文件数据 */
    String s;
    try {
      while ((s = bufferedReader.readLine()) != null) {
        if (s.contains("\n")) continue;
        System.out.println(s);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      bufferedReader.close();
      inReader.close();
      in.close();
    }
  }

  public static byte[] toByteArray(InputStream is) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    try {
      byte[] b = new byte[BUFFER_SIZE];
      int n = 0;
      while ((n = is.read(b)) != -1) {
        output.write(b, 0, n);
      }
      return output.toByteArray();
    } finally {
      output.close();
    }
  }
}
