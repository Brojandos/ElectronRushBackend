<%-- 
    Document   : login-success
    Created on : Mar 16, 2017, 2:56:15 PM
    Author     : Brojandos
--%>

<%@page import="com.brojandos.web.electronrush.entity.User"%>
<%@page import="com.brojandos.web.electronrush.model.LoginBean"%>
<%@page import="com.brojandos.web.electronrush.common.Constants"%>

<p>You are successfully logged in!</p>  
<%
    LoginBean bean = (LoginBean)request.getAttribute("bean");
    out.print("Welcome, " + bean.getName());
%>
