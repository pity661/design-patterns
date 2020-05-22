package com.wenky.设计模式.桥接模式;

import com.wenky.设计模式.桥接模式.conver.Conver;
import com.wenky.设计模式.桥接模式.conver.PdfConver;
import com.wenky.设计模式.桥接模式.datebase.Database;
import com.wenky.设计模式.桥接模式.datebase.Oracle;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 19:04
 */
public class Test {
    public static void main(String[] args) {
        //
        Database database = new Oracle();
        Conver pdfConver = new PdfConver();
        database.setConver(pdfConver);
        database.conversion();
    }
}
