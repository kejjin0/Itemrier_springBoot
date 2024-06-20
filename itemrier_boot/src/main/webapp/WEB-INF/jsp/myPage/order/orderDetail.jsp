<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
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

.info {
	display: flex;
	justify-content: center;
}

.write {
	height: 100%;
	margin: 50px;
	padding: 50px;
}

.orderForm {
	font-size: 20px;
	width: 700px;
	height: 500px;
}

textarea {
	height: 100px;
	width: 500px;
	border: 1px solid gray;
	resize: none;
}

.longInfo {
	height: 150px;
	width: 400px;
}

.smallText {
	width: 250px;
	height: 30px;
}

.item {
	widtd: 600px;
	margin: 50px;
	background-color: #f8f8ff;
	padding: 50px;
	border-radius: 10px;
}

.itemTable {
	border: 1px solid gray;
	margin: 10px;
	border-radius: 30px;
	height: 200px;
	width: 350px;
}

img {
	margin: 20px;
}

button {
	width: 200px;
	height: 60px;
	border-radius: 10px;
	background-color: #add8e6;
	font-size: 18px;
}

td {
	width: 250px;
}

.myPageIndex {
	display: flex;
}

.reviewWriteBtn {
	width: 100px;
	height: 30px;
	border-radius: 5px;
	background-color: #add8e6;
	font-size: 13px;
}

.imgFile{
	height: 150px;
	width: 150px;
}
</style>
<script>
	function openBuyerInfoEditForm(orderId, buyerName, phoneNum) {
		var url = "/myPage/order/updateBuyerInfoForm";
		url += '?orderId=' + encodeURIComponent(orderId);
		url += '&buyerName=' + encodeURIComponent(buyerName);
		url += '&phoneNum=' + encodeURIComponent(phoneNum);
		window.open(url, "사용자 정보 수정", "width=600, height=500");
	}

	function openDeliveryInfoEditForm(orderId, zipCode, addStreet, addDetail,
			deliveryLocation, deliveryRequest) {
		var url = "/myPage/order/updateDeliveryInfoForm";
		url += '?orderId=' + encodeURIComponent(orderId);
		url += '&zipCode=' + encodeURIComponent(zipCode);
		url += '&addStreet=' + encodeURIComponent(addStreet);
		url += '&addDetail=' + encodeURIComponent(addDetail);
		url += '&deliveryLocation=' + encodeURIComponent(deliveryLocation);
		url += '&deliveryRequest=' + encodeURIComponent(deliveryRequest);

		window.open(url, "배송지 정보 수정", "width=600, height=500");
	}

	function openWriteReview(itemId, userId) {
		var url = "/write/reviewForm";
		url += '?itemId=' + encodeURIComponent(itemId);
		url += '&userId=' + encodeURIComponent(userId);

		window.open(url, "리뷰 작성", "width=600, height=500")
	}

	function openSellerReview(sellerId) {
		var url = "/view/userReview";
		url += '?userId=' + encodeURIComponent(sellerId);

		window.open(url, "판매자 리뷰", "width=600, height=500")
	}

	function openItemReview(itemId) {
		var url = "/view/itemReview";
		url += '?itemId=' + encodeURIComponent(itemId);

		window.open(url, "상품 리뷰", "width=600, height=500")
	}

	function refreshWindow() {
		window.location.reload();
	}
</script>

<body>
	<jsp:include page="../myPage.jsp" />
	<div class="myPageIndex">

		<div class="itemList">
			<div class="title">
				<br>주문 내역<br>
			</div>
			<div class="info">
				<div class="write">
					<button
						onclick="openBuyerInfoEditForm('${order.orderId}', '${order.buyerInfo.buyerName}', '${order.buyerInfo.phoneNum }')">주문자,
						전화번호 변경</button>
					<button
						onclick="openDeliveryInfoEditForm('${order.orderId}', '${order.deliveryInfo.zipCode}',  '${order.deliveryInfo.addStreet}', '${order.deliveryInfo.addDetail}',
			'${order.deliveryInfo.deliveryLocation}', '${order.deliveryInfo.deliveryRequest}')">배송지
						변경</button>
					<button>주문 취소</button>
					<br>
					<p />
					<table class="orderForm">
						<tr>
							<td>주문 번호</td>
							<td>${order.orderId}</td>
						</tr>
						<tr>
							<td>주문자</td>
							<td>${order.buyerInfo.buyerName}</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${order.buyerInfo.phoneNum}</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${order.email}</td>
						</tr>
						<tr>
							<td>우편번호</td>
							<td>${order.deliveryInfo.zipCode}</td>
						</tr>
						<tr>
							<td rowspan="2">주소<br></td>
							<td>${order.deliveryInfo.addStreet}</td>
						</tr>
						<tr>
							<td>${order.deliveryInfo.addDetail}</td>
						</tr>
						<tr>
							<td>배송 위치</td>
							<td>${order.deliveryInfo.deliveryLocation}</td>
						</tr>
						<tr class="longInfo">
							<td>배송 요청 사항</td>
							<td>${order.deliveryInfo.deliveryRequest}</td>
						</tr>
					</table>

				</div>
				<div class="item">
					<c:forEach var="i" items="${order.orderItems}">
						<table class="itemTable">
							<tr>
								<td rowspan="3"><img src="${i.itemInfo.filePath}" onerror="this.srsc='https://placehold.co/180'" class="imgFile"/></td>
								<td><br> <b>${i.itemInfo.itemName}</b> <br> <br>
									${i.orderPrice}₩ <br> <br> ${i.amount}개 <br> <br> ${i.status}</td>
							<tr>
								<td><button class="reviewWriteBtn"
										onclick="openWriteReview('${i.itemInfo.itemId}', '${i.itemInfo.seller.userId}')">리뷰
										작성하기</button></td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
</body>
</html>