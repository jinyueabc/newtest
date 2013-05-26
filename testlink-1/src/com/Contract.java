package com;

import com.db.DBManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.link.BASESQLSTR;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-23
 * Time: 下午5:27
 * To change this template use File | Settings | File Templates.
 */
public class Contract {
    public JsonObject getoneContract(){
        String sqlstr = "{\"FLOW_HEADER\":{\"SQLSTR\":\"SELECT\",\"OPERATE\":\"QUERY\"}" +
                         "\"CONTRACT_HEADER\":{\"SQLSTR\":\"SELECT * FROM CMS_CONTRACT_INFO CCI WHERE CCI.CONTRACT_ID=?CONTRACT_ID\",\"OPERATE\":\"QUERY\"}" +
                         "\"CONTRACT_LINE\":{\"SQLSTR\":\"SELECT * FROM CMS_CONTRACT_INFO CCI WHERE CCI.CONTRACT_ID=?CONTRACT_ID \",\"OPERATE\":\"QUERY\"} }";
        String jsonStr = "{\"CONTRACT_ID\":\"148399\"}";
        String jsonStr1= "{\"FLOW_HEADER\":\"\",\"PASSWORD\":\"\",\"EMAIL\":\"\",\"EMPLOYEE_ID\":\"\",\"MOBILE_PHONE\":\"\"" +
                           "\"CONTRACT_HEADER\":{\"CONTRACT_NAME\":\"\",\"CONTRACT_SERIAL_NO\":\"\",\"CONTRACT_NO\":\"\",\"CONTRACT_ID\":\"\"," +
                           "\"CONTRACT_CATEGORY\":\"\",\"SMALL_CATEGORY\":\"\"}}";

        Connection conn = DBManager.getConnetion();
        JsonObject jo=null;
        try {
            jo = BASESQLSTR.getResult(conn, jsonStr, jsonStr1, sqlstr);
            System.out.println(jo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.DBClose(conn, null, null);
        }
        return  jo;
    }
}
