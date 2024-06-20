<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매한 경매 물품</title>
</head>
<style>
.myPageUsedGoods {
	display: flex;
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
	height: 10%;
	border-radius: 20px;
	padding-left: 30px;
}

.thCss {
	background-color: #f0f8ff;
}

table {
	border: 1px solid gray;
	margin: 20px;
	width: 800px;
	text-align: center;
}

tr {
	height: 40px;
}
</style>
<body>
	<div class="myPageUsedGoods">
		<jsp:include page="../myPage.jsp" />
		<div class="itemList">
			<div class="title">
				<br>경매 내역<br>
			</div>

			<center>
				<table>
					<tr class="thCss">
						<th>주문 번호</th>
						<th>주문 날짜</th>
						<th>금액</th>
						<th>주문 상태</th>
					</tr>
					<c:forEach var="o" items="${orders}">
						<tr>
							<td>
								<a href="<c:url value='/myPage/orders/orderInfo'>
										<c:param name='orderId' value='${o.orderId}'/>
										</c:url>">
									${o.orderId}
								</a>
							</td>
							<td>${o.orderDate}</td>
							<td>${o.price}</td>
							<td>${o.status}</td>
						</tr>
					</c:forEach>
				</table>
			</center>

		</div>
	</div>
</body>
</html>