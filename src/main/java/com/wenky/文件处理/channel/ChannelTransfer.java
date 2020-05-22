package com.wenky.文件处理.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-24 21:05
 **/
public class ChannelTransfer {

    public static void main(String[] args) throws IOException {
        // 1。
        try (FileOutputStream fos = new FileOutputStream("/Users/huwenqi/Desktop/test.txt")) {
            WritableByteChannel channel = Channels.newChannel(fos);
            // 2。
            // WritableByteChannel channel = Channels.newChannel(System.out);
            String[] files = new String[]{"/Users/huwenqi/Desktop/blahblah.txt", "/Users/huwenqi/Desktop/11.txt", "/Users/huwenqi/Desktop/22.txt"};
            for (int i = 0; i < files.length; i++) {
                try (FileInputStream fis = new FileInputStream(files[i])) {
                    try (FileChannel channel1 = fis.getChannel()) {
                        // channel - to - channel输出
                        channel1.transferTo(0, channel1.size(), channel);
                    }
                }
            }
        }
    }
}
