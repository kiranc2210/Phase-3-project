<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
	width: 70%;
	height: 80%;
	margin-left: 20%;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
</head>
<body>

	<ul>
		<li><a href="home">Home</a></li>

		<% if (session.getAttribute("user_id") == null ) { %>
		<li><a href="login">Login/Signup</a></li>
		<li style="float: right"><a class="active" href="adminlogin">Admin
				Login</a></li>
		<% }  else { %>
		<li><a href="dashboard">Dashboard</a></li>
		<li><a href="cart">Cart</a></li>
		<li><a href="editprofile">Edit Profile</a></li>
		<li><a href="memberpurchases">Your Orders</a></li>
		<li style="float: right"><a href="logout">Logout</a></li>

		<% }  %>
	</ul>

</body>
</html>