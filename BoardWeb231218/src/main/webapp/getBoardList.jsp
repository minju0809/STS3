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
	<div align=center>
		<h1>목록보기</h1>
		<h3>${ userName }님
			환영합니다!..<a href="logout.do">Log-out</a>
			<!-- 	jsp 였다면 session.getAttribute 로 받아와야 하지만, el 표기법이라 바로 가져올 수 있음 -->
		</h3>
		<hr>
		<form action="getBoardList.do" method="post">
			<table border=1 cellpadding="0" cellspacing="0">
				<tr>
					<td align=right><select name="ch1">
<!-- 						<option value="title">제목</option> -->
<!-- 						<option value="content">내용</option> -->
							<c:forEach items="${ map }" var="option">
								<option value="${ option.value }">${ option.key }</option>
							</c:forEach>
					</select> <input name="ch2" type="text" /> <input type=submit value="검색" />
					</td>
				</tr>
			</table>
		</form>
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
					<td><a href="getBoard.do?seq=${ m.getSeq() }">${ m.getTitle() }</a></td>
					<td>${ m.getWriter() }</td>
					<td>${ m.getRegdate() }</td>
					<td><a href="deleteBoard.do?seq=${ m.getSeq() }">${ m.getCnt() }</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="write.jsp">새글등록</a>
		<hr>
	</div>
</body>
</html>