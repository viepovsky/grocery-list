package com.viepovsky.tobuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "GroceryList", urlPatterns = {"/api/grocery/*"})
public class GroceryListServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(GroceryListServlet.class);
    private ToBuyRepository repository;
    private ObjectMapper mapper;
    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public GroceryListServlet() {
        this(new ToBuyRepository(), new ObjectMapper());
    }

    GroceryListServlet(ToBuyRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got with parameters: " + req.getParameterMap());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), repository.findAll());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var pathInfo = req.getPathInfo();
        try {
            var toBuyId = Long.valueOf(pathInfo.substring(1));
            var toBuy = repository.toggleToBuy(toBuyId);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), toBuy);
        } catch (NumberFormatException e) {
            logger.warn("Wrong path used: " + pathInfo);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var newToBuy = mapper.readValue(req.getInputStream(), ToBuy.class);
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), repository.addToBuy(newToBuy));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request got with parameters: " + req.getParameterMap());
        repository.deleteAlToBuy();
        mapper.writeValue(resp.getOutputStream(), HttpStatus.OK_200);
    }
}
