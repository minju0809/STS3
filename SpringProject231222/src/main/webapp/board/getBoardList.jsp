<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

td:nth-child(2) {
	width: 200px;
}

td:last-child {
	text-align: center;
}

</style>

<script>

</script>

<section>
	<br>
	<div align=center>
		<h3>목록보기</h3>
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
					<td><a href="detail.do?seq=${ m.getSeq() }" >${ m.getTitle() }</a></td>
					<td>${ m.getWriter() }</td>
					<td>${ m.getRegdate().substring(0, 10) }</td>
					<td><a href="delete.do?seq=${ m.getSeq() }">${ m.getCnt() }</a></td>
				</tr>
			</c:forEach>
		</table>
		<form action="getBoardList.do">
			<select name="ch1">
				<c:forEach items="${ ch1 }" var="option">
					<option value="${ option.value }">${ option.key }
				</c:forEach>
			</select>
			<input type=text name="ch2" />
			<input type= submit value="검색" />
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />