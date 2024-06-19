<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매, 예약 중인 중고 물품</title>
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
	
	.status{
		background-color: #e6e6fa;
		width : 65px;
		height: 30px;
		text-align: center;
		border-radius: 20px;
	}
	
	img{
		margin: 20px;
	}
</style>
<body>
<jsp:include page="../myPage.jsp" />
	<div class="myPageUsedGoods">
	
		<div class="itemList">
			<div class="title">
				<br>판매, 예약 중인 중고 물품<br>
			</div>
			 
				<div class="item">
					<table>
					    <c:forEach var="userGoods" items="${userGoodsList}">
					        <tr>
					            <td rowspan="5"><img src="https://placehold.co/180" alt="상품 이미지"/></td>
					            <td></td>
					        </tr>
					        <tr>
					            <td>상품 이름: ${userGoods.itemName}</td>
					        </tr>
					        <tr>
					            <td>가격: ${userGoods.price}원</td>
					        </tr>
					        <tr>
					            <td>올린 날짜: ${userGoods.registerDate}</td>
					        </tr>
					        <tr>
					            <td><div class="status">상태: ${userGoods.status}</div></td>
					        </tr>
					    </c:forEach>
					</table>

				</div>
			
		</div>
	</div>
</body>
</html>