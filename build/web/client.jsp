<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Client Area</title>
<%@ include file="/auth.jsp" %>
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
	object-fit:contain;
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
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
	background: -moz-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65)));
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(5%);
	height:inherit;
	width:calc(100%);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 70px;
	font-weight: 500;
}

.header a{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 20px;
	font-weight: 400;
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
.main
{
	position:absolute;
	height:calc(70%);
	width:calc(85%);
	top:calc(20%);
	left:calc(7.5%);
	z-index:7;
}
.subSquare
{
	position:absolute;
	width:calc(20%);
	height:calc(35%);
	border-color:inherit;
	border-style:solid;
	z-index:8;
}
/* Dropdown Button */
.dropbtn {
    background-color: transparent;
    color: white;
	top:calc(0%);
    padding: 16px;
    font-size: calc(70%);
	font-weight:200;
    border: none;
    cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f0f0f0;
    min-width: calc(100%);
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
	font-size:calc(60%);
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}

</style>

   <!-- <script src="js/prefixfree.min.js"></script>-->

</head>

<body>
<script >
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
<div style="z-index:10;position:absolute;top:calc(10%);right:calc(10%);font-size:calc(200%);font-weight:400" class="dropdown"><button onclick="window.open('login.jsp','_self')" class="dropbtn">Logout</button><div id="myDropdown" class="dropdown-content">
  
  </div></div>
  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div style="font-size:40px;margin-top:5%;font-size:40px;font-weight:400;width:calc(100%);text-align:center;x"><center>Bicycle<span>Sharing</span>System</center></div>   
            
		</div>
        <div class="main">
        	<div class="subSquare" style="left:calc(5%);top:calc(33.33%);background-color:white;"><img src="img/history.png" alt="No Image" style="height:calc(75%);width:calc(90%);left:calc(5%);top:calc(0%);position:absolute;"/><div style="width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;"><a href="#">View History</a></div></div>
            <div class="subSquare" style="left:calc(39.5%);top:calc(33.33%);background-color:white;"><img src="img/person.png" alt="No Image" style="height:calc(75%);width:calc(80%);left:calc(9%);top:calc(0%);position:absolute;"/><div style="width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;"><a href="#">Edit Profile</a></div></div>
            <div class="subSquare" style="left:calc(74%);top:calc(33.33%);background-color:white;"><img src="img/cycle.png" alt="No Image" style="height:calc(95%);width:calc(90%);left:calc(5%);top:calc(0%);position:absolute;"/><div style="width:calc(100%);height:calc(20%);top:calc(80%);z-index:8;position:absolute;width:calc(100%);text-align:center;background-color:transparent;font-family: 'Exo', sans-serif;font-size:calc(200%);font-weight: 400;"><a href="standStatus.jsp">View Stock</a></div></div>
        </div>
		<br>

<!--  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
-->
</body>

</html>