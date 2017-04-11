<%@page import="com.brojandos.web.electronrush.common.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
        <link href="resources/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="container">
            <div id="header">HEADER</div>
            <div id="left">LEFT
                <form name="auth" method="get" action="auth">
                    <input type="submit" value="authorize">
                </form>
            </div>
            <div id="right">RIGHT</div>
            <div id="content">CONTENT
                <form name="db-batch" method="get" action="db-batch">
                    <input type="submit" value="batch">
                </form>
                <form name="db-query" method="get" action="db-query">
                    <input type="submit" value="query">
                </form>
            </div>
            <div id="clear"></div>
            <div id="footer">FOOTER <% out.println("Version: " + Constants.SITE_VERSION); %></div>
        </div>
    </body>
</html>
