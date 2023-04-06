package com.viepovsky;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Sample get", urlPatterns = {"/api/*"})
public class Servlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       logger.info("Request got with parameters: " + req.getParameterMap());
       String name = Optional.ofNullable(req.getParameter("name")).orElse("not given name");
        resp.getWriter().write("Hey you used get method! You:" + name);
    }
}
