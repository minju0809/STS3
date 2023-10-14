<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<section>
	<br>
	<div align="center">
		<h2>
			<a href=board.jsp>스프링 퀵 스타트 게시판 목록보기</a>
		</h2>

		<table border=1 width=700>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일(D)</td>
				<td>조회수</td>
			</tr>

			<c:forEach items="${boardList}" var="m">
				<tr>
					<td>${m.getSeq()}</td>
					<td>${m.getTitle()}</td>
					<td>${m.getWriter()}</td>
					<td>${m.getRegDate()}</td>
					<td><a href=delete.do?seq=${m.getSeq()}>${m.getCnt()}</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href=index.jsp>홈으로</a>
	</div>
	<br>
</section>