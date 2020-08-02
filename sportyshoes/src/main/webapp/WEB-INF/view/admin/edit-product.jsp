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
	width: 50%;
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
<title>Admin - Add/Edit Product</title>
<body>
	<jsp:include page="/WEB-INF/view/components/admin-header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/components/admin-topbar.jsp"></jsp:include>

	<%
if (request.getParameter("error") != null)
	out.print(request.getParameter("error"));
%>

	<form name=frmProduct method=post action="admineditproductaction">
		<input type=hidden name=id value="${product.ID }">
		<table id="customers">
			<tr>
				<td width=25%>Product name*</td>
				<td><input name=name maxlength=100 value="${product.name }"></td>
			</tr>
			<tr>
				<td width=25%>Price*</td>
				<td><input name=price type="numeric" maxlength=6
					value="${product.price }"></td>
			</tr>
			<tr>
				<td width=25%>Category*</td>
				<td><select name=category>
						<option value="0">Select category</option> ${catDropdown}
				</select></td>
			</tr>

			<tr>
				<td colspan=2>
					<button>Save</button>
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/view/components/admin-footer.jsp"></jsp:include>

</body>
</html>
