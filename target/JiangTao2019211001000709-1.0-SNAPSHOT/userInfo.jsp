<%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/4/12
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    User Info
</h3>
<table >
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>phone:</td><td><%=request.getAttribute("phone")%></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
</table>
</body>
</html>
<%@include file="footer.jsp"%>
