<%@page import="java.sql.*"%>

        <%
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
            %>
  