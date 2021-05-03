<%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/4/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Login</h3>
<%
    //    PrintWriter writer=response.getWriter();
    if(!(request.getAttribute("message") == null)){
        out.println("<h4>"+request.getAttribute("message")+"</h4>");
    }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username = "",password = "",rememberMeval = "";
    if(allCookies != null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeval=c.getValue();
            }
        }
    }
%>
    <form action="login" method="post">
        <table>
            <tr>
                <td class="right">Username: </td>
                <td><input type="text" id="username" name="inName" value="<%=username%>"/></td>
            </tr>

            <tr>
                <td class="right">Password: </td>
                <td><input type="password" id="password" style="ime-mode:disabled" name="inPwd" value="<%=password%>"/></td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeval.equals("1") ?"checked":"" %>/>RememberMe</br>
                    <input type="submit" value="login" onClick="return validateLogin()">
                    <input type="reset" value="Reset">
                </td>
            </tr>

        </table>
    </form>
<script language="javascript">
    function validateLogin(){
        var userName = document.getElementById("username");
        var password = document.getElementById("password");
        if (userName.value.length == 0){
            alert("请输入用户名!");
            return false;
        }

        if (password.value.length == 0){
            alert("请输入密码!");
            return  false;
        }
    }
</script>
</body>
</html>
<%@include file="footer.jsp"%>
