<%--
  Created by IntelliJ IDEA.
  User: yashs
  Date: 27-02-2024
  Time: 04:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>

<%
String name= StringEscapeUtils.escapeHtml4(request.getParameter("name"));
String gender= StringEscapeUtils.escapeHtml4(request.getParameter("gndr"));
String cnt= StringEscapeUtils.escapeHtml4(request.getParameter("cnt"));
out.print(name+"<br>");
out.print(gender+"<br>");
out.print(cnt+"<br>");
%>

<%
        String[] lanlist = request.getParameterValues("lang");

        if(lanlist!=null)
        {
            for(int i=0 ;i<lanlist.length;i++)
            {
                out.println(StringEscapeUtils.escapeHtml4(lanlist[i]));
                if(i<lanlist.length-1)
                    out.println(", ");
            }
        }


        %>

  </body>
</html>
