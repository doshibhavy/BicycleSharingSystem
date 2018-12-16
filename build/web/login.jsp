<%@page import="java.util.Enumeration"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <title>Login - Bicycle Sharing System</title>
  
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
	top: calc(50% - 35px);
	left: calc(50% - 375px);
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

.login{
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 30px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text]{
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

.login input[type=password]{
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
	margin-top: 10px;
}

.login input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=submit]:hover{
	opacity: 0.8;
}

.login input[type=submit]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=submit]:focus{
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

<body>

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
                    <div>Bicycle<span>Sharing</span>System
                        <%--
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                            PreparedStatement pst = cn1.prepareStatement("select count(*) from CYCLE.cycle_info where travelMode=0;");
                            ResultSet rs1=pst.executeQuery();
                            rs1.next();
                            out.println(rs1.getString(1));
                        --%>
                    </div>
		</div>
		<br>
                <div class="login" ><form action="checkLogin" method="GET">
                        <% session.invalidate(); %>
                        <input type="text" placeholder="username" name="user" required=""><br>
                        <input type="password" placeholder="password" required="" name="password"><br>
                                <input type="submit" value="Login"></form>
		</div>

</body>

</html>