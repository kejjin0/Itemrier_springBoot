<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
</head>
<style>
.joinFormContainer {
  	width: max;
}

h2 {
	text-align:center;
}

.formContainer {
	display: flex;
  	flex-direction: column;
  	align-items: center;
  	justify-content: center;
  	margin-top: 80px;
}

input {
	width: 330px;
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

.zipCode{
	width: 200px;
}

.zipCodeBtn, .signBtn {}
  width: 120px;
  height: 30px;
  border-radius: 10px;
  background-color: #000;
  color: #FFFFFF;
  border: none;
}

.signBtn{
  	margin-top: 7px;
}
</style>
<body>
	<div class="joinFormContainer">
		<h2>회원가입</h2>
		<div class="formContainer">	
			<form>
				아이디<br />
				<input type="text" name="userId" />
				<br />
				비밀번호<br />
				<input type="text" name="password" />
				<br />
				비밀번호 확인<br />
				<input type="text" name="pwdcheck" />
				<p />
				이름<br />
				<input type="text" name="name" />
				<br />
				핸드폰 번호<br />
				<input type="text" name="phoneNum" />
				<br />		
				닉네임<br />
				<input type="text" name="nickName" />
				<br />
				주소<br />
				<input class="zipCode" type="text" name="zipCode" />
				<Button class="zipCodeBtn" type="button"> 우편번호검색 </Button>
				<br />
				<input type="text" name="streetAdd" />
				<br />
				<input type="text" name="streetDetail" />
				<br />
			
				<Button class="signBtn" type="button">가입하기</Button>
			</form>
		</div>	
	</div>
</body>
</html>