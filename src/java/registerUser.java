/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Bhavy
 */
public class registerUser extends HttpServlet {

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
            String pwd,fname,lname,gen,email,dob,mob,authKey,rsrc;
            /*String reqUrl = req.getPathInfo();
            out.print(reqUrl+"<br>"+req.getContextPath()+"<br>"+req.getRequestURI()+"<br>"+req.getServletPath());
             String ipAddress = req.getHeader("x-forwarded-for");
             
             String clientOrigin = req.getHeader("origin");
            if (ipAddress == null) {
                ipAddress = req.getRemoteAddr();
            }  
            
            String url = new URL(req.getHeader("referer").toString()).getHost();
            out.print("<br>"+ipAddress+"<br>"+clientOrigin+"<br/>"+url);*/
            /*if path is from user then RSRC="SELF";
            
            else RSRC="EMP"
            */
            rsrc="";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                HttpSession s = req.getSession(true);
                out.print("<br>"+s.getId());
                fname = req.getParameter("Fname");
                lname = req.getParameter("Lname");
                gen = req.getParameter("gen");
                email = req.getParameter("email").toLowerCase();
                dob = req.getParameter("bdate");
                mob = req.getParameter("phone");
                pwd = req.getParameter("pwd");
                authKey = UUID.randomUUID().toString().replaceAll("-","");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                PreparedStatement pst = cn.prepareStatement("select * from CYCLE.user where mob=? OR email=?;");
                pst.setString(1,mob);
                pst.setString(2,email);
                ResultSet rs = pst.executeQuery();
                if(rs.next())
                {
                    resp.sendRedirect("register.jsp?code=AE");
                }
                else
                {
                    pst = cn.prepareStatement("insert into CYCLE.user (fname,lname,gen,email,dob,mob,pwd,authkey,rsrc) values (?,?,?,?,?,?,?,?,?);");
                    Boolean log = true;
                    pst.setString(1,fname);
                    pst.setString(2,lname);
                    pst.setString(3,gen);
                    pst.setString(4,email);
                    pst.setString(5,dob);
                    pst.setString(6,mob);
                    pst.setString(7,pwd);
                    pst.setString(8,authKey);
                    pst.setString(9,rsrc);
                    HttpSession ses = req.getSession(true);
                    if(ses.getAttribute("userType")==null)
                    {
                        ses.setAttribute("name",fname);
                        ses.setAttribute("email",email);
                        ses.setAttribute("authKey",authKey);
                        ses.setAttribute("userType","customer");
                        log = false;
                    }
                    int i = pst.executeUpdate();
                    if(i==1 && ses.getAttribute("userType").toString().equals("emp"))
                    {
                        //out.println("Employee has added the user ...");
                        //out.print("<br>"+ses.getId());
                        cn.close();
                        resp.sendRedirect("dashboard.jsp");
                    }
                    else if ( i==1 && log==false)
                    {
                        //out.print("<br>User has registered itself ...");
                        //out.print("<br>"+ses.getId());
                        
                        pst = cn.prepareStatement("insert into CYCLE.keys (authKey,email,type) values (?,?,?);");
                        pst.setString(1, authKey);
                        pst.setString(2,email);
                        pst.setString(3, "customer");
                        int x = pst.executeUpdate();
                        cn.close();
                        if(x>0)
                        {
                            resp.sendRedirect("client.jsp");
                        }
                        else
                        {
                            out.print("AuthKey Error in insert .....");
                        }
                    }
                    else
                    {
                        out.println("Record is not inserted ....");
                    }
                    cn.close();
                    resp.sendRedirect("register.jsp?code=AE");
                }
            }
            catch(Exception ex)
            {
                out.printf(ex.getMessage()+"<br>"+ex.getClass()+"<br>"+ex.getCause());
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
