<%-- 
    Document   : query-result
    Created on : Apr 11, 2017, 11:33:28 AM
    Author     : Brojandos
--%>

<%@page import="com.brojandos.web.electronrush.model.QueryResultBean"%>
<%
    QueryResultBean bean = (QueryResultBean)request.getAttribute("bean");
    out.println("Query result: " + bean.getText());
%>
