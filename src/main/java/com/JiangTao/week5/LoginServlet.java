package com.JiangTao.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer=response.getWriter();
        String inUsername=request.getParameter("inName");
        String inPassword=request.getParameter("inPwd");

        String getName=null;
        String getPassword=null;
        String sql="select * from userTable where username=? and password=?";
        try {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,inUsername);
            pstmt.setString(2,inPassword);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                request.setAttribute("id",Integer.toString(rs.getInt("id")));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("phone",rs.getString("phone"));
                request.setAttribute("email",rs.getString("email"));


                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","wrong user name or password!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html;charset=gbk");

    }
}
