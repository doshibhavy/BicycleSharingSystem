package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class auth_jsp extends org.apache.jasper.runtime.HttpJspBase
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
