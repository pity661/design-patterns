package com.wenky.文件处理.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-24 19:55
 */
public class Marketing {
  private static final String file = "/Users/huwenqi/Desktop/blahblah.txt";

  public static void main(String[] args) throws IOException {
    int reps = 10;
    if (args.length > 0) {
      reps = Integer.parseInt(args[0]);
    }
    FileOutputStream fos = new FileOutputStream(file);
    FileChannel gatheringByteChannel = fos.getChannel();

    ByteBuffer[] bs = utterBS(reps);
    while (gatheringByteChannel.write(bs) > 0) {}

    System.out.println(gatheringByteChannel.size());
    System.out.println(gatheringByteChannel.position());
    // 删除
    gatheringByteChannel.truncate(50);

    gatheringByteChannel.position(1000);
    System.out.println(gatheringByteChannel.size());
    System.out.println(gatheringByteChannel.position());

    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
    byteBuffer.put("a".getBytes("US-ASCII"));
    byteBuffer.flip();
    gatheringByteChannel.write(byteBuffer);
    System.out.println(gatheringByteChannel.size());
    System.out.println(gatheringByteChannel.position());
    // 将修改写入磁盘，metaData 元数据(文件所有者，访问权限，最后一次修改时间等信息)
    gatheringByteChannel.force(false);

    System.out.println("Mindshare paradigms synergized to " + file);
    fos.close();
  }

  private static String[] col1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};

  private static String[] col2 = {
    "a-a", "b-1", "c-2", "d-f", "e-d", "f-cv", "gada", "hcwe", "idWd"
  };

  private static String[] col3 = {
    "a-11a", "b-21", "c-32", "4d-f", "e-2d", "f-1cv", "g2eada", "hdwwcwe", "idWddqd"
  };

  private static String newline = System.getProperty("line.separator");

  private static ByteBuffer[] utterBS(int howMany) throws UnsupportedEncodingException {
    List list = new LinkedList();
    for (int i = 0; i < howMany; i++) {
      list.add(pickRandom(col1, " "));
      list.add(pickRandom(col2, " "));
      list.add(pickRandom(col3, newline));
    }
    ByteBuffer[] bufs = new ByteBuffer[list.size()];
    list.toArray(bufs);
    return bufs;
  }

  private static Random rand = new Random();

  private static ByteBuffer pickRandom(String[] strings, String suffix)
      throws UnsupportedEncodingException {
    String string = strings[rand.nextInt(strings.length)];
    int total = string.length() + suffix.length();
    ByteBuffer byteBuffer = ByteBuffer.allocate(total);
    byteBuffer.put(string.getBytes("US-ASCII"));
    byteBuffer.put(suffix.getBytes("US-ASCII"));
    byteBuffer.flip();
    return byteBuffer;
  }
}
