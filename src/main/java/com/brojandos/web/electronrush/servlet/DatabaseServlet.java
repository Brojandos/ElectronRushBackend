package com.brojandos.web.electronrush.servlet;

import com.brojandos.web.electronrush.common.Constants;
import java.io.IOException;
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
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = getRemoteConnection();
        req.getRequestDispatcher(Constants.DATABASE_CONSOLE_PAGE).forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = getRemoteConnection();
        try {
            Statement statement = connection.createStatement();
            statement.addBatch(req.getParameter("console"));
            statement.executeBatch();
            statement.close();
        } catch (SQLException ex) {
            logger.trace(ex);
        } finally {
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }
    
    private static Connection getRemoteConnection() {
        if (System.getenv("RDS_HOSTNAME") != null) {
            try {
                Class.forName("org.postgresql.Driver");
                String dbName = System.getenv("RDS_DB_NAME");
                String userName = System.getenv("RDS_USERNAME");
                String password = System.getenv("RDS_PASSWORD");
                String hostname = System.getenv("RDS_HOSTNAME");
                String port = System.getenv("RDS_PORT");
                String jdbcUrl = "jdbc:postgresql://"
                        + hostname + ":"
                        + port + "/"
                        + dbName + "?user="
                        + userName + "&password="
                        + password;
                logger.trace("Getting remote connection with connection string from environment variables.");
                Connection con = DriverManager.getConnection(jdbcUrl);
                logger.info("Remote connection successful.");
                return con;
            } catch (ClassNotFoundException e) {
                logger.warn(e.toString());
            } catch (SQLException e) {
                logger.warn(e.toString());
            }
        }
        return null;
    }
}
