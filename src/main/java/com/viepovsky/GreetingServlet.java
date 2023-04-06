package com.viepovsky;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

@WebServlet(name = "Sample get", urlPatterns = {"/api/*"})
public class GreetingServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";
    private final Logger logger = LoggerFactory.getLogger(GreetingServlet.class);
    private GreetingService service;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public GreetingServlet() {
        this(new GreetingService());
    }

    GreetingServlet(GreetingService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got with parameters: " + req.getParameterMap());
        resp.getWriter().write(service.prepareGreeting(req.getParameter(NAME_PARAM), req.getParameter(LANG_PARAM)));
    }
}
