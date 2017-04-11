package com.brojandos.web.electronrush.common;

/**
 * @author: Brojandos
 * @creation_date: Mar 16, 2017
 */
public class Constants {
    public static final String ATTRIBUTE_USERNAME = "name";
    public static final String GLOBAL_PASSWORD = "password";
    public static final String WELCOME_MESSAGE = "Welcome";
    public static final String COMMA_SEPERATOR = ", ";
    public static final String LOGIN_FAILURE = "Login failure";
    public static final String PARAMETER_NAME = "name";
    public static final String PARAMETER_PASSWORD = "password";
    public static final String MODEL_ATTRIBUTE_NAME = "bean";
    public static final String SITE_VERSION = "0.0.5";
    public static final String DEFAULT_PAGES_PATH = "WEB-INF/views/";
    public static final String SLASH = "/";
    public static final String AUTHORIZATION_URI = SLASH + "auth";
    public static final String DATABASE_BATCH_URI = SLASH + "db-batch";
    public static final String DATABASE_QUERY_URI = SLASH + "db-query";
    public static final String AUTHORIZATION_PAGE = DEFAULT_PAGES_PATH + "auth/auth.jsp";
    public static final String AUTHORIZATION_SUCCESS_PAGE_PATH = DEFAULT_PAGES_PATH + "auth/login-success.jsp";
    public static final String AUTHORIZATION_FAILURE_PAGE_PATH = DEFAULT_PAGES_PATH + "auth/login-failure.jsp";
    public static final String DATABASE_BATCH_PAGE = DEFAULT_PAGES_PATH + "database/db-batch.jsp";
    public static final String ERROR_PAGE_PATH = DEFAULT_PAGES_PATH + "error/error.jsp";
    public static final String DATABASE_QUERY_PAGE = DEFAULT_PAGES_PATH + "database/db-query.jsp";
    public static final String QUERY_RESULT_PAGE_PATH = DEFAULT_PAGES_PATH + "database/query-result.jsp";
    public static final String DATABASE_DRIVER = "org.postgresql.Driver";
    public static final String JDBC_URL = "jdbc:postgresql://" 
            + System.getProperty("RDS_HOSTNAME") + ":" + System.getProperty("RDS_PORT") + "/"
            + System.getProperty("RDS_DB_NAME") + "?"
            + "user=" + System.getProperty("RDS_USERNAME") + "&"
            + "password=password";
    public static final String RDS_HOSTNAME = "mydb.cn1cngavy0zp.us-west-2.rds.amazonaws.com";
    public static final String RDS_PORT = "5432";
    public static final String RDS_DB_NAME = "mydb";
    public static final String RDS_USERNAME = "Brojandos";
    public static final String RDS_PASSWORD = "password";
}