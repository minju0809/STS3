<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@ page import="com.springbook.biz.board.*"%>
<%@ page import="com.springbook.biz.board.impl.*"%>
<%@ page import="java.util.*"%>
<%
// BoardService service = new BoardServiceImpl();
// List<BoardVO> li = service.getBoardList();

// List<BoardVO> li = (List<BoardVO>) session.getAttribute("li");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록보기</h1>
	<a href="logout.do">Log-out</a>
	<hr>
	<table border=1>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<%--  		<%  --%>
		<!--  		for (BoardVO m : li) { -->
		<%--  		%>  --%>
		<c:forEach items="${ li }" var="m">

			<tr>
				<td>${ m.getSeq() }</td>
				<td><a href="getBoard.do?seq=${ m.getSeq() }">${ m.getTitle() }</a></td>
				<td>${ m.getWriter() }</td>
				<td>${ m.getRegdate() }</td>
				<td><a href="deleteBoard.do?seq=${ m.getSeq() }">${ m.getCnt() }</a></td>
			</tr>
		</c:forEach>
		<%--  		<%  --%>
		<!-- 		} -->
		<%-- 		%>  --%>
	</table>
	<a href="write.jsp">새글등록</a>
	<hr>
</body>
</html>