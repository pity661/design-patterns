package com.wenky.反射和内省;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-02-27 16:39
 **/
//@Data
public class BaseDO {

    private String str;
    private Boolean bo;
    private Integer in;
    private Long lo;

    public BaseDO() {
    }

    public BaseDO(String str, Boolean bo, Integer in, Long lo) {
        this.str = str;
        this.bo = bo;
        this.in = in;
        this.lo = lo;
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
