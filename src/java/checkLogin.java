/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Bhavy
 */
public class checkLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession ses = req.getSession(true);
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String uname,pwd;
                uname = req.getParameter("user");
                pwd = req.getParameter("password");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                PreparedStatement pst = cn.prepareStatement("select * from CYCLE.emp_info where uname=? AND pwd=?");
                pst.setString(1,uname);
                pst.setString(2,pwd);
                ResultSet rs = pst.executeQuery();
                String email;
                String authKey = UUID.randomUUID().toString().replaceAll("-","");
                if(rs.next())
                {
                    ses.setAttribute("name", rs.getString("fname"));
                    email = rs.getString(4);
                    ses.setAttribute("email",rs.getString(4));
                    ses.setAttribute("userType","emp");
                    ses.setAttribute("pos",rs.getString("dutypos"));
                    ses.setAttribute("authKey",authKey);
                    pst = cn.prepareStatement("update CYCLE.keys set authKey=? where email=?;");
                    pst.setString(1,authKey);
                    pst.setString(2,email);
                    int x = pst.executeUpdate();
                    if(x>0)
                    {
                        pst = cn.prepareStatement("update CYCLE.emp_info set authKey=? where uname=?;");
                        pst.setString(1,authKey);
                        pst.setString(2,email);
                        x = pst.executeUpdate();
                        if(x>0)
                        {
                            cn.close();
                            resp.sendRedirect("dashboard.jsp");
                        }
                        else
                        {
                            out.print("<br>emp_info error");
                            cn.close();
                        }
                    }
                    else
                    {
                        out.print("<br>Keys error");
                        cn.close();
                    }
                }
                else
                {
                    pst = cn.prepareStatement("select * from CYCLE.user where email=? AND pwd=?");
                    pst.setString(1,uname);
                    pst.setString(2,pwd);
                    rs = pst.executeQuery();
                    if(rs.next())
                    {
                        ses.setAttribute("name", rs.getString("fname"));
                        email = rs.getString(4);
                        ses.setAttribute("email",rs.getString(4));
                        ses.setAttribute("userType","customer");
                        ses.setAttribute("authKey",authKey);
                        pst = cn.prepareStatement("update CYCLE.keys set authKey=? where email=?;");
                        pst.setString(1,authKey);
                        pst.setString(2,email);
                        out.print(email);
                        int x = pst.executeUpdate();
                        if(x>0)
                        {
                            pst = cn.prepareStatement("update CYCLE.user set authKey=? where email=?;");
                            pst.setString(1,authKey);
                            pst.setString(2,email);
                            x = pst.executeUpdate();
                            if(x>0)
                            {
                                cn.close();
                                resp.sendRedirect("client.jsp");
                            }
                            else
                            {
                                out.print("<br>emp_info error");
                                cn.close();
                            }
                        }
                        else
                        {
                            out.print("<br>Keys error in key table");
                            cn.close();
                        }
                    }
                }
                resp.sendRedirect("login.jsp?code=IV");
            }
            catch(Exception ex)
            {
                out.printf(ex.getLocalizedMessage()+"<br>"+ex.getMessage()+"<br>"+ex.getCause()+"<br>"+ex.getClass());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
