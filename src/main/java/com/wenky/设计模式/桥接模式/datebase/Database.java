package com.wenky.设计模式.桥接模式.datebase;

import com.wenky.设计模式.桥接模式.conver.Conver;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 18:37
 */
public abstract class Database {
  public Conver conver;

  public void setConver(Conver conver) {
    this.conver = conver;
  }

  public abstract void conversion();
}
