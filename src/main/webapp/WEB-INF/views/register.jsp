<%--
  Created by IntelliJ IDEA.
  User: 拾光
  Date: 2021/3/15
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<%@include file="header.jsp"%>
<html>
<head>
    <style >
        td.right{
            text-align: right;height: 25px;
        }
    </style>
    <script language="javascript">
        function restriction(){
            var pwd = document.getElementById("password").value
            if(pwd.length<8){
                alert("The password must be at least 8 characters long");
                return false;
            }
            else
                return true;
        }
    </script>
</head>
<body>
<h3>New user register</h3>
<form action="register" method="post">
    <table>
        <tr> <td class="right">Username: </td> <td><input type="text" name="uName"/></td></tr>
        <tr> <td class="right">Password: </td>
            <td><input type="password" id="password" style="ime-mode:disabled" name="uPwd" onBlur = "restriction()"/>
            </td></tr>
        <tr>
            <td class="right">Gender: </td>
            <td>
                <input type="radio" name="uSex" value="Male" checked="checked"/>Male
                <input type="radio" name="uSex" value="Female" /> Female
            </td>
        </tr>
        <tr><td class="right">Email: </td><td><input type="email" name="uEmail"/></td></tr>
        <tr><td class="right">Birthdate: </td><td><input type="date" name="uDate"/></td></tr>
        <tr><td></td><td><input type="submit" value="Register" onclick="return restriction()">  <input type="reset" value="Reset"></td>  </tr>

    </table>
</form>
</body>
</html>
<%@include file="footer.jsp"%>