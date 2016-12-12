package com.a.eye.skywalking.docker.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xin on 2016/12/3.
 */
public class DockerEnvTestServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(DockerEnvTestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String routing_Server = System.getProperty("servers");
        logger.info("Servers: {}", routing_Server);
        if (routing_Server != null && routing_Server.length() > 0) {
            req.setAttribute("AGENT", System.getProperty("agent"));
            req.setAttribute("applicationCode", System.getProperty("applicationCode"));
            req.setAttribute("username", System.getProperty("username"));
            req.setAttribute("ROUTING_SERVERS", routing_Server);
            req.getRequestDispatcher("/view/worked.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/view/unworked.jsp").forward(req, resp);
        }
    }
}
