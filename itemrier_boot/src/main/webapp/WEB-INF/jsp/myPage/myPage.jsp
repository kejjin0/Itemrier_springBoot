<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<style>
	.myPageList{
		width: 240px;
		border: 1px solid gray;
		padding-top: 20px;
		padding-left: 40px;
		padding-bottom: 40px;
		margin-left: 10px;
		border-radius: 30px;
		line-height: 30px;
		float: left;
	}

hr {
	margin-left: 0px;
	width: 100px;
}

ul {
	list-style-type: none;
	padding-left: 10px;
}

</style>
<body>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<div class="myPageList">
	<h2>마이페이지</h2>
	<hr>
	<h3>회원 정보</h3>
	<ul>
		<li><a href="/myPage/change">회원 정보 수정</a></li>
		<li><a href="/myPage/delete">탈퇴</a></li>
	</ul>

	<hr>
	<h3>중고 거래</h3>
	<ul>
		<li><a href="/myPage/usedGoodsTransactionHistory">구매 내역</a></li>
		<li><a href="/myPage/usedGoodsTransaction/inProgress">판매, 예약 중인 상품</a></li>
		<li><a href="/myPage/usedGoodsTransaction/ended">판매 완료 상품</a></li>
	</ul>
	
	<hr>
	<h3>공동 구매</h3>
	<ul>
		<li><a href="/myPage/orders/groupPurchase">구매 내역 (현황)</a></li>
		<li><a href="/myPage/groupPurchase/inProgress">공동 구매 중인 상품</a></li>
		<li><a href="/myPage/groupPurchase/ended">판매 완료 상품</a></li>
	</ul>

	<hr>
	<h3>경매</h3>
	<ul>
		<li><a href="/myPage/orders/auction">구매 내역 (현황)</a></li>
		<li><a href="/myPage/auction/inProgress">경매 중인 상품</a></li>
		<li><a href="/myPage/auction/ended">판매 완료 상품</a></li>
	</ul>

		<hr>
		<h3>찜</h3>
		<ul>
			<li>찜한 상품</li>
		</ul>

	</div>

</body>
</html>
