<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
<%@ include file="/auth.jsp" %>
  <title>End - Bicycle Sharing System</title>

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
		<div class="login" ><form action="#" method="GET" > 
        		<table cellpadding="5" cellspacing="5">
                            <% 
                                String tid = session.getAttribute("tid_end").toString();
                                String cid = session.getAttribute("cid_end").toString();
                                String uid = session.getAttribute("uid_end").toString();
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycle?zeroDateTimeBehavior=convertToNull","bhavy","bhavy");
                                PreparedStatement pst = cn.prepareStatement("select * from CYCLE.curr_trans where tid=?;");
                                pst.setString(1,tid);
                                ResultSet rs = pst.executeQuery();
                                rs.next();
                                String fromStand = session.getAttribute("fromStand_end").toString();
                                String toStand = session.getAttribute("pos").toString();
                                String issuer = session.getAttribute("issuer_end").toString();
                                String ret = session.getAttribute("email").toString();
                                Date fromDate = rs.getDate("entryTime");
                                pst = cn.prepareStatement("delete from CYCLE.curr_trans where tid=?;");
                                pst.setString(1, tid);
                                pst.executeUpdate();
                                pst = cn.prepareStatement("insert into CYCLE.history (tid,uname,empidIssue,empidReturn,cid,fromDate,fromStand,toStand,rent) values (?,?,?,?,?,?,?,?,?);");
                                pst.setString(1,tid );
                                pst.setString (2,uid);
                                pst.setString(3,issuer);
                                pst.setString(4,ret);
                                pst.setString(5,cid);
                                pst.setDate(6,fromDate);
                                pst.setString(7,fromStand);
                                pst.setString(8,toStand);
                                pst.setInt(9,Integer.parseInt(session.getAttribute("rent_end").toString()));
                                pst.executeUpdate();
                                pst = cn.prepareStatement("update CYCLE.cycle_info set travelMode=?,stand=? where cid=?;");
                                pst.setBoolean(1,false);
                                pst.setString(2,toStand);
                                pst.setString(3,cid);
                                pst.executeUpdate();
                                pst = cn.prepareStatement("update CYCLE.user set status=?,deposit=? where email=?;");
                                pst.setBoolean(1,false);
                                pst.setBoolean(2,true);
                                pst.setString(3,uid);
                                pst.executeUpdate();   
                                cn.close();
                            %>
                <tr><td>
                        Transaction ID : </td><td><input type="text" required placeholder="Final Payment" readonly="" value="<%= session.getAttribute("tid_end") %>" name="fpayment"/></td></tr>
               <%
                                session.removeAttribute("issuer_end");
                                session.removeAttribute("tid_end");
                                session.removeAttribute("fromStand_end");
                                session.removeAttribute("fromDate_end");
                                session.removeAttribute("rent_end");
                                session.removeAttribute("uid_end");
                                session.removeAttribute("cid_end");%>
                <!--<tr><td>Adjustment</td><td><input type="text" readonly="" value="" required placeholder="Amount" name="adjust" /></td></tr>-->
                    <tr><td colspan="2"><center><input type="button" value="FINAL" onclick="window.open('dashboard.jsp','_self')"/></center></td></tr>
                </table>
		</div></form>
</body>
</html>