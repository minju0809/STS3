<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2023 학생 성적 관리 프로그램</title>
<link type="text/css" rel="stylesheet" href="${ path }/css/style.css" />
</head>

<body>
	<header>
 		게시판 ver 1.0
	</header>
	<nav>
		&emsp;<a href="index.do">홈으로</a>
		&emsp;<a href="electricList.do">강원충전소</a>
		&emsp;<a href="electricMap1.do">강원충전소Map1</a>
		&emsp;<a href="electricMap2.do">강원충전소Map2</a>
		&emsp;<a href="examList.do">성적목록보기</a>
		&emsp;<a href="examInsert.do">성적추가</a>
		&emsp;<a href="guestbookList.do">방명록</a>
	</nav>
