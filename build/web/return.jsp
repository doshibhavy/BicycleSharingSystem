<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/auth.jsp" %>
<!DOCTYPE html>
<html>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull"
     user="bhavy"  password="bhavy"/>
<head>
  <meta charset="UTF-8">
  <title>Return - Bicycle Sharing System</title>
    <style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: #fff;

	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: 2px;
	left: 2px;
	right: 2px;
	bottom: 2px;
	width: auto;
	height: auto;
	background-image: url("img/bike.JPG");
	background-size: cover;
	-webkit-filter: blur(10px);
	-moz-filter: blur(10px);
	filter: blur(10px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: 2px;
	left: 2px;
	right: 2px;
	bottom: 2px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	background: -moz-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(20% - 35px);
	left: calc(65% - 375px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 400;
}

.header div span{
	color: #5379fa !important;
}

.login table{
	position: absolute;
	top: 25%;
	left: calc(37% - 30px);
	height: auto;
	width: auto;
	padding: 10px;
	z-index: 2;
}

.login table input[type=radio]{
	width: 20px;
	height: 20px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login table input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login table input[type=number]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login table input[type=date]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login table input[type=time]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login table input[type=button]:hover{
	opacity: 0.8;
	-webkit-opacity: 0.8;
	-moz-opacity: 0.8;
	-ms-opacity: 0.8;
}

.login table input[type=button]:active{
	opacity: 0.6;
	-webkit-opacity: 0.6;
	-moz-opacity: 0.6;
	-ms-opacity: 0.6;
}

.login table input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login table input[type=number]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login table input[type=date]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login table input[type=time]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login table input[type=button]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}
</style>

    <script src="js/prefixfree.min.js"></script>

</head>

<body style="font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;">

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Bicycle<span>Sharing</span>System</div>
		</div>
		<br>
                <div class="login" ><form action="<% if(request.getParameter("tid")==null){out.print("return.jsp");}else{out.print("end.jsp");}%>" method="get" ><table cellpadding="5" cellspacing="5"><tr><td>
				Transaction Id</td><td><input type="text" required value="<c:out value="${param.tid}"/>" placeholder="Transaction id" name="tid"/></td></tr>
                            <c:if test="${param.tid!=null}">
                                <sql:query dataSource="${snapshot}" var="result1">
		SELECT * from CYCLE.curr_trans where tid='<c:out value="${param.tid}"/>';
	</sql:query>
        <c:set var="rec" value="0"/>
        <c:forEach var="row1" items="${result1.rows}">
            <c:set var="rec" value="1"/>
            <tr><td >Name</td><td><input type="text" required readonly="" value="<c:out value="${row1.uid}"/>" name="name" /></td></tr>
                            <tr><td>From Stand</td><td><input type="text" required name="from" readonly="" value="<c:out value="${row1.fromStand}"/>"/></td></tr>
                            <tr><td>From Date</td><td><input type="text" required="" name="date" readonly="" value="<c:forEach begin="1" end="6" var="i"><c:out value="${fn:substring(row1.entryTime, 10-i,10-i+1)}"/></c:forEach><c:out value="${fn:substring(row1.entryTime, 0,4)}"/>"/></td></tr>
                
                <tr><td>Current Stand</td><td><input type="text" readonly="" value="<%= session.getAttribute("pos") %>" placeholder="Current Stand Name" name="curstnd"/></td></tr>
                
                <% 
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                    PreparedStatement pst = cn.prepareStatement("select * from CYCLE.curr_trans where tid=?;");
                    pst.setString(1,request.getParameter("tid"));
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                    
                    session.setAttribute("issuer_end", rs.getString("issuer"));
                    if(request.getParameter("tid")!=null)
                    {
                        session.setAttribute("tid_end",request.getParameter("tid"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    if(rs.getString("fromStand")!=null)
                    {
                        session.setAttribute("fromStand_end",rs.getString("fromStand"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    if(rs.getString("entryTime")!=null)
                    {
                        session.setAttribute("fromDate_end",rs.getDate("entryTime"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    if(rs.getString("rent")!=null)
                    {
                        session.setAttribute("rent_end",rs.getString("rent"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    if(rs.getString("uid")!=null)
                    {
                        session.setAttribute("uid_end",rs.getString("uid"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    if(rs.getString("cid")!=null)
                    {
                        session.setAttribute("cid_end",rs.getString("cid"));
                    }
                    else
                    {
                        response.sendRedirect("dashboard.jsp");
                    }
                    cn.close();
                %>
        </c:forEach><c:if test="${rec==0}"><c:redirect url="return.jsp?code=IV"/></c:if></c:if>
                <tr><td colspan="2"><center><input type="submit" value="END"/></center></td></tr>
                        </table></form>
		</div>



</body>

</html>