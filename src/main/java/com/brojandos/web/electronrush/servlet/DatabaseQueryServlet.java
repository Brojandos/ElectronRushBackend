package com.brojandos.web.electronrush.servlet;

import com.brojandos.web.electronrush.common.Constants;
import com.brojandos.web.electronrush.model.ErrorBean;
import com.brojandos.web.electronrush.model.QueryResultBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Brojandos
 * @creation_date: Apr 11, 2017
 */

@WebServlet(Constants.DATABASE_QUERY_URI)
public class DatabaseQueryServlet extends HttpServlet {
    private Connection connection;
    private static PrintWriter out;
    private static QueryResultBean bean;
    private static ErrorBean errBean;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (connection == null) {
            if (errBean == null) {
                errBean = new ErrorBean();
                errBean.setErrorText("connection is null");
            }
            req.setAttribute(Constants.MODEL_ATTRIBUTE_NAME, errBean);
            req.getRequestDispatcher(Constants.ERROR_PAGE_PATH).forward(req, resp);
            return;
        }
        try {
            String sql = req.getParameter("console");
            Statement readStatement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resultSet = readStatement.executeQuery(sql);
            resultSet.first();
            String columnLabel = sql.split(" ")[1];
            
            out.println(resultSet.getString(columnLabel));
            StringBuilder results = new StringBuilder(resultSet.getString(columnLabel));
            while(resultSet.next()) {
                results.append(", ").append(resultSet.getString(columnLabel));
            }
            resultSet.close();
            readStatement.close();
            connection.close();
            
            bean.setText(results.toString());
            req.setAttribute(Constants.MODEL_ATTRIBUTE_NAME, bean);
            req.getRequestDispatcher(Constants.QUERY_RESULT_PAGE_PATH).forward(req, resp);
        } catch (SQLException ex) {
            errBean = new ErrorBean();
            errBean.setErrorText(ex.toString());
            req.setAttribute(Constants.MODEL_ATTRIBUTE_NAME, errBean);
            req.getRequestDispatcher(Constants.ERROR_PAGE_PATH).forward(req, resp);
        } finally {
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        connection = getRemoteConnection();
        if (connection != null) out.println("successfull connection!");
        req.getRequestDispatcher(Constants.DATABASE_QUERY_PAGE).forward(req, resp);
    }
    
        private static Connection getRemoteConnection() {
        Connection connection = null;
        try {
            Class.forName(Constants.DATABASE_DRIVER);
            connection = DriverManager.getConnection(Constants.JDBC_URL);
        } catch (ClassNotFoundException e) {
            errBean = new ErrorBean();
            errBean.setErrorText(e.toString());
        } catch (SQLException e) {
            errBean = new ErrorBean();
            errBean.setErrorText(e.toString());
        }
        return connection;
    }
}
