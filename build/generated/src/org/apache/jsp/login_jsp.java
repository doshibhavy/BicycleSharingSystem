package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("  <title>Login - Bicycle Sharing System</title>\r\n");
      out.write("  \r\n");
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
      out.write("\ttop: calc(50% - 35px);\r\n");
      out.write("\tleft: calc(50% - 375px);\r\n");
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
      out.write(".login{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(50% - 75px);\r\n");
      out.write("\tleft: calc(50% - 30px);\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=text]{\r\n");
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
      out.write(".login input[type=password]{\r\n");
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
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]{\r\n");
      out.write("\twidth: 260px;\r\n");
      out.write("\theight: 35px;\r\n");
      out.write("\tbackground: #fff;\r\n");
      out.write("\tborder: 1px solid #fff;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #a18d6c;\r\n");
      out.write("\tfont-family: 'Exo', sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 6px;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]:hover{\r\n");
      out.write("\topacity: 0.8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]:active{\r\n");
      out.write("\topacity: 0.6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=text]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=password]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]:focus{\r\n");
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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"body\"></div>\r\n");
      out.write("\t\t<div class=\"grad\"></div>\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div>Bicycle<span>Sharing</span>System</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("                <div class=\"login\" ><form action=\"checkLogin\" method=\"GET\">\r\n");
      out.write("                        ");
 session.invalidate(); 
      out.write("\r\n");
      out.write("                        <input type=\"text\" placeholder=\"username\" name=\"user\" required=\"\"><br>\r\n");
      out.write("                        <input type=\"password\" placeholder=\"password\" required=\"\" name=\"password\"><br>\r\n");
      out.write("                                <input type=\"submit\" value=\"Login\"></form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write(" <!-- <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>-->\r\n");
      out.write("\r\n");
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
