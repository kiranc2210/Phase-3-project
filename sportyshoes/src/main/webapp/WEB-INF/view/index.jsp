<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes</title>
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
	background-color: #990012;
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/components/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/components/topbar.jsp"></jsp:include>
	<table id="customers">
		<tr>
			<th><b>Product</b></th>
			<th><b>Price</b></th>
			<th><b>Category</b></th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>${mapCats.get(item.ID)}</td>
				<td><a href="cartadditem?id=${item.ID}">Add To Cart</a></td>
			</tr>
		</c:forEach>
	</table>

	<jsp:include page="/WEB-INF/view/components/footer.jsp"></jsp:include>

</body>
</html>
