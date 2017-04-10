package com.brojandos.web.electronrush.servlet;

import com.brojandos.web.electronrush.common.Constants;
import com.brojandos.web.electronrush.model.ErrorBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * @author: Brojandos
 * @creation_date: Apr 2, 2017
 */

@WebServlet("/db-console")
public class DatabaseServlet extends HttpServlet {
    private Connection connection;
    private static final Logger logger = Logger.getLogger(DatabaseServlet.class);
    private static PrintWriter out;
    private static ErrorBean bean;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        connection = getRemoteConnection();
        if (connection != null) out.println("successfull connection!");
        req.getRequestDispatcher(Constants.DATABASE_CONSOLE_PAGE).forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (connection == null) {
            if (bean == null) {
                bean = new ErrorBean();
                bean.setErrorText("connection is null");
            }
            req.setAttribute("bean", bean);
            req.getRequestDispatcher(Constants.ERROR_PAGE_PATH).forward(req, resp);
            return;
        }
        try {
            Statement statement = connection.createStatement();
            statement.addBatch(req.getParameter("console"));
            statement.executeBatch();
            statement.close();
        } catch (SQLException ex) {
            bean = new ErrorBean();
            bean.setErrorText(ex.toString());
            req.setAttribute("bean", bean);
            req.getRequestDispatcher(Constants.ERROR_PAGE_PATH).forward(req, resp);
            
        } finally {
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }
    
    private static Connection getRemoteConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbName = System.getProperty("RDS_DB_NAME");
            String userName = System.getProperty("RDS_USERNAME");
            String password = System.getProperty("RDS_PASSWORD");
            String hostname = System.getProperty("RDS_HOSTNAME");
            String port = System.getProperty("RDS_PORT");
            String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=Brojandos&password=password";
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (ClassNotFoundException e) {
            bean = new ErrorBean();
            bean.setErrorText(e.toString());
        } catch (SQLException e) {
            bean = new ErrorBean();
            bean.setErrorText(e.toString());
        }
        return connection;
    }
}
