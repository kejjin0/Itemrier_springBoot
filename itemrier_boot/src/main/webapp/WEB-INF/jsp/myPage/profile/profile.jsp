<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script defer src="${pageContext.request.contextPath}/postCode.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>

.joinFormContainer {
	margin-top: 10px;
	margin-left: 600px;
  	flex-direction: column;
  	align-items: center;
  	justify-content: center;
}

.formContainer {

  	margin-top: 50px;
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

.zipCode{
	width: 200px;
}

.zipCodeBtn, .signBtn {
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

.name-message, .phoneNum-message, .nickname-message, .zipcode-message {
	color:red;
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
    background-color: rgb(0,0,0);
    background-color: rgba(0,0,0,0.4);
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
.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
.hide{
    display: none;
}
</style>
<body>
<jsp:include page="../myPage.jsp" />
	<div class="joinFormContainer">
		<h2>회원 정보 수정</h2>
		<div class="formContainer">	
			<form action="/myPage/change" name="pageForm" method="post" modelAttribute="userDto">
				<input type="hidden" name="_method" value="patch"/>
				아이디<br />
				<input type="text" name="email" value="${userDto.email }" readonly/>
				<br />
				이름<br />
				<input type="text" name="name" id="name" value="${userDto.name }"/>
				<div class="name-message hide">이름을 입력해주세요.</div>	
				<br /><br />
				핸드폰 번호<br />
				<input type="text" name="phoneNum" id="phoneNum" value="${userDto.phoneNum }" placeholder="- 제외 휴대폰 번호를 입력해주세요."/>
				<div class="phoneNum-message hide">- 제외 휴대폰 번호를 입력해주세요.</div>		
				<br /><br />
				닉네임<br />
				<input type="text" name="nickname" id="nickname" value="${userDto.nickname }"/>
				<div class="nickname-message hide">닉네임을 입력해주세요</div>	
				<br /><br />
				주소<br />
				<input class="zipCode" type="text" name="zipcode" value="${userDto.zipcode }"/>
				<button class="zipCodeBtn"  onclick="toggleModal(event)"> 우편번호검색 </button>
			    <div class="zipcode-message hide">주소를 입력해주세요.</div>	
			    <div id="myModal" class="modal">
			        <div class="modal-content">
			            <span class="close" onclick="toggleModal()">&times;</span>
			            <div id="postcode-container"></div>
			        </div>
			    </div>
				<br />
				<input type="text" name="addStreet" value="${userDto.addStreet }"/>
				<br />
				<input type="text" name="addDetail" value="${userDto.addDetail }"/>
				<br />
			
				<Button class="signBtn" type="submit" onclick="return validCheck(event)">수정하기</Button>
			</form>
		</div>	
	</div>
<script>
        function toggleModal(event) {
            event.preventDefault();
            var modal = document.getElementById("myModal");
            if (modal.style.display === "none" || modal.style.display === "") {
                modal.style.display = "block";
                window.loadPostcodeSearch(
                    function(zonecode) {
                        document.getElementsByName('zipcode')[0].value = zonecode;
                    },
                    function(address) {
                        document.getElementsByName('addStreet')[0].value = address;
                    },
                    function() {
                        modal.style.display = "none";
                    }
                );
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
            document.querySelector(".zipCodeBtn").addEventListener("click", toggleModal);
        });
        
        let elNameMismatchMessage = document.querySelector('.name-message');
        let elPhoneNumMismatchMessage = document.querySelector('.phoneNum-message');
        let elNicknameMismatchMessage = document.querySelector('.nickname-message');
        let elZipcodeMismatchMessage = document.querySelector('.zipcode-message');

        function validCheck(event) {
        	if (pageForm.name.value.length == 0 || pageForm.phoneNum.value.length == 0|| pageForm.nickname.value.length == 0 || pageForm.zipcode.value.length == 0) {
	        	if (pageForm.name.value.length == 0) {
	        		console.log("name실행")
	        		elNameMismatchMessage.classList.remove('hide');
	        	} 
	
				if (pageForm.phoneNum.value.length == 0) {
					console.log("phoneNum실행")
					elPhoneNumMismatchMessage.classList.remove('hide');
	        	}
	
				if (pageForm.nickname.value.length == 0) {
					console.log("nickname실행")
					elNicknameMismatchMessage.classList.remove('hide');
	        	} 
	
				if (pageForm.zipcode.value.length == 0) {
					console.log("zipcode실행")
	        		elZipcodeMismatchMessage.classList.remove('hide');
	        	}

        		return false;
        	}
        }
     
    </script>
</body>
</html>