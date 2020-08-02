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
	width: 30%;
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
<body>
	<jsp:include page="/WEB-INF/view/components/admin-header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/components/admin-topbar.jsp"></jsp:include>

	Total Categories: ${list.size()} &nbsp;&nbsp;
	<a href="admineditcat?id=0">Add Category</a>
	<br>
	<table id="customers">
		<tr>
			<td><b>Category</b></td>
			<td></td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.name }</td>
				<td><a href="admineditcat?id=${item.ID}">Edit</a> | <a
					href="admindeletecat?id=${item.ID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<jsp:include page="/WEB-INF/view/components/admin-footer.jsp"></jsp:include>

</body>
</html>
