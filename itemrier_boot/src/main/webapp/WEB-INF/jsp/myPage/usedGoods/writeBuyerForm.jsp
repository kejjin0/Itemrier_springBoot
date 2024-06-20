<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자를 입력하세요</title>

<style>
table {
	border: 1px solid gray;
	width: 70%;
	height: 70%;
}
</style>
</head>
<body>
	<form action="<c:url value='/myPage/usedGoodTransaction/insertBuyer' />"
		method="post" onsubmit="return refreshInfo()">
		<table>
			<tr>
				<th>구매자 id</th>
				<td><input type="text" name="buyerId"></td>
			</tr>
			<tr>
				<!-- <input type="hidden" name="sellerId" value="${sellerId}"> -->
				<input type="hidden" name="itemId" value="${itemId}">
			</tr>
		</table>
		<button type="submit">저장</button>
	</form>
</body>
</html>