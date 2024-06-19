<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"></head>
<header id="header">
        <h1 ><a href="/" style="color: #FFB0D9;">Itemrior</a></h1>
       <nav class="itemTop">
            <ul class="item">
                <li><a href="/usedGoods">중고거래</a></li>
                <li><a href="">공동구매</a></li>
                <li><a href="/auction/list">경매</a></li>
            </ul>
        </nav>
        <nav class="logTop">
            <ul class="log">
                <li><sec:authorize access="isAnonymous()"><a href="/user/login/form">로그인</a></sec:authorize>
               <sec:authorize access="isAuthenticated()"><a href="/logout">로그아웃</a></sec:authorize>
				</li>      
                <li><sec:authorize access="isAnonymous()"><a href="/user/register/form">회원가입</a></sec:authorize>
 					<sec:authorize access="isAuthenticated()"><a href="/myPage">마이페이지</a></sec:authorize>
                </li>
            </ul>
        </nav>
  
    </header>