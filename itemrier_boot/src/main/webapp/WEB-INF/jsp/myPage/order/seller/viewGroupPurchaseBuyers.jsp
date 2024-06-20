<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 구매자</title>
</head>
<style>
.myPageIndex {
	display: flex;
	height: 1000px;
}

.itemList {
	float: rigth;
	margin-top: 10px;
	margin-left: 30px;
	flex-grow: 1;
}

.title {
	background-color: #fff0f5;
	font-size: 25px;
	font-weight: bold;
	height: 100px;
	border-radius: 20px;
	padding-left: 30px;
	text-align: center;
}

.item {
	width: 500px;
	margin: 50px;
	background-color: #f8f8ff;
	padding: 50px;
	border-radius: 10px;
}

.itemTable{
	width: 450px;
}

.orders {
	border: 1px solid gray;
	border-collapse: separate;
	width: 1500px;
	font-size:17px;
	line-height: 30px;
	text-align: center;
}

b{
	font-size:20px;
}

th{
	background-color: #faf8da;
}

.imgFile{
	height: 150px;
	width: 150px;
}
</style>
<body>
	<jsp:include page="../../myPage.jsp" />
	<div class="myPageIndex">

		<div class="itemList">
			<div class="title">
				<br>공동구매 내역<br>
			</div>

			<center>
				<div class="item">
					<table class="itemTable">
						<tr>
							<td rowspan="3"><img src="${item.filePath}" onerror="this.src='https://placehold.co/180'" class="imgFile"/></td>
							<td><b>상품 명 : ${item.itemName}</b></td>
						</tr>
						<tr>
							<td>가격 : ${item.price}원</td>
						</tr>
					</table>
				</div>

				<b>총 ${count}명이 구매하였습니다.</b>
				<br><br>
				<table class="orders">
					<tr>
						<th>주문 번호</th>
						<th>성함</th>
						<th>전화번호</th>
						<th>금액</th>
						<th>수량</th>
						<th>시간</th>
					</tr>
					<c:forEach var="b" items="${buyers}">
						<tr>
							<td>${b.orderId}</td>
							<td>${b.buyerInfo.buyerName}</td>
							<td>${b.buyerInfo.phoneNum}</td>
							<td>${b.price}</td>
							<td>${b.quantity}</td>
							<td>${b.orderDate}</td>
						</tr>
					</c:forEach>
				</table>
			</center>

		</div>
	</div>

</body>
</html>