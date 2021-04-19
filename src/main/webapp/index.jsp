<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Welcome To My Home Page</title>
</head>
    <form method="get" target="_blank" action="search">
        <input type="text" name="txt" size="30"/>
        <select name="search">
            <option value="baidu">baidu</option>
            <option value="bing">bing</option>
            <option value="google">google</option>
        </select>
        <input value="Search" type="submit">
    </form>
    <body>
        <h1><%= "Home Page1" %></h1>
        Jsp page
        <li><a href="MyJsp.jsp">MyJsp.jsp</a></li>
        <li><a href="register.jsp">register.jsp</a></li>
        <li><a href="login.jsp">login.jsp</a></li>
        <br/>
        </body>
</html>

<%@include file="footer.jsp"%>
