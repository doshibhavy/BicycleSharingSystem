<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<%@ include file="/auth.jsp" %>
<head>

  <meta charset="UTF-8">

  <title>Issue - Bicycle Sharing System</title>

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
	left: calc(39% - 30px);
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

.login table center input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 600;
	padding: 6px;
	margin-top: 10px;
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

.login table center input[type=submit]:hover{
	opacity: 0.8;
	-webkit-opacity: 0.8;
	-moz-opacity: 0.8;
	-ms-opacity: 0.8;
}

.login table center input[type=submit]:active{
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

.login table center input[type=submit]:focus{
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
		<div class="login" ><form action="checkDoc" method="GET" ><table cellpadding="5" cellspacing="5"><tr><td>
				User Id</td><td><% 
                    if(request.getParameter("code")!=null)
                    {
                        out.print("<font color=red>User is already out with cycle ...</font><br/>");
                    }
                %><input type="text" required placeholder="User id" name="uid"/></td></tr>
                            <!--<tr><td >Name</td><td><input type="text" required placeholder="User Name" name="uname" readonly=""/></td></tr>-->
                            <tr><td>From</td><td><input type="text" required placeholder="Stand Name" readonly="" name="fromStand" value="<%= session.getAttribute("pos")%>" /></td></tr>
                <tr><td>To</td><td><input type="text" required placeholder="Stand Name" name="toStand"/></td></tr>
                <tr><td>From Date</td><td><input type="text" required name="fromDate" value="<% java.util.Date dNow = new java.util.Date();
   SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
   out.print( ft.format(dNow)); %>" readonly=""/></td></tr>
                <tr><td>To Date</td><td><input type="date" required name="toDate" /></td></tr>
				<!--<tr><td>Time</td><td><input type="time" required name="time"/></td></tr>-->
                                <tr><td>Rent</td><td><input type="number" required placeholder="Rent" name="rent" /></td></tr>
                <tr><td colspan="2"><center><input type="submit" value="NEXT"/>
                </center></td></tr>
                </table></form>
		</div>




</body>

</html>