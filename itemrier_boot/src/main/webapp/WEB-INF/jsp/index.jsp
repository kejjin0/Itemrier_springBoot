<!-- 로그인 전 홈페이지 -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Itemrior</title>
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">

</head>

<body>
<%@ include file="header.jsp" %>
	<div>
    <hr>
    <main>
        <div class="container">
            <div class="used">
                <img src="https://cdn.pixabay.com/photo/2017/03/13/17/26/ecommerce-2140603_1280.jpg" alt="중고거래">
                <p>더 이상 쓰지 않는 물건들을</p>
                <p> <b>잇템리어</b>에서 중고거래 해보세요.</p>
            </div>
            <div class="group">
                <img src="https://cdn.pixabay.com/photo/2017/11/06/08/42/turn-on-2923047_1280.jpg" alt="공동구매">
                <p>사고 싶은 물건들을 <b>잇템리어</b>에서 </p>
                <p>많은 사람들과 더 싸게 구입해보세요.</p>
            </div>
        </div>
    </main>
    </div>
    <footer>
        <p>&copy; Itemrior 잇템리어 </p>
        <p>소프트웨어 시스템 개발 핫식스(6조)</p>
        <p>20200973 배수현 20201020 지민선</p>
		<p>20210769 김은수 20210770 김은진</p>
    </footer>
    
</body>
</html>