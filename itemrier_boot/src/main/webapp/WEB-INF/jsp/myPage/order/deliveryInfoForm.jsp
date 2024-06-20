<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 정보 수정</title>
<style>
table {
	border: 1px solid gray;
	width: 70%;
	height: 70%;
}
</style>
</head>
<body>
	<form action="<c:url value='/myPage/order/updateDeliveryInfo' />"
		method="post">
		<table>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="zipCode"
					value="${deliveryInfo.zipCode}"></td>
			</tr>
			<tr>
				<th rowspan="2">주소</th>
				<td><input type="text" name="addStreet"
					value="${deliveryInfo.addStreet}"></td>
			</tr>
			<tr>
				<td><input type="text" name="addDetail"
					value="${deliveryInfo.addDetail}"></td>
			</tr>
			<tr>
				<th>배송 위치</th>
				<td><input type="text" name="deliveryLocation"
					value="${deliveryInfo.deliveryLocation}"></td>
			</tr>
			<tr>
				<th>요청사항</th>
				<td><input type="text" name="deliveryRequest"
					value="${deliveryInfo.deliveryRequest}"></td>
			</tr>
			<input type="hidden" name="orderId" value="${orderId}">
		</table>
		<button type="submit">저장</button>
	</form>


</body>
</html>