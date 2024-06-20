<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>중고거래 등록</title>
<style>
	table {
	    width: 650px; 
	    height: 600px;
	    border-collapse: collapse;
	    margin-left: auto;
	    margin-right: auto;
	}
	th {
	    border: 1px solid black;
	    padding: 8px; 
	    text-align: center; 
	}
	td {
	    border: 1px solid black;
	    padding: 8px; 
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	h1 {
		text-align: center;
	}
	h2 {
		text-align: center;
	}
	.btn {
		text-align: center;
	}
</style>
</head>
<body>
	<h1><a href="/" style="color: #FFB0D9;">Itemrior</a></h1>
	<h2>중고거래 상품 등록</h2>
	<form action="/usedGoods/create" method="POST" enctype="multipart/form-data">
		<table>
                <tr>
                    <td>제목(상품명)</td>
                    <td><input type="text" name="itemName" placeholder="등록할 제목을 입력하세요" style="width: 400px; height: 30px;"></td>
                </tr>
                <tr>
                    <td>상품 정보</td>
                    <td><input type="text" name="description" placeholder="상품 정보를 입력해주세요" style="width: 400px; height: 80px;"></td>
                </tr>
                <tr>
                    <td>제품 상태</td>
                    <td>
                        <select name="condition">
                            <option value="0">미사용(새상품)</option>
                            <option value="1">미세한 사용감</option>
                            <option value="2">사용감 적음</option>
                            <option value="3">사용감 있음</option>
                            <option value="4">사용감 많음</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>등록 가격</td>
                    <td>
                        <input type="number" name="price" placeholder="등록 가격을 입력하세요" min="0" style="width: 160px;">
                        <span>원</span>
                    </td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select name="catId">
                            <option value="1">소파</option>
                            <option value="2">침대</option>
                            <option value="3">테이블</option>
                            <option value="4">의자</option>
                            <option value="5">기타가구</option>
                            <option value="6">조명</option>
                            <option value="7">러그/카펫</option>
                            <option value="8">홈데코</option>
                            <option value="9">수납</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>연락 수단</td>
                    <td><input type="text" name="contactType" placeholder="카카오톡 아이디, 전화번호 등 연락할 수단을 입력해주세요" style="width: 400px; height: 30px;"></td>
                </tr>
                <tr>
                    <td>상품 사진</td>
                    <td><input type="file" id="file" name="file"></td>
                </tr>
                <tr>
                    <td colspan="2" class="btn"><input type="submit" value="등록하기"></td>
                </tr>
            </table>
        </form>
</body>
</html>