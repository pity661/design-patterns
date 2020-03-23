package com.wenky.基础.java基础.序列化和反序列化;

import java.io.*;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-01-14 10:28
 **/
public class Test implements Serializable {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public Test setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Test setHeight(int height) {
        this.height = height;
        return this;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setWidth(1);
        test.setHeight(2);
        // 序列化方法
        try {
            FileOutputStream fs = new FileOutputStream("/Users/huwenqi/Desktop/test.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(test);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 反序列化方法
    public static void seserialize(String filename) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Test test = (Test) in.readObject();
        System.out.println(test.getHeight());
        System.out.println(test.toString());
        in.close();
    }
}
