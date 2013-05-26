package com.obj;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-15
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class A implements Serializable {
    String name="";
    String age="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
