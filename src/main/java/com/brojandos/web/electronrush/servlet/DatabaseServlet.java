package com.brojandos.web.electronrush.servlet;

import com.brojandos.web.electronrush.common.Constants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Brojandos
 * @creation_date: Apr 2, 2017
 */

@WebServlet("/db-console")
public class DatabaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.DEFAULT_PAGES_PATH + "database/db-console.jsp").forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
