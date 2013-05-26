package com;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-20
 * Time: 下午10:43
 * To change this template use File | Settings | File Templates.
 */
public class JAVAJson {
    public static Object gete(JsonObject gj, String membername) {
        JsonObject gjj = null;
        if (membername.indexOf(".") > -1) {
            String member1 = membername.substring(0, membername.indexOf("."));
            String memberx = "";
            if (member1.indexOf("[") > -1 && member1.indexOf("]") > -1) {
                String[] x = member1.split("\\[|\\]");
                memberx = x[0];
                gjj = gj.get(memberx).getAsJsonArray().get(Integer.parseInt(x[1])).getAsJsonObject();

            } else {
                gjj = gj.get(member1).getAsJsonObject();
            }

            String member2 = membername.substring(membername.indexOf(".") + 1, membername.length());

            if (member2.indexOf(".") > -1) {
                return gete(gjj, member2);
            } else {
                if (member2.indexOf("[") > -1 && member1.indexOf("]") > -1) {
                    String[] xx = member1.split("\\[|\\]");
                    String memberxx = xx[0];
                    return gj.get(memberxx).getAsJsonArray().get(Integer.parseInt(xx[1])).getAsJsonObject();

                } else {
                    return gjj.get(member2);
                }

            }
        } else {
            if (membername.indexOf("[") > -1 && membername.indexOf("]") > -1) {
                String[] xx = membername.split("\\[|\\]");
                String memberxx = xx[0];
                return gj.get(memberxx).getAsJsonArray().get(Integer.parseInt(xx[1])).getAsJsonObject();

            } else {
                return gj.get(membername);
            }

        }


    }
    public static Object  gets(String jsonstr,String membername){
        JsonParser gp=new JsonParser();
        JsonElement ge= gp.parse(jsonstr);
        JsonObject go= ge.getAsJsonObject();
        return gete(go,membername);
    }
}
