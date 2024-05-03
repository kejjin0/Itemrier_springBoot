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
  	margin-top: 80px;
}

input {
	width: 300px;
	height: 30px;
	background-color: #F2F2F2;  
	font-size: 15px;
	font-color: black;
  	border: 0;
  	border-radius: 10px;
 	outline: none;
 	margin-top: 7px;
 	margin-bottom: 7px;
 	padding-left:10px;
}

.loginBtn, .kakaoBtn {
  width: 300px;
  height: 30px;
  border-radius: 10px;
  background-color: #000;
  color: #FFFFFF;
  border: none;
   	margin-top: 7px;
 	margin-bottom: 7px;
}

.kakaoBtn {
	background-color:white;
	color: black;
	border: solid 0.3px;
}
</style>
<body>
	<div class="modalContainer">
		<div class="loginContainer">
			<h3>잇템리어</h3>
			<form>
				<input type="text" name="userId" placeholder="아이디를 입력하세요"/>
				<br/>
				<input type="text" name="pwd" placeholder="비밀번호를 입력하세요" />
				<br/>
				<button class="loginBtn" type="button">로그인</button>
				<br/>
				<button class="kakaoBtn" type="button">카카오 로그인</button>
			</form>
			<div>
				아이디 찾기 | 비밀번호 찾기 | 회원가입
			</div>
		</div>
	</div>
</body>
</html>