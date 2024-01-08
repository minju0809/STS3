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
				<c:set var="sum" value="${ m.kor+m.eng+m.math+m.hist }" />
				<c:set var="avg" value="${ sum/4 }" />
				<c:choose>
					<c:when test="${ avg >= 90 }">
						<c:set var="grade" value="수" />
					</c:when>
					<c:when test="${ avg >= 80 }">
						<c:set var="grade" value="우" />
					</c:when>
					<c:when test="${ avg >= 70 }">
						<c:set var="grade" value="미" />
					</c:when>
					<c:otherwise>
						<c:set var="grade" value="재시험" />
					</c:otherwise>
				</c:choose>
				
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
						<td>${ sum }</td>
						<td>${ avg }</td>
						<td>${ grade }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />