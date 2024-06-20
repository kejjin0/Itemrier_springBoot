<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script defer src="${pageContext.request.contextPath}/postCode.js"></script>
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

.errorMessage, .mismatch-message {
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
.id_ok{
color:#008000;
display: none;
}

.id_already{
color:red; 
display: none;
}
</style>
<body>
<%@ include file="../header.jsp" %>
	<div class="joinFormContainer">
		<h2>회원가입</h2>
		<div class="formContainer">	
			<form action="/user/register" method="post" modelAttribute="userDto">
				아이디<br />
				<input type="text" id="email" name="email"  oninput = "checkId()" />
				<div class="errorMessage">${valid_email}</div>
				<!-- id ajax 중복체크 -->
				<p class="id_ok">사용 가능한 아이디입니다.</p>
				<p class="id_already">누군가 이 아이디를 사용하고 있어요.</p>
				<br />
				비밀번호<br />
				<input type="password" id="password" name="password" />
				<div class="errorMessage">${valid_password}</div>
				<br />
				
				비밀번호 확인<br />
				<input type="password" id="pwdcheck" name="pwdcheck" />
				 <div class="mismatch-message hide">비밀번호가 일치하지 않습니다</div>
				<p />
				이름<br />
				<input type="text" name="name" />
				<div class="errorMessage">${valid_name}</div>	
				<br /><br />
				핸드폰 번호<br />
				<input type="text" name="phoneNum" placeholder="- 제외 휴대폰 번호를 입력해주세요."/>
				<div class="errorMessage">${valid_phoneNum}</div>	
				닉네임<br />
				<input type="text" name="nickname" />
				<div class="errorMessage">${valid_nickname}</div>	
				<br /><br />
				주소<br />
				<input class="zipCode" type="text" name="zipcode" readonly/>
				<button class="zipCodeBtn"  onclick="toggleModal(event)"> 우편번호검색 </button>
				<div class="errorMessage">${valid_addStreet}</div>	
			    <div id="myModal" class="modal">
			        <div class="modal-content">
			            <span class="close" onclick="toggleModal()">&times;</span>
			            <div id="postcode-container"></div>
			        </div>
			    </div>
				<br />
				<input type="text" name="addStreet" readonly/>
				<br />
				<input type="text" name="addDetail" />
				<br />
			
				<Button class="signBtn" type="submit">가입하기</Button>
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

        let elInputPassword = document.getElementById('password');
        let elInputPasswordRetype = document.getElementById('pwdcheck'); 
        let elMismatchMessage = document.querySelector('.mismatch-message');
        
        elInputPasswordRetype.onkeyup = function () {
            if (elInputPasswordRetype.value.length !== 0) {
                if (elInputPassword.value === elInputPasswordRetype.value) {
                    elMismatchMessage.classList.add('hide');
                } else {
                    elMismatchMessage.classList.remove('hide');
                }
            } else {
                elMismatchMessage.classList.add('hide');
            }
        };
        
        function checkId(){
            var email = $('#email').val(); //id값이 "id"인 입력란의 값을 저장
            $.ajax({
                url:'/emailCheck', //Controller에서 요청 받을 주소
                type:'post', //POST 방식으로 전달
                data:{email:email},
                success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
                    if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                        $('.id_ok').css("display","inline-block"); 
                        $('.id_already').css("display", "none");
                    } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display","inline-block");
                        $('.id_ok').css("display", "none");
                        alert("아이디를 다시 입력해주세요");
                        $('#email').val('');
                    }
                },
                error:function(){
                    alert("에러입니다");
                }
            });
            };
    </script>
</body>
</html>