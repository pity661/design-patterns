package com.wenky.子类继承;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-03-11 10:03
 **/
public class Base {
    protected String p1 = "a";

    protected String getP1() {
        return p1;
    }

    public void println() {
        System.out.println(this.p1);
        System.out.println(getP1());
    }
}
