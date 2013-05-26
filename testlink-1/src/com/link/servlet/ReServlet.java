package com.link.servlet;

import com.JAVAJson;
import com.google.gson.JsonObject;
import com.link.BASESQLSTR;

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
public class ReServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       JsonObject jsonObject= BASESQLSTR.test1();
        req.setAttribute("result",jsonObject.toString());

        req.getRequestDispatcher("/return.jsp").forward(req,resp);
    }

}