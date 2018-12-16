<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="/auth.jsp" %>
<html>

<head>

  <meta charset="UTF-8">

  <title>Receipt - Bicycle Sharing System</title>

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
	top: 28%;
	left: calc(37% - 30px);
	height: auto;
	width: auto;
	padding: 10px;
	z-index: 2;
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
		<div class="login" ><form action="#" method="GET" ><table cellpadding="5" cellspacing="5"><tr><td>
				<!--Receipt Number</td><td><input type="text" required placeholder="Receipt Number" name="rcptno"/></td></tr>-->
                            <tr><td>Transaction Id</td><td><input type="text" required placeholder="Transaction Id" value="<%= session.getAttribute("tid") %>" readonly=""/></td></tr>
                <!--<tr><td>Ride Number</td><td><input type="text" required placeholder="Ride Number" name="ridno" /></td></tr>-->
                <tr><td>Amount to be Paid</td><td><input type="number" required placeholder="Amount" name="amount" value="<%= session.getAttribute("rent") %>" readonly=""/></td></tr>
                <tr><td></td><td><center><input type="button" value="Home" onclick="window.open('dashboard.jsp','_self')"/></center></td></tr>
                </table>
		</div>
</form>
 <%
    session.removeAttribute("tid");
    session.removeAttribute("userID");
    session.removeAttribute("uName");
    session.removeAttribute("rent");
    session.removeAttribute("toStand");
    session.removeAttribute("toDate");
    session.removeAttribute("userDeposit");
    session.removeAttribute("proof");
 %>
</body>

</html>