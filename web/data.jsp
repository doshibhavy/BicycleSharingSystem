<%-- 
    Document   : data
    Created on : 2 Oct, 2016, 1:06:16 PM
    Author     : Bhavy
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%                      Enumeration<String> ex = session.getAttributeNames();
                    out.print("<font color=black> ses id : "+session.getId());
                    while(ex.hasMoreElements())
                    {
                        String nm = (String)ex.nextElement();
                        out.print("<br>"+nm+" : "+session.getAttribute(nm));
                    }
                    out.print("</font>"); %>
                    
                    
                    
                    
                    
                    

    </body>
</html>
