<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인</title>
</head>
<style>
.modalContainer {
  	width: max;
}

h3 {
	text-align:center;
}

.loginContainer {
	display: flex;
  	flex-direction: column;
  	align-items: center;
  	justify-content: center;
  	margin-top: 100px;
}

input {
	width: 500px;
	height: 50px;
	background-color: #F2F2F2;  
	font-size: 15px;
	font-color: black;
  	border: 0;
  	border-radius: 10px;
 	outline: none;
 	margin-top: 7px;
 	margin-bottom: 15px;
 	padding-left:10px;
}

.loginBtn{
	width: 400px;
	height: 50px;
  border-radius: 10px;
  background-color: #000;
  color: #FFFFFF;
  border: none;
	margin-top: 15px;
	margin-bottom: 7px;
  	justify-content: center;
}

</style>
<body>
<%@ include file="../header.jsp" %>
	<div class="modalContainer">
		<div class="loginContainer">
			<h1>잇템리어</h1>
			<form action="/user/login" method="post">
				<input type="text" name="email" placeholder="아이디를 입력하세요"/>
				<br/>
				<input type="password" name="password" placeholder="비밀번호를 입력하세요" />
				<br/>
				<button class="loginBtn" type="submit">로그인</button>
			</form>
	
		</div>
	</div>
</body>
</html>