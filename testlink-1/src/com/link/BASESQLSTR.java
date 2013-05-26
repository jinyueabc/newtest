package com.link;

import com.JAVAJson;
import com.db.DBManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-21
 * Time: 上午12:12
 * To change this template use File | Settings | File Templates.
 */
public class BASESQLSTR {

    public static void main(String[] args) {
         test1();
    }
    public static JsonObject test1(){
        String sqlstr = "select tu.USERNAME,tu.PASSWORD,tu.EMAIL,tu.EMPLOYEE_ID,tu.MOBILE_PHONE from sf_user tu where tu.LOGIN_NAME like '%'||?USERNAME||'%' AND tu.EMPLOYEE_ID>?EMPLOYEE_ID ";
        String jsonStr = "{\"USERNAME\":\"cao\",\"EMPLOYEE_ID\":\"4\"}";
        String jsonStr1 = "{\"USERNAME\":\"\",\"PASSWORD\":\"\",\"EMAIL\":\"\",\"EMPLOYEE_ID\":\"\",\"MOBILE_PHONE\":\"\"}";

        String xx="";
        JsonParser jsonParser = new JsonParser();
        JsonElement ge = jsonParser.parse(jsonStr);
        JsonObject go = ge.getAsJsonObject();
        Connection conn = DBManager.getConnetion();
//        try {
//            getResult(conn,go, sqlstr);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        JsonObject jo=null;
        try {
            jo = getResult(conn, jsonParser.parse(jsonStr).getAsJsonObject(), jsonParser.parse(jsonStr1).getAsJsonObject(), sqlstr);
            System.out.println(jo);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            DBManager.DBClose(conn, null, null);
        }
        return  jo;

    }
        public static JsonObject getResult(Connection conn, JsonObject injsonobj, JsonObject outjsonobj, String sqlstr) throws SQLException {
        JsonObject jsonObject=new JsonObject();
        ResultSet rs = null;
        PreparedStatement ps = null;
        JsonArray array = new JsonArray();
        Iterator<Map.Entry<String, JsonElement>> initerator = injsonobj.entrySet().iterator();

        while (initerator.hasNext()) {
            Map.Entry<String, JsonElement> entry = initerator.next();
            sqlstr = sqlstr.replaceAll("\\?" + entry.getKey(), "" + entry.getValue().toString().trim().replace('\"', '\''));
        }
        System.out.println(sqlstr);
        ps = conn.prepareStatement(sqlstr);
        try {
            rs = ps.executeQuery();
            System.out.println(rs.toString());
            while (rs.next()) {
                JsonObject jo = new JsonObject();
                Iterator<Map.Entry<String, JsonElement>> outiterator = outjsonobj.entrySet().iterator();
                while (outiterator.hasNext()) {
                    Map.Entry<String, JsonElement> outentry = outiterator.next();
                    jo.addProperty(outentry.getKey().trim(), rs.getString(outentry.getKey().trim())==null?"":rs.getString(outentry.getKey().trim()));
                }

                System.out.println(jo);
                array.add(jo);
                jsonObject.add("result",array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return jsonObject;
    }
    public static JsonObject getResult(Connection conn, String injsonobjstr, String outjsonobjstr, String sqlstr) throws SQLException {
        JsonParser jsonParser=new JsonParser();
        JsonObject injsonobj= jsonParser.parse(injsonobjstr).getAsJsonObject();
        JsonObject outjsonobj= jsonParser.parse(outjsonobjstr).getAsJsonObject();
        JsonObject jsonObject=new JsonObject();
        ResultSet rs = null;
        PreparedStatement ps = null;
        JsonArray array = new JsonArray();
        Iterator<Map.Entry<String, JsonElement>> initerator = injsonobj.entrySet().iterator();

        while (initerator.hasNext()) {
            Map.Entry<String, JsonElement> entry = initerator.next();
            sqlstr = sqlstr.replaceAll("\\?" + entry.getKey(), "" + entry.getValue().toString().trim().replace('\"', '\''));
        }
        System.out.println(sqlstr);
        ps = conn.prepareStatement(sqlstr);
        try {
            rs = ps.executeQuery();
            System.out.println(rs.toString());
            while (rs.next()) {
                JsonObject jo = new JsonObject();
                Iterator<Map.Entry<String, JsonElement>> outiterator = outjsonobj.entrySet().iterator();
                while (outiterator.hasNext()) {
                    Map.Entry<String, JsonElement> outentry = outiterator.next();
                    jo.addProperty(outentry.getKey().trim(), rs.getString(outentry.getKey().trim())==null?"":rs.getString(outentry.getKey().trim()));
                }

                System.out.println(jo);
                array.add(jo);
                jsonObject.add("result",array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return jsonObject;
    }
    public static JsonObject getObjResult(Connection conn, String injsonobjstr, String outjsonobjstr, String sqlstr) throws SQLException {
        JsonParser jsonParser=new JsonParser();
        JsonObject injsonobj= jsonParser.parse(injsonobjstr).getAsJsonObject();
        JsonObject outjsonobj= jsonParser.parse(outjsonobjstr).getAsJsonObject();
        JsonObject sqkjsonobj= jsonParser.parse(sqlstr).getAsJsonObject();


        Iterator<Map.Entry<String, JsonElement>> sqliniterator = sqkjsonobj.entrySet().iterator();
        while (sqliniterator.hasNext()){
            Map.Entry<String, JsonElement> sqlentry=  sqliniterator.next();
            sqlentry.getKey();
            if(sqlentry.getValue().isJsonObject()){

            }
        }
        JsonObject jsonObject=new JsonObject();



        return jsonObject;
    }
}
