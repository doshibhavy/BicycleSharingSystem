<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Registration - Bicycle Sharing System</title>

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
	top: calc(50%);
	left: calc(50% - 400px);
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
	top: 20%;
	left: calc(50% - 30px);
	height: auto;
	width: auto;
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

.login input[type=email]{
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

.login input[type=radio]{
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


.login input[type=date]{
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
	-webkit-opacity: 0.8;
	-moz-opacity: 0.8;
	-ms-opacity: 0.8;
}

.login input[type=submit]:active{
	opacity: 0.6;
	-webkit-opacity: 0.6;
	-moz-opacity: 0.6;
	-ms-opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=email]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=date]:focus{
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
                <div class="login" ><form action="registerUser" method="GET" ><% if(request.getParameter("code")!=null){out.print("<font color=red>Email ID already exist ...</font><br>");}
                %>
				<input type="text" required placeholder="First Name" name="Fname"/><br>
                <input type="text" required placeholder="Last Name" name="Lname" style="margin-top:10px"/><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" required name="gen" value="M"/>&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gen" value="F" style="margin-top:10px"/>&nbsp;&nbsp;&nbsp;&nbsp;Female<br>
                <input type="email" required placeholder="Email Id" name="email" style="margin-top:10px"/><br>
                <input type="date" required name="bdate" style="margin-top:10px"/><br>
                <input type="text" required placeholder="Mobile Number" name="phone" maxlength="10" min="7000000000" max="9999999999" style="margin-top:10px"/><br>
				<input type="password" required placeholder="password" name="pwd"><br>
				<input type="submit" value="Register"/></form>
                <small style="">By Clicking Register you agree with our Terms and Condition.</small>
		</div>

 <!-- <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>-->



</body>

</html>