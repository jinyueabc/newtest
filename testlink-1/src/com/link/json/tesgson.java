package com.link.json;

import com.JAVAJson;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-19
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
public class tesgson {
    public static void main(String[] args) {
        String str = "{\"one\":{\"name\":{\"xx\":\"xx2\"}},\"two\":[{\"t1\":\"aa\"},{\"t1\":\"bb\"}],\"three\":\"false\"}";
        Map map = new HashMap();
        map.put("1", "x1");
        map.put("2", "x2");
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("3x1", "1x");
        map2.put("3x2", "2x");
        List list = new ArrayList();
        list.add(map1);
        list.add(map2);
        map.put("3", list);

        JsonParser gsonParser = new JsonParser();
         JsonElement ge = gsonParser.parse(map.toString());
        //JsonElement ge = gsonParser.parse(str);

        JsonObject gj = ge.getAsJsonObject();


        System.out.println(JAVAJson.gete(gj, "3[0].3x1").toString());

    }


}
