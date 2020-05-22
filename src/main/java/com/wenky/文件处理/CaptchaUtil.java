package com.wenky.文件处理;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CaptchaUtil {

    static char[] hybridChars = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    static char[] numChars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    static char[] letters = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
    };


    /**
     * 生成一个位数为count的随机验证码
     *
     * @param count
     * @return
     */
    public static String getHybridChars(int count) {
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < count; i++) {
            char c = hybridChars[ThreadLocalRandom.current().nextInt(hybridChars.length)]; // 随机选取一个字母或数字
            captcha.append(c);
        }
        return captcha.toString();
    }

    public static String getNumChars(int count) {
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < count; i++) {
            char c = numChars[ThreadLocalRandom.current().nextInt(numChars.length)]; // 随机选取一个字母或数字
            captcha.append(c);
        }
        return captcha.toString();
    }

    /**
     * 为一个验证码生成一个图片
     *
     * <p>特性： - 颜色随机 - 上下位置随机 - 左右位置随机，但字符之间不会重叠 - 左右随机旋转一个角度 - 避免字符出界 - 随机颜色的小字符做背景干扰 -
     * 根据字符大小自动调整图片大小、自动计算干扰字符的个数
     *
     * @param captcha
     * @return
     * @author XuJijun
     */
    public static BufferedImage genCaptchaImg(String captcha) {
        System.setProperty("java.awt.headless", "true");

        ThreadLocalRandom r = ThreadLocalRandom.current();

        int count = captcha.length();
        int fontSize = 80; // code的字体大小
        int fontMargin = fontSize / 4; // 字符间隔
        int width = (fontSize + fontMargin) * count + fontMargin; // 图片长度
        int height = (int) (fontSize * 1.2); // 图片高度，根据字体大小自动调整；调整这个系数可以调整字体占图片的比例
        int avgWidth = width / count; // 字符平均占位宽度
        int maxDegree = 26; // 最大旋转度数

        // 背景颜色
        //        Color bkColor = Color.gray;
        Color bkColor = new Color(206, 206, 206);
        // 验证码的颜色
        //        Color[] catchaColor = { Color.MAGENTA, Color.BLACK, Color.BLUE, Color.CYAN,
        // Color.GREEN, Color.ORANGE,
        //                Color.PINK };

        Color[] catchaColor = {Color.DARK_GRAY};

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 填充底色为灰白
        g.setColor(bkColor);
        g.fillRect(0, 0, width, height);

        // 画边框
        // g.setColor(Color.BLACK);
        // g.drawRect(0, 0, width-1, height-1);

        // 画干扰字母和干扰线
        int dSize = fontSize / 3; // 调整分母大小以调整干扰字符大小
        Font font = new Font("Fixedsys", Font.PLAIN, dSize);
        int dNumber = width * height / dSize / dSize / 3;// 根据面积计算干扰字母的个数
        g.setFont(font);
        for (int i = 0; i < dNumber; i++) {
            char dCode = letters[r.nextInt(letters.length)];
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            // 随机旋转一个角度[-maxDegre, maxDegree]
            int degree = r.nextInt(-maxDegree, maxDegree + 1);
            g.rotate(degree * Math.PI / 180); // 旋转一个角度
            g.drawString(String.valueOf(dCode), r.nextInt(width), r.nextInt(height));
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
            g.rotate(-degree * Math.PI / 180);
        }

        // 开始画验证码：
        // 创建字体
        font = new Font("Oxygen Mono", Font.ITALIC | Font.BOLD, fontSize);
        // 设置字体
        g.setFont(font);

        for (int i = 0; i < count; i++) {
            char c = captcha.charAt(i);
            g.setColor(catchaColor[r.nextInt(catchaColor.length)]); // 随机选取一种颜色

            // 随机旋转一个角度[-maxDegre, maxDegree]
            int degree = r.nextInt(-maxDegree, maxDegree + 1);

            // 偏移系数，和旋转角度成反比，以避免字符在图片中越出边框
            double offsetFactor = 1 - (Math.abs(degree) / (maxDegree + 1.0)); // 加上1，避免出现结果为0

            g.rotate(degree * Math.PI / 180); // 旋转一个角度
            int x = (int) (fontMargin + r.nextInt(avgWidth - fontSize) * offsetFactor); // 横向偏移的距离
            int y = (int) (fontSize + r.nextInt(height - fontSize) * offsetFactor); // 上下偏移的距离

            g.drawString(String.valueOf(c), x, y); // x,y是字符的左下角，偏离原点的距离
            // 扭曲
//
//      shear(g,x,y, g.getColor());
//      g.rotate(-degree * Math.PI / 180); // 画完一个字符之后，旋转回原来的角度
            g.translate(avgWidth, 0); // 移动到下一个画画的原点

        }
        g.dispose();

        return image;
    }

    /**
     * 扭曲
     */
    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    public static void shearX(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    public static void shearY(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(8) + 8;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }
        }

    }


    public static void main(String args[]) throws IOException {
        System.setProperty("java.awt.headless", "true");
        BufferedImage bufferedImage = CaptchaUtil.genCaptchaImg("87979");
        File outputfile = new File("/Users/huwenqi/Desktop/captcha-image.jpg");
        ImageIO.write(bufferedImage, "jpg", outputfile);
    }
}
