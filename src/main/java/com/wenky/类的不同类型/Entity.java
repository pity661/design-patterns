package com.wenky.类的不同类型;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-12-11 10:51
 **/
public class Entity extends Base{
    private String str;
    protected Integer inte;
    public Long pub;

    public String getStr() {
        return str;
    }

    public Entity setStr(String str) {
        this.str = str;
        return this;
    }

    public Integer getInte() {
        return inte;
    }

    public Entity setInte(Integer inte) {
        this.inte = inte;
        return this;
    }

    public Long getPub() {
        return pub;
    }

    public Entity setPub(Long pub) {
        this.pub = pub;
        return this;
    }
}
