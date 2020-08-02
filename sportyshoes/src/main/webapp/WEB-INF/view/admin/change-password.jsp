<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

#customers tr:nth-child(1) {
	background-color: #19194d;
	color: white;
}
</style>
</head>
<title>Admin - Change Password</title>
<body>
	<jsp:include page="/WEB-INF/view/components/admin-header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/components/admin-topbar.jsp"></jsp:include>

	${error }
	<form name=frmPwd method=post action="adminchangepwdaction">
		<table id="customers">
			<tr>
				<td width=25%>Enter new password*</td>
				<td><input name=pwd maxlength=10 type="password"></td>
			</tr>
			<tr>
				<td width=25%>Confirm new Password*</td>
				<td><input name=pwd2 maxlength=10 type="password"></td>
			</tr>
			<tr>
				<td colspan=2>
					<button>Login</button>
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/view/components/admin-footer.jsp"></jsp:include>
</body>
</html>
