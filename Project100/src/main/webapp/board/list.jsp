<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align=center>
		<h1>목록보기</h1>
		<h3>${ userName }님 환영합니다!..
		</h3>
		<hr>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${ li }" var="m">
				<tr>
					<td>${ m.getSeq() }</td>
					<td>${ m.getTitle() }</td>
					<td>${ m.getWriter() }</td>
					<td>${ m.getRegdate() }</td>
					<td>${ m.getCnt() }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="index.do">시작으로</a>
		<a href="write.do">새글등록</a>
		<hr>
	</div>
</body>
</html>