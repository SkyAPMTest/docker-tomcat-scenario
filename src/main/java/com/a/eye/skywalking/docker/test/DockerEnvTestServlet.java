package com.a.eye.skywalking.docker.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xin on 2016/12/3.
 */
public class DockerEnvTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String routing_Server = System.getProperty("server_list");
        System.out.println("environment : " + routing_Server);
        req.setAttribute("ROUTING_SERVERS",routing_Server);
        req.getRequestDispatcher("/view/helloworld.jsp").forward(req,resp);
    }
}
