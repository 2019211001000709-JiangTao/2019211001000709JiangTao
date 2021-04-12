package com.JiangTao.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        value ="/register"
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer= response.getWriter();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("uName");
        String password=request.getParameter("uPwd");
        String gender=request.getParameter("uSex");
        String phone=request.getParameter("uPhone");
        String email=request.getParameter("uEmail");

        String sql="insert into userTable values(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, gender);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.executeUpdate();

            response.sendRedirect("login.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        response.setContentType("text/html;charset=gbk");
//        PrintWriter writer=response.getWriter();
//        writer.println("<br>Registration Information (week3#2)<br/>");
//        writer.println("<br>username :"+username);
//        writer.println("<br>password :"+password);
//        writer.println("<br>gender :"+gender);
//        writer.println("<br>phone :"+phone);
//        writer.println("<br>email :"+email);
//
//        writer.println("<br/><br/>User form in the database (week4#2)<br/><br/>");
//        String last=" <table border=\"1\">\n" +
//                "  <tr>\n" +
//                "    <th>id</th>\n" +
//                "    <th>username</th>\n" +
//                "    <th>password</th>\n" +
//                "    <th>gender</th>\n" +
//                "    <th>phone</th>\n" +
//                "    <th>email</th>\n" +
//                "  </tr> ";
//        String querySql="select * from userTable";
//        String tem1="";
//        try {
//            ResultSet rs = con.createStatement().executeQuery(querySql);
//            while (rs.next()){
//                String tem=" <tr> ";
//                String idStr=" <td> "+Integer.toString(rs.getInt("id"))+" </td> ";
//                String usernameStr=" <td> "+rs.getString("username")+" </td> ";
//                String passwordStr=" <td> "+rs.getString("password")+" </td> ";
//                String genderStr=" <td> "+rs.getString("gender")+" </td> ";
//                String phoneStr=" <td> "+rs.getString("phone")+" </td> ";
//                String emailStr=" <td> "+rs.getString("email")+" </td> ";
//                tem1+= tem+idStr+usernameStr+passwordStr+genderStr+phoneStr+emailStr+tem;
//            }
//            last=last+tem1+" </table> ";
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        writer.println(last);
//        writer.close();
    }
}


