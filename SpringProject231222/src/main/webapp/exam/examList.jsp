<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

/* td:nth-child(2) { */
/* 	width: 200px; */
/* } */

td:last-child {
	text-align: center;
}

</style>

<script>

</script>

<section>
	<br>
	<div align=center>
		<h3>성적목록보기</h3>
		<table border=1>
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>역사</td>
			</tr>
			<c:forEach items="${ li }" var="m">
				<tr>
					<td>${ m.getSno() }</td>
					<td>${ m.getSname() }</td>
					<td>${ m.getKor() }</td>
					<td>${ m.getEng() }</td>
					<td>${ m.getMath() }</td>
					<td>${ m.getHist() }</td>
				</tr>
			</c:forEach>
		</table>
		<form action="examList.do">
			<select name="ch1">
				<c:forEach items="${ ch1 }" var="option">
					<option value="${ option.value }">${ option.key }
				</c:forEach>
			</select>
			<input name="ch2" type=text />
			<input type=submit value="검색" />	
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />