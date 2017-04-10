<%-- 
    Document   : error
    Created on : Apr 10, 2017, 10:53:09 PM
    Author     : Brojandos
--%>
<%@page import="com.brojandos.web.electronrush.model.ErrorBean"%>
<%
    ErrorBean bean = (ErrorBean)request.getAttribute("bean");
    out.println(bean.getErrorText());
%>
