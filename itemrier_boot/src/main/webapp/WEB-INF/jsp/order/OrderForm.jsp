<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 우편번호 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script defer src="${pageContext.request.contextPath}/postCode.js"></script>
<script>
	var IMP = window.IMP;
	IMP.init("imp21655237");

	function requestPay() {
		IMP.request_pay({
			pg : "html5_inicis",
			pay_method : "card",
			merchant_uid : $('#orderId').val(), // 주문번호
			name : $('#itemName').val(),
			amount : $('#price').val(), // 숫자 타입
			buyer_email : $('#email').val(),
			buyer_name : $('#buyerName').val(),
			buyer_tel : $('#phoneNum').val(),
			buyer_addr : $('#addStreet').val(),
			buyer_postcode : $('#zipCode').val()
		}, function(rsp) {
			if (rsp.success) {
				//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
				alert("결제 완료");
				var result = {
					orderId : rsp.merchant_uid,
					buyerId : $('#buyerId').val(),
					buyerInfo : {
						buyerName : $('#buyerName').val(),
						phoneNum : rsp.buyer_tel
					},
					deliveryInfo : {
						zipCode : rsp.buyer_postcode,
						addStreet : $('#addStreet').val(),
						addDetail : $('#addDetail').val(),
						deliveryLocation : $('#deliveryLocation').val(),
						deliveryRequest : $('#deliveryRequest').val()
					},
					email : rsp.buyer_email,
					price : rsp.paid_amount,
					quantity : 1,
					pg : "html5_inicis",
					pay_method : "card",
					orderDate : new Date().toISOString(),
					itemId : $('#itemId').val(),
					type : $('#type').val()
				}

				$.ajax({
					url : 'insertOrder', //cross-domain error가 발생하지 않도록 주의해주세요
					type : 'POST',
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(result),
					success : function(res) {
						console.log(res);
						window.location.href = res;
					},
					error : function(err) {
						alert("Error: " + JSON.stringify(err));
						console.log(err);
					}
				});
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
		});
	}
	
	
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
	
</script>
<meta charset="UTF-8">
<title>결제</title>
</head>
<style>
.title {
	background-color: #fff0f5;
	font-size: 25px;
	font-weight: bold;
	height: 100px;
	border-radius: 20px;
	padding-left: 30px;
	text-align: center;
}

.info {
	display: flex;
	justify-content: center;
}

.write {
	height: 500px;
	margin: 50px;
	padding: 50px;
}

.orderForm {
	font-size: 20px;
	width: 700px;
	height: 700px;
}

textarea {
	height: 100px;
	width: 500px;
	border: 1px solid gray;
	resize: none;
}

.longInfo {
	height: 150px;
	width: 400px;
}

.smallText {
	width: 250px;
	height: 30px;
}

.item {
	widtd: 600px;
	margin: 50px;
	background-color: #f8f8ff;
	padding: 50px;
	border-radius: 10px;
}

.itemTable {
	border: 1px solid gray;
	margin: 10px;
	border-radius: 30px;
	height: 250px;
	width: 450px;
}

img {
	margin: 20px;
}

button {
	width: 150px;
	height: 60px;
	border-radius: 10px;
	background-color: #add8e6;
	font-size: 18px;
	margin-top: 10px;
}

td {
	width: 250px;
}

.imgFile {
	height: 200px;
	width: 200px;
}

b {
	font-size: 20px;
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

.zipCodeBtn {
  width: 130px;
  height: 30px;
  background-color: gray;
  color: white;
}
</style>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="title">
		<br>주문<br>
	</div>
	<div class="info">
		<div class="write">
			<table class="orderForm">
				<tr>
					<td>주문자</td>
					<td>&nbsp;<input type="text" class="smallText" id="buyerName"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>&nbsp;<input type="text" class="smallText" id="zipCode" name="zipcode" readonly/>
					<button class="zipCodeBtn"  onclick="toggleModal(event)"> 우편번호검색 </button>
								    <div id="myModal" class="modal">
			        <div class="modal-content">
			            <span class="close" onclick="toggleModal()">&times;</span>
			            <div id="postcode-container"></div>
			        </div>
			    </div></td>
				</tr>
				<tr>
					<td rowspan="2">주소<br></td>
					<td>&nbsp;<input type="text" class="smallText"
						placeholder="건물명" id="addStreet" name="addStreet" readonly/></td>
				</tr>
				<tr>
					<td>&nbsp;<input type="text" class="smallText"
						placeholder="상세 주소" id="addDetail" name="addDetail"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>&nbsp;<input type="text" class="smallText" id="phoneNum"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>&nbsp;<input type="text" class="smallText" id="email"></td>
				</tr>
				<tr>
					<td>배송 위치</td>
					<td>&nbsp;<input type="text" class="smallText"
						id="deliveryLocation"></td>
				</tr>
				<tr class="longInfo">
					<td>배송 요청 사항</td>
					<td><textarea id="longinput" id="deliveryRequest"></textarea></td>
				</tr>
				<tr>
				</tr>
			</table>
			<input type="hidden" id="buyerId" value="${buyerId}"> <input
				type="hidden" id="itemName" value="${itemName}"> <input
				type="hidden" id="price" value="${price}"> <input
				type="hidden" id="itemId" value="${itemId}"> <input
				type="hidden" id="orderId" value="${orderId}"> <input
				type="hidden" id="type" value="${type}">
		</div>
		<div class="item">
			<table class="itemTable">
				<tr>
					<td rowspan="3"><img src="${filePath}" onerror="this.src='https://placehold.co/150'" class="imgFile" /></td>
					<td><b>${itemName}</b></td>
				</tr>
				<tr>
					<td><b>${price}원</b></td>
				</tr>
			</table>
			<button onclick="requestPay()">결제하기</button>
		</div>
	</div>
</body>
</html>