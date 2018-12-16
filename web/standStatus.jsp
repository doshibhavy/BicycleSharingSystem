<%@page import="java.sql.*"%>
<!DOCTYPE html>
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
	background-image: url("img/a.jpg");
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
                <% 
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
        PreparedStatement pst = cn1.prepareStatement("select count(*) from CYCLE.cycle_info;");
        ResultSet rs1=pst.executeQuery();
        if(request.getParameter("stand")!=null)
        {
            
        
      %>
      <div class="login" ><form action="<% if(session.getAttribute("userType").equals("customer")){out.print("client.jsp");}else{out.print("dashboard.jsp");}%>" method="POST" >
                        <table cellpadding="5" cellspacing="5">
                            <tr>
                                <td>Total bicycle</td>
                                <td><input type="number" value="<%rs1.next();out.print(rs1.getString(1)); %>" readonly name="total"/></td>
                            </tr>
                <tr>
                    <td>Bicycle in Travel Mode </td>
                    <td><input type="number" value="<%pst=cn1.prepareStatement("select count(*) from CYCLE.cycle_info where travelMode=1;");rs1=pst.executeQuery();rs1.next();out.print(rs1.getString(1)); %>" readonly name="tmode" /></td>                </tr>
                <tr>
                    <td>Total Bicycle in stock</td>
                    <td><input type="number" value="<% pst=cn1.prepareStatement("select count(*) from CYCLE.cycle_info where travelMode=0;");rs1=pst.executeQuery();rs1.next();out.print(rs1.getString(1));%>" readonly name="stock" /></td>
                </tr>
                <tr>
                    <td>Total stand with bicycle</td>
                    <td><input type="number" value="<%pst=cn1.prepareStatement("select distinct count(stand) from CYCLE.cycle_info where travelMode=0 group by stand;");rs1=pst.executeQuery();rs1.next();out.print(rs1.getString(1)); %>" readonly name="stand"/></td>
                </tr>
                <tr>
                    <td>Stock at Stand <% out.print(": "+request.getParameter("stand")+""); %></td>
                    <td><input type="number" value="<%pst=cn1.prepareStatement("select count(*) from CYCLE.cycle_info where travelMode=0 AND stand=?;");pst.setString(1,request.getParameter("stand")+"");rs1=pst.executeQuery();rs1.next();out.print(rs1.getString(1)); %>" readonly name="stockstand"/></td>
                </tr>
                <tr>
                    <td></td><td><center><input type="submit" value=" Home "/></center></td>
                </tr>
                </table>
		</div>
</form>
 <% }
    else
        {
       %>
       <div class="login" ><form action="standStatus.jsp" method="POST" >
                        <table cellpadding="5" cellspacing="5">
                            <tr>
                                <td>Select Stand</td>
                                <td><center><select name="stand" required="">
                                                <% 
                                                    pst = cn1.prepareStatement("select distinct stand from CYCLE.cycle_info ;");
                                                    rs1 = pst.executeQuery();
                                                    while(rs1.next())
                                                    {out.println("<option value=\""+rs1.getString(1)+"\">"+rs1.getString(1)+"</option>");}
        
        }
                                                %>
                                </select></center></td>
                            </tr>
                            <tr>
                                <td colspan="2"><center><input type="submit" value="Check Status"/></center></td>
                            </tr>
                        </table></form></div>
</body>

</html>