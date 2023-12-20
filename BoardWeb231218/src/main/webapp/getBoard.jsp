<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.springbook.biz.board.*"%>
<%@ page import="com.springbook.biz.board.impl.*"%>
<%@ page import="java.util.*"%>
<%
// request.setCharacterEncoding("utf-8");

// int seq = Integer.parseInt(request.getParameter("seq"));

// BoardService service = new BoardServiceImpl();
// BoardVO m = service.getBoard(seq);

// BoardVO m = (BoardVO) session.getAttribute("m");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기/수정</h1>
	<a href="logout.do">Log-out</a>
	<hr>
<!-- 	<form action="update_proc.jsp"> -->
	<form action="updateBoard.do">
<%-- 	<input type=hidden name=seq value="${ m.getSeq() }" /> --%>
		<table border=1>
			<tr>
				<td>번호</td>
				<td><input type="text" name="seq" value="${ m.getSeq() }" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${ m.getTitle() }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${ m.getWriter() }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"
					value="${ m.getContent() }"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" name="regdate"
					value="${ m.getRegdate() }" readonly></td>
			</tr>
			<tr>
				<td align=center colspan=2><input type=submit value="수정하기">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록</a>
</body>
</html>