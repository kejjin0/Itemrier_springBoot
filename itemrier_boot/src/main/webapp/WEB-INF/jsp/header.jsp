<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="header">
        <h1>Itemrior</h1>
        <nav class="item">
            <ul>
                <li><a href="">중고거래</a></li>
                <li><a href="">공동구매</a></li>
            </ul>
        </nav>
        <nav class="log">
            <ul>
                <li><sec:authorize access="isAnonymous()"><a href="/user/login/form">로그인</a></sec:authorize>
               <sec:authorize access="isAuthenticated()"><a href="/logout">로그아웃</a></sec:authorize>
               <sec:authorize access="isAuthenticated()"><a href="/myPage">마이페이지</a></sec:authorize>
				</li>      
                <li><a href="/user/register/form">회원가입</a></li>
            </ul>
        </nav>
    </header>