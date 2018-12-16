package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;

public final class end_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/auth.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
            if(session.getAttribute("authKey")==null || session.getAttribute("userType")==null || session.getAttribute("email")==null)
            {
                response.sendRedirect("");
            }
            else
            {
                String authKey = session.getAttribute("authKey").toString();
            String userType = session.getAttribute("userType").toString();
            PreparedStatement pst1 = cn1.prepareStatement("select * from CYCLE.keys where authKey=? and (type=? and email=?);");
            pst1.setString(1,authKey);
            pst1.setString(2,userType);
            pst1.setString(3,session.getAttribute("email").toString());
            ResultSet rs1 = pst1.executeQuery();
            if(rs1.next())
            {
                
                out.print("<font color=red style=\"z-index:15;\">"+rs1.getString("email")+" || "+rs1.getString("type")+" || "+rs1.getString("authKey")+"</font>");
                cn1.close();
            }
            else
            {
                session.invalidate();
                cn1.close();
                response.sendRedirect("");
            }}}catch(Exception ex){out.print("<font color=red style=\"z-index:15;\">"+ex.getLocalizedMessage()+ex.getMessage()+ex.getClass()+ex.getCause()+"</font>");}
            
      out.write("\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  <title>End - Bicycle Sharing System</title>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);\r\n");
      out.write("@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);\r\n");
      out.write("\r\n");
      out.write("body{\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tbackground: #fff;\r\n");
      out.write("\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: Arial;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".body{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 2px;\r\n");
      out.write("\tleft: 2px;\r\n");
      out.write("\tright: 2px;\r\n");
      out.write("\tbottom: 2px;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tbackground-image: url(\"img/bike.JPG\");\r\n");
      out.write("\tbackground-size: cover;\r\n");
      out.write("\t-webkit-filter: blur(10px);\r\n");
      out.write("\t-moz-filter: blur(10px);\r\n");
      out.write("\tfilter: blur(10px);\r\n");
      out.write("\tz-index: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".grad{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 2px;\r\n");
      out.write("\tleft: 2px;\r\n");
      out.write("\tright: 2px;\r\n");
      out.write("\tbottom: 2px;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */\r\n");
      out.write("\tbackground: -moz-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("\topacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(20% - 35px);\r\n");
      out.write("\tleft: calc(65% - 375px);\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header div{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 35px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header div span{\r\n");
      out.write("\tcolor: #5379fa !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 28%;\r\n");
      out.write("\tleft: calc(37% - 30px);\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=text]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=number]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=date]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=time]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=button]:hover{\r\n");
      out.write("\topacity: 0.8;\r\n");
      out.write("\t-webkit-opacity: 0.8;\r\n");
      out.write("\t-moz-opacity: 0.8;\r\n");
      out.write("\t-ms-opacity: 0.8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=button]:active{\r\n");
      out.write("\topacity: 0.6;\r\n");
      out.write("\t-webkit-opacity: 0.6;\r\n");
      out.write("\t-moz-opacity: 0.6;\r\n");
      out.write("\t-ms-opacity: 0.6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=text]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=number]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=date]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=time]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login table input[type=button]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-webkit-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-moz-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/prefixfree.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"font-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\">\r\n");
      out.write("\r\n");
      out.write("  \t\t<div class=\"body\"></div>\r\n");
      out.write("\t\t<div class=\"grad\"></div>\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div>Bicycle<span>Sharing</span>System</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div class=\"login\" ><form action=\"#\" method=\"GET\" > \r\n");
      out.write("        \t\t<table cellpadding=\"5\" cellspacing=\"5\">\r\n");
      out.write("                            ");
 
                                String tid = session.getAttribute("tid_end").toString();
                                String cid = session.getAttribute("cid_end").toString();
                                String uid = session.getAttribute("uid_end").toString();
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                                PreparedStatement pst = cn.prepareStatement("select * from CYCLE.curr_trans where tid=?;");
                                pst.setString(1,tid);
                                ResultSet rs = pst.executeQuery();
                                rs.next();
                                String fromStand = session.getAttribute("fromStand_end").toString();
                                String toStand = session.getAttribute("pos").toString();
                                String issuer = session.getAttribute("issuer_end").toString();
                                String ret = session.getAttribute("email").toString();
                                Date fromDate = rs.getDate("entryTime");
                                pst = cn.prepareStatement("delete from CYCLE.curr_trans where tid=?;");
                                pst.setString(1, tid);
                                pst.executeUpdate();
                                pst = cn.prepareStatement("insert into CYCLE.history (tid,uname,empidIssue,empidReturn,cid,fromDate,fromStand,toStand,rent) values (?,?,?,?,?,?,?,?,?);");
                                pst.setString(1,tid );
                                pst.setString (2,uid);
                                pst.setString(3,issuer);
                                pst.setString(4,ret);
                                pst.setString(5,cid);
                                pst.setDate(6,fromDate);
                                pst.setString(7,fromStand);
                                pst.setString(8,toStand);
                                pst.setInt(9,Integer.parseInt(session.getAttribute("rent_end").toString()));
                                pst.executeUpdate();
                                pst = cn.prepareStatement("update CYCLE.cycle_info set travelMode=?,stand=? where cid=?;");
                                pst.setBoolean(1,false);
                                pst.setString(2,toStand);
                                pst.setString(3,cid);
                                pst.executeUpdate();
                                pst = cn.prepareStatement("update CYCLE.user set status=?,deposit=? where email=?;");
                                pst.setBoolean(1,false);
                                if(request.getAttribute("rdeposit").toString().equals("y"))
                                {
                                    pst.setBoolean(2,false);
                                }
                                else
                                {
                                    pst.setBoolean(2,true);
                                }
                                pst.setString(3,uid);
                                pst.executeUpdate();   
                                session.removeAttribute("issuer_end");
                                session.removeAttribute("tid_end");
                                session.removeAttribute("fromStand_end");
                                session.removeAttribute("fromDate_end");
                                session.removeAttribute("rent_end");
                                session.removeAttribute("uid_end");
                                session.removeAttribute("cid_end");
                                cn.close();
                            
      out.write("\r\n");
      out.write("                <tr><td>\r\n");
      out.write("                        Final Payment</td><td><input type=\"text\" required placeholder=\"Final Payment\" readonly=\"\" value=\"");
      out.print( session.getAttribute("tid") );
      out.write("\" name=\"fpayment\"/></td></tr>\r\n");
      out.write("                <tr><td>Amount to be returned</td><td><input type=\"text\" required placeholder=\"Amount\" readonly=\"\" value=\"");
 int i=Integer.parseInt(session.getAttribute("rent_end").toString());
                        if(request.getParameter("rent").equals("y"))
                        {
                            i = i + 300;
                                }
                out.print(i);
      out.write("\" name=\"amount\" /></td></tr>\r\n");
      out.write("                <!--<tr><td>Adjustment</td><td><input type=\"text\" readonly=\"\" value=\"\" required placeholder=\"Amount\" name=\"adjust\" /></td></tr>-->\r\n");
      out.write("                    <tr><td colspan=\"2\"><center><input type=\"button\" value=\"FINAL\"/></center></td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t</div></form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
