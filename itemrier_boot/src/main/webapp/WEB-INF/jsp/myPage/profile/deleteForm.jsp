<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.formContainer {
	width:500px;
	height: 1000px;
	margin-top: 200px;
	margin-left: 600px;
  	flex-direction: column;
  	align-items: center;
  	justify-content: center;
}
input {
	width: 500px;
	height: 40px;
	background-color: #F2F2F2;  
	font-size: 18px;
	font-color: black;
  	border: 0;
  	border-radius: 10px;
 	outline: none;
 	margin-top: 7px;
 	margin-bottom: 7px;
 	padding-left:10px;
}
.signBtn {
  width: 120px;
  height: 30px;
  border-radius: 10px;
  background-color: #000;
  color: #FFFFFF;
  border: none;
}
.errorMessage {
	color:red;
}
</style>
<body>
<jsp:include page="../myPage.jsp" />
<div class="formContainer">	
	<h2>비밀번호 입력시 탈퇴됩니다.</h2>

	<form action="/myPage/delete" method="post">
		<input type="password" id="password" name="password" />
		<div class="errorMessage">${wrongPassword }</div>
		<br />	
		
		<Button class="signBtn" type="submit">탈퇴</Button>
	</form>
</div>
</body>
</html>