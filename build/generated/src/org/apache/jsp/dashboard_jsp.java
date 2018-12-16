package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("  <title>Dashboard</title>\r\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            try
            {
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
                    //out.print("<font color=red style=\"z-index:15;\">"+rs1.getString("email")+" || "+rs1.getString("type")+" || "+rs1.getString("authKey")+"</font>");
                    cn1.close();
                }
                else
                {
                    session.invalidate();
                    cn1.close();
                    response.sendRedirect("/login.jsp");
                }
            }
            }
            catch(Exception ex)
            {
                out.print("<font color=red style=\"z-index:15;\">"+ex.getLocalizedMessage()+ex.getMessage()+ex.getClass()+ex.getCause()+"</font>");
            }
            
      out.write("\n");
      out.write("  ");
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
      out.write("\tobject-fit:contain;\r\n");
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
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));\r\n");
      out.write("\tbackground: -moz-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("\topacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(5%);\r\n");
      out.write("\theight:inherit;\r\n");
      out.write("\twidth:calc(100%);\r\n");
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
      out.write(".header a{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header div span{\r\n");
      out.write("\tcolor: #5379fa !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-webkit-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-moz-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write(".main\r\n");
      out.write("{\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\theight:calc(70%);\r\n");
      out.write("\twidth:calc(85%);\r\n");
      out.write("\ttop:calc(20%);\r\n");
      out.write("\tleft:calc(7.5%);\r\n");
      out.write("\tz-index:7;\r\n");
      out.write("}\r\n");
      out.write(".subSquare\r\n");
      out.write("{\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\twidth:calc(30%);\r\n");
      out.write("\theight:calc(40%);\r\n");
      out.write("\tborder-color:none;\r\n");
      out.write("\tborder-style:solid;\r\n");
      out.write("\tz-index:8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Dropdown Button */\r\n");
      out.write(".dropbtn {\r\n");
      out.write("    background-color: transparent;\r\n");
      out.write("    color: white;\r\n");
      out.write("\ttop:calc(0%);\r\n");
      out.write("    padding: 16px;\r\n");
      out.write("    font-size: calc(70%);\r\n");
      out.write("\tfont-weight:200;\r\n");
      out.write("    border: none;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The container <div> - needed to position the dropdown content */\r\n");
      out.write(".dropdown {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Dropdown Content (Hidden by Default) */\r\n");
      out.write(".dropdown-content {\r\n");
      out.write("    display: none;\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    background-color: #f0f0f0;\r\n");
      out.write("    min-width: calc(100%);\r\n");
      out.write("    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Links inside the dropdown */\r\n");
      out.write(".dropdown-content a {\r\n");
      out.write("    color: black;\r\n");
      out.write("    padding: 12px 16px;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("\tfont-size:calc(60%);\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Change color of dropdown links on hover */\r\n");
      out.write(".dropdown-content a:hover {background-color: #f1f1f1}\r\n");
      out.write("\r\n");
      out.write("/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */\r\n");
      out.write(".show {display:block;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<script >\r\n");
      out.write("function myFunction() {\r\n");
      out.write("    document.getElementById(\"myDropdown\").classList.toggle(\"show\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Close the dropdown menu if the user clicks outside of it\r\n");
      out.write("window.onclick = function(event) {\r\n");
      out.write("  if (!event.target.matches('.dropbtn')) {\r\n");
      out.write("\r\n");
      out.write("    var dropdowns = document.getElementsByClassName(\"dropdown-content\");\r\n");
      out.write("    var i;\r\n");
      out.write("    for (i = 0; i < dropdowns.length; i++) {\r\n");
      out.write("      var openDropdown = dropdowns[i];\r\n");
      out.write("      if (openDropdown.classList.contains('show')) \r\n");
      out.write("\t  {\r\n");
      out.write("        openDropdown.classList.remove('show');\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<div style=\"z-index:10;position:absolute;top:calc(10%);right:calc(10%);font-size:calc(200%);font-weight:400\" class=\"dropdown\"><button onclick=\"window.open('login.jsp','_self')\" class=\"dropbtn\">Logout</button><div id=\"myDropdown\" class=\"dropdown-content\">\r\n");
      out.write("  </div></div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"body\"></div>\r\n");
      out.write("\t\t<div class=\"grad\"></div>\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div style=\"font-size:40px;margin-top:5%;font-size:40px;width:calc(100%);font-weight:400;\ttext-align:center;x\"><center>Bicycle<span>Sharing</span>System</center></div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\t\t</div>\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(2.5%);top:calc(13.33%);background-color:white;\"><img src=\"img/history.png\" alt=\"No Image\" style=\"height:calc(75%);width:calc(90%);left:calc(5%);top:calc(0%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"issue.jsp\">Issue</a></div></div>\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(35%);top:calc(13.33%);background-color:white;\"><img src=\"img/return.png\" alt=\"No Image\" style=\"height:calc(100%);width:calc(110%);left:calc(-5%);top:calc(0%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"return.jsp\">Return</a></div></div>\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(67.5%);top:calc(13.33%);background-color:white;\"><img src=\"img/GPS.png\" alt=\"No Image\" style=\"height:calc(70%);width:calc(75%);left:calc(10%);top:calc(3%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"#\">Current Tracking</a></div></div>\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(2.5%);top:calc(56.66%);background-color:white;\"><img src=\"img/bike.JPG\" alt=\"No Image\" style=\"height:calc(80%);width:calc(80%);left:calc(9%);top:calc(0%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"#\">Stand Status</a></div></div>\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(35%);top:calc(56.66%);background-color:white;\"><img src=\"img/warehouse.jpg\" alt=\"No Image\" style=\"height:calc(75%);width:calc(90%);left:calc(5%);top:calc(0%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"#\">Warehouse</a></div></div>\r\n");
      out.write("            <div class=\"subSquare\" style=\"left:calc(67.5%);top:calc(56.66%);background-color:white;\"><img src=\"img/maintenance.png\" alt=\"No Image\" style=\"height:calc(80%);width:calc(75%);left:calc(9%);top:calc(0%);position:absolute;\"/><div style=\"width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;\"><a href=\"#\">Maintenance</a></div></div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
