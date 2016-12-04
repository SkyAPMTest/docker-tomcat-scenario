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
        String routing_Server = System.getProperty("servers");
        if (routing_Server != null && routing_Server.length() > 0) {
            req.setAttribute("AGENT", System.getProperty("agent"));
            req.setAttribute("applicationCode", System.getProperty("applicationCode"));
            req.setAttribute("userId", System.getProperty("userId"));
            req.setAttribute("ROUTING_SERVERS", routing_Server);
            req.getRequestDispatcher("/view/worked.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/unworked.jsp").forward(req, resp);
        }
    }
}
