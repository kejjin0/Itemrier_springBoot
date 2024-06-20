<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>

<style>
table {
	border: 1px solid gray;
	width: 70%;
	height: 70%;
}
</style>

</head>
<body>
	<form action="<c:url value='/myPage/order/updateBuyerInfo' />" method="post" onsubmit="return refreshInfo()">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="buyerName"
					value="${buyerInfo.buyerName}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phoneNum"
					value="${buyerInfo.phoneNum}"></td>
			</tr>
			<input type="hidden" name="orderId" value="${orderId}">
		</table>
		<button type="submit">저장</button>
	</form>

</body>
</html>