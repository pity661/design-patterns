package com.wenky.类的不同类型;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-12-11 10:51
 */
public class Base {
  protected Integer a;
  private String b;
  public Long c;

  public Integer getA() {
    return a;
  }

  public Base setA(Integer a) {
    this.a = a;
    return this;
  }

  public String getB() {
    return b;
  }

  public Base setB(String b) {
    this.b = b;
    return this;
  }

  public Long getC() {
    return c;
  }

  public Base setC(Long c) {
    this.c = c;
    return this;
  }
}
