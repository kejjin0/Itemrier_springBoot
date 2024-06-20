<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매한 중고 물품</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>
	.myPageUsedGoods{
		display: flex;
		height: 1000px;
	}
	
	.itemList{
		float: rigth;
		margin-top: 10px;
		margin-left: 30px;
		flex-grow:1;
	}
	
		
	.container {
		margin-top:50px;
	}
	
	.title{
		background-color: #fff0f5;
		font-size: 25px;
		font-weight: bold;
		height: 10%;
		border-radius: 20px;
		padding-left: 30px; 
	}
	
	.item{
		margin-left: 10px;
		margin-top: 40px;
	}
	
	table{
		border: 1px solid gray;
		margin: 10px;
		border-radius: 30px;
		height: 250px;
		width: 450px;
	}
	
	td{
		width : 50%;
	}
	
	img{
		margin: 20px;
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
				<br>중고거래 내역<br>
			</div>
			<div class=container>
				<div class="row" align="center">
					<c:forEach var="userGoods" items="${usedGoods}">
					<div class="col-md-4">
						<img src="${userGoods.filePath }" alt="상품 이미지" onerror="this.src='https://placehold.co/150'" class="imgFile"/>
						<h3>상품 이름: ${userGoods.itemName}</h3>
						<p>가격: ${userGoods.price}원</p>
						<p>올린 날짜:
						<fmt:parseDate value="${userGoods.registerDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parseDateTime" type="both" />
							<fmt:formatDate value="${parseDateTime}" pattern="yyyy-MM-dd"/>
						</p>
						<div class="status">${userGoods.status}</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>