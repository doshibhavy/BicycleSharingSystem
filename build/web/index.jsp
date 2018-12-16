<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Home - Bicycle Sharing System</title>

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
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url("img/bike.JPG");
	background-size: cover;
	object-fit:contain;
	-webkit-filter: blur(10px);
	-moz-filter: blur(10px);
	filter: blur(10px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
	background: -moz-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(20% - 35px);
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

.header a{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 20px;
	font-weight: 400;
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
	font-weight: 800;
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

.header div span{
	color: #5379fa !important;
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
			<div style="font-size:40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bicycle<span>Sharing</span>System</div>
            <div class="login" style="font-size:25px;margin-top:5%;margin-left:-25%;">
            <br><center>Hello..!! Welcome to <font color="#5379fa">Bicycle</font> Sharing <font color="#5379fa">System</font>..!!</center><br><center><font color="green"> GO GREEN..!!</font> GO<font color="#5379fa"> TRIN TRIN </font>..!!</center>
            <br><br> Bicycle Sharing System is to promote the culture of non motorized transportation. You can register and enjoy the bicycle riding. Here you can get the availability of the bicycle. It is easy to use, just you have to register to the system. Get your ID and Password and login to the system. One can easily issue and return the bicycle. <br><br><center><font color="#5379fa">Enjoy</font> Your <font color="#5379fa">Ride</font> ...!!</center>  <br><br>
            <center><input type="submit" value="Register" onClick="window.open('register.jsp','_self')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            		<input type="submit" value="Employee Login " onClick="window.open('login.jsp','_self')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				                    <input type="submit" value="User Login " onClick="window.open('login.jsp','_self')"></center></div>
		</div>
		<br>
		

<!--  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
-->
</body>

</html>