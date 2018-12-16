/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Bhavy
 */
public class checkDoc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            PrintWriter out = response.getWriter();
            String uname = request.getParameter("uname");
            String email = request.getParameter("uid");
            String toStand = request.getParameter("toStand");
            String toDate = request.getParameter("toDate");
            int rent = Integer.parseInt(request.getParameter("rent"));
            
            Connection cn;
            HttpSession ses = request.getSession(true);
            PreparedStatement pst;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
            pst = cn.prepareStatement("select * from CYCLE.user where status=? AND email=?;");
            pst.setBoolean(1,false);
            pst.setString(2,email);
            rs = pst.executeQuery();
            if(rs.next())
            {
                ses.setAttribute("userID",email);
                ses.setAttribute("uName",uname);
                ses.setAttribute("rent",rent);
                ses.setAttribute("toStand",toStand);
                ses.setAttribute("toDate",toDate);
               
               
                    java.util.Date dNow = new java.util.Date( );
                    Random rand = new Random();
                    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
                    String tid = ft.format(dNow)+( rand.nextInt((999 - 100) + 1) + 100);
                    ses.setAttribute("tid",tid);
                    pst = cn.prepareStatement("select * from CYCLE.cycle_info where stand=? ;");
                    pst.setString(1,ses.getAttribute("pos").toString());
                    rs = pst.executeQuery();
                    out.print("cycle quety");
                    if(rs.next())
                    {
                        out.print("cycle available");
                        String cid = rs.getString("cid");
                        pst = cn.prepareStatement("update CYCLE.cycle_info set travelMode=? where cid=?");
                        pst.setString(2, cid);
                        pst.setBoolean(1, true);
                        pst.executeUpdate();
                        pst = cn.prepareCall("insert into CYCLE.curr_trans (tid,uid,issuer,fromStand,toStand,cid,toDate,rent) values (?,?,?,?,?,?,?,?);");
                        pst.setString(1,tid);
                        pst.setString(2,email);
                        pst.setString(3,ses.getAttribute("email").toString());
                        pst.setString(4, ses.getAttribute("pos").toString());
                        pst.setString(5,toStand);
                        pst.setString(6,cid);
                        pst.setDate(7,new java.sql.Date(dNow.getTime()));
                        pst.setInt(8,0);
                        ses.setAttribute("rent",rent);
                        pst.executeUpdate();            
                        pst = cn.prepareStatement("update CYCLE.user set status=? where email=?;");
                        pst.setBoolean(1, true);
                        pst.setString(2,email);
                        pst.executeUpdate();
                        cn.close();
                        response.sendRedirect("receipt.jsp");
                    }
                
            }
            else
            {
                cn.close();
                response.sendRedirect("issue.jsp?code=AO");
            }
            
        }
        catch(Exception ex)
        {
            PrintWriter out = response.getWriter();
            out.print("<br>"+ex.getMessage()+"<br>"+ex.getCause()+"<br>"+ex.getClass()+"<br>"+ex.getLocalizedMessage());
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
