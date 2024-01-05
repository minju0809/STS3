<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ page import="java.util.*"%> --%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 게시판</title>
<link type="text/css" rel="stylesheet" href="${ path }/css/style.css" />
</head>

<body>
	<header>
 		게시판 ver 1.0
	</header>
	<nav>
		&emsp;<a href="index.do">홈으로</a>
		&emsp;<a href="guestbookList.do">방명록</a>
		&emsp;<a href="guestbookList2.do">방명록2</a>
		&emsp;<a href="guestbookInsert.do">방명록추가</a>
		<c:if test="${ not empty login.getName() }">
			&emsp;<a href="write.do">글 등록</a>
			&emsp;<a href="getBoardList.do">게시판</a>
			&emsp;<a href="examList.do">성적처리목록</a>
			&emsp;<a href="psdList.do">자료목록</a>
			&emsp;<a href="psdWrite.do">자료등록</a>
			&emsp;<a href="productList.do">상품목록</a>
			&emsp;<a href="productList2.do">상품목록2</a>
		</c:if>
		<c:if test="${ '관리자' eq login.getName() }">
			&emsp;<a href="examWrite.do">성적 등록</a>
			&emsp;<a href="productWrite.do">상품등록</a>
			&emsp;<a href="memberList.do">회원목록</a>
			&emsp;<a href="memberWrite.do">회원등록</a>
			&emsp;<a href="orderMemberList.do">주문회원목록</a>
		</c:if>
		<c:if test="${ empty login.getName() }">
			&emsp;<a href="memberLogin.do">로그인</a>
		</c:if>
		<c:if test="${ not empty login.getName() }">
			&emsp;<a href="memberLogout.do">${ login.getName() }(로그아웃)</a>
			&emsp;<a href="shopBuyList.do?memberId=${login.getMemberId()}">장바구니</a>
		</c:if>
	</nav>
