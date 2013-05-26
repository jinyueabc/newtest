package com.obj;


import javassist.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-14
 * Time: 下午7:53
 * To change this template use File | Settings | File Templates.
 */
public class testobj {
    public static void main(String args[]) {

        //获得要修改的类
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.obj.obj");
            CtField f = new CtField(CtClass.intType, "z", cc);
            cc.addField(f,"1");
            cc.writeFile();









        } catch (NotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (CannotCompileException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
