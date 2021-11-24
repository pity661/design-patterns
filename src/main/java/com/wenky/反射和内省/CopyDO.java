package com.wenky.反射和内省;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-02-27 16:39
 */
// @Data
public class CopyDO {
  private String str;
  private Boolean bo;
  private Integer in;
  private Long lo;
  private Boolean boo;

  public Boolean getBoo() {
    return boo;
  }

  public void setBoo(Boolean boo) {
    this.boo = boo;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public Boolean getBo() {
    return bo;
  }

  public void setBo(Boolean bo) {
    this.bo = bo;
  }

  public Integer getIn() {
    return in;
  }

  public void setIn(Integer in) {
    this.in = in;
  }

  public Long getLo() {
    return lo;
  }

  public void setLo(Long lo) {
    this.lo = lo;
  }
}
