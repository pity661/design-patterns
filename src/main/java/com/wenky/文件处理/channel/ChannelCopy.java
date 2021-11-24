package com.wenky.文件处理.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-24 19:31
 */
public class ChannelCopy {
  public static void main(String[] args) throws IOException {
    ReadableByteChannel source = Channels.newChannel(System.in);
    WritableByteChannel dest = Channels.newChannel(System.out);
    channelsCopy2(source, dest);
    source.close();
    dest.close();
  }

  private static void channelsCopy2(ReadableByteChannel source, WritableByteChannel dest)
      throws IOException {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
    while (source.read(byteBuffer) != -1) {
      byteBuffer.flip();
      while (byteBuffer.hasRemaining()) {
        dest.write(byteBuffer);
      }
      byteBuffer.clear();
    }
  }

  private static void channelsCopy(ReadableByteChannel source, WritableByteChannel dest)
      throws IOException {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
    while (source.read(byteBuffer) != -1) {
      byteBuffer.flip();
      dest.write(byteBuffer);
      byteBuffer.compact();
    }
    byteBuffer.flip();
    while (byteBuffer.hasRemaining()) {
      dest.write(byteBuffer);
    }
  }
}
