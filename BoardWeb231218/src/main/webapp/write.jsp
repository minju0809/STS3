<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.board.*"%>
<%@ page import="com.springbook.biz.board.impl.*"%>
<%@ page import="java.util.*"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새글등록</h1>
	<hr>
<!-- 	<form action="write_proc.jsp" method="post"> -->
	<form action="insertBoard.do" method="post">
		<table border=1>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows=5 cols=40 name="content"></textarea></td>
			</tr>
			<tr>
				<td align=center colspan=2><input type=submit value="글등록하기"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록으로</a>
</body>
</html>