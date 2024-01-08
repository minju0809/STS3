<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<table border=1>
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>역사</td>
				<td>합계</td>
				<td>평균</td>
				<td>등급</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="moccasin" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="lemonchiffon" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ m.sno }</td>
						<td>${ m.sname }</td>
						<td>${ m.kor }</td>
						<td>${ m.eng }</td>
						<td>${ m.math }</td>
						<td>${ m.hist }</td>
						<td>${ m.sum }</td>
						<td>${ m.avg }</td>
						<td>${ m.grade }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />