<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: white;
	width: 70%;
	hieght: 80%;
	margin-left: 20%;
}

* {
	box-sizing: border-box;
}

.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/components/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/components/topbar.jsp"></jsp:include>

	${error}
	<form name=frmEdit action="editprofile" method="post">
		<input type=hidden name=user_id value="${user.ID}">
		<div class="container">
			<h1>Edit-Profile</h1>
			<hr>
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="pwd" id="psw" required> <label
				for="psw-repeat"><b>Repeat Password</b></label> <input
				type="password" placeholder="Repeat Password" name="pwd2"
				id="psw-repeat" required> <label for="psw-repeat"><b>First
					name*</b></label> <input type="text" placeholder="First name" name="fname"
				value="${user.fname }" id="psw-repeat" required> <label
				for="psw-repeat"><b>Last name*</b></label> <input type="text"
				placeholder="Last name" name="lname" value="${user.lname }"
				id="psw-repeat" required> <label for="psw-repeat"><b>Age*</b></label>
			<input type="text" placeholder="Age" name="age" value="${user.age }"
				id="psw-repeat" required> <label for="psw-repeat"><b>Address</b></label>
			<input type="text" placeholder="Address" name="address"
				value="${user.address }" id="psw-repeat" required>


			<button type="submit" class="registerbtn">Update</button>
		</div>

	</form>
	<jsp:include page="/WEB-INF/view/components/footer.jsp"></jsp:include>

</body>
</html>
