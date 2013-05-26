package com.link.servlet;

import com.JAVAJson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.util.JSONBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-19
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
      String username=  req.getParameter("user_name");
        System.out.println("username=="+username);
        //System.out.println(JAVAJson.gets(username,"flow[0].complete_date"));
        System.out.println(JAVAJson.gets(username,"ContractHeader"));



    }
}
