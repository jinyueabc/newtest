package com.link.json;

import com.db.DBManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-22
 * Time: 下午11:17
 * To change this template use File | Settings | File Templates.
 */
public class testjsondao {
    public static void main(String[] args) {

           test2();
    }
    public static void test2(){
        JsonObject jo=new JsonObject();
        JsonParser jsonParser=new JsonParser();
       // jo.add("name",jsonParser.parse("xx"));
        jo.addProperty("name","xx");
        System.out.println(jo);

    }
    public void test1(){
        String sqlstr = "select tu.USERNAME,tu.PASSWORD from sf_user tu where tu.LOGIN_NAME=?USERNAME ";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        try {

            conn= DBManager.getConnetion();
            // sqlstr.replace("?USERNAME","ZHANGZHE");
            sqlstr=  sqlstr.replaceAll("\\?USERNAME","\'ZHANGZHE\'");
            System.out.println(sqlstr);
            ps= conn.prepareStatement(sqlstr);
            resultSet= ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.DBClose(conn,ps,resultSet);
        }
    }
}
