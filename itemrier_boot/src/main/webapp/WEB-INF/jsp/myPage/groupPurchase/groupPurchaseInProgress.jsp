<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 판매 중</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>
.myPageUsedGoods {
	display: flex;
	height: 1000px;
}

.itemList {
	float: rigth;
	margin-top: 10px;
	margin-left: 30px;
	flex-grow: 1;
}

.container {
	margin-top: 50px;
}

.title {
	background-color: #fff0f5;
	font-size: 25px;
	font-weight: bold;
	height: 10%;
	border-radius: 20px;
	padding-left: 30px;
}

button {
	background-color: #e6e6fa;
	width: 100px;
	height: 30px;
	text-align: center;
	border-radius: 20px;
}

	.imgFile{
		height: 130px;
		width:130px;
	}
</style>
<body>
	<jsp:include page="../myPage.jsp" />
	<div class="myPageUsedGoods">
		<div class="itemList">
			<div class="title">
				<br>공동 구매 판매 중<br>
			</div>
			<div class=container>
				<div class="row" align="center">
					<c:forEach var="groupPurchase" items="${groupPurchaseList}">
						<div class="col-md-4">
							<img src="${groupPurchase.filePath}" alt="상품 이미지" onerror="this.src='https://placehold.co/150'" class="imgFile"/>
							<h3>상품 이름: ${groupPurchase.itemName}</h3>
							<p>가격: ${groupPurchase.price}원</p>
							<p>
								날짜:
								<fmt:parseDate value="${groupPurchase.startTime}"
									pattern="yyyy-MM-dd'T'HH:mm:ss" var="parseDateTime" type="both" />
								<fmt:formatDate value="${parseDateTime}" pattern="yyyy-MM-dd" />
							</p>
							<a
								href="<c:url value='/myPage/seller/groupPurchase/orders'>
										<c:param name='itemId' value='${groupPurchase.itemId}'/>
										</c:url>"><button
									type="button">구매자 관리</button></a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>