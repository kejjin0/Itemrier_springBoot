<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- 우편번호 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script defer src="${pageContext.request.contextPath}/postCode.js"></script>
<meta charset="UTF-8">
<title>배송 정보 수정</title>
<style>
table {
	border: 1px solid gray;
	width: 70%;
	height: 70%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 1000px;
	height: 500px;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
	padding-top: 60px;
}

.modal-content {
	background-color: #fefefe;
	margin: 5% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 1000px;
	height: 500px;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.zipCodeBtn {
	width: 130px;
	height: 30px;
	background-color: gray;
	color: white;
}
</style>
<script>
	function toggleModal(event) {
		event.preventDefault();
		var modal = document.getElementById("myModal");
		if (modal.style.display === "none" || modal.style.display === "") {
			modal.style.display = "block";
			window.loadPostcodeSearch(function(zonecode) {
				document.getElementsByName('zipCode')[0].value = zonecode;
			}, function(address) {
				document.getElementsByName('addStreet')[0].value = address;
			}, function() {
				modal.style.display = "none";
			});
		} else {
			modal.style.display = "none";
		}
	}

	function setZonecode(zonecode) {
		console.log("Zonecode:", zonecode);
	}

	function setAdd(address) {
		console.log("Address:", address);
	}

	function closeModal() {
		var modal = document.getElementById("myModal");
		modal.style.display = "none";
	}

	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector(".zipCodeBtn").addEventListener("click",
				toggleModal);
	});
</script>
</head>
<body>
	<form action="<c:url value='/myPage/order/updateDeliveryInfo' />"
		method="post">
		<table>
			<tr>
				<th>우편번호</th>
				<td>&nbsp;<input type="text" class="smallText" id="zipCode"
					name="zipCode" value="${deliveryInfo.zipCode}" readonly />
					<button class="zipCodeBtn" onclick="toggleModal(event)">
						우편번호검색</button>
					<div id="myModal" class="modal">
						<div class="modal-content">
							<span class="close" onclick="toggleModal()">&times;</span>
							<div id="postcode-container"></div>
						</div>
					</div></td>
			</tr>
			<tr>
				<th rowspan="2">주소</th>
				<td><input type="text" class="smallText" placeholder="건물명"
					id="addStreet" value="${deliveryInfo.addStreet}"
					name="addStreet" readonly /></td>
			</tr>
			<tr>
				<td><input type="text" class="smallText" name="addDetail" id="addDetail"
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