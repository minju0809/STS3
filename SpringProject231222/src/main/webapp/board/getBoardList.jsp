<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<section>
	<br>
	<div align=center>
		<h3>목록보기</h3>
		<h5>${ userName }님환영합니다!..</h5>
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
		<a href="index.do">시작으로</a> <a href="write.do">새글등록</a>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />