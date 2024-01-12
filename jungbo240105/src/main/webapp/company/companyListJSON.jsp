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
				<td>순번</td>
				<td>축제명</td>
				<td>축제 요약</td>
				<td>축제 주제</td>
				<td>축제 기간</td>
				<td>축제장소 명</td>
				<td>축제 주최 명</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="moccasin" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="lemonchiffon" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ status.index }</td>
						<td>${ m.festvNm }</td>
						<td>${ m.festvSumm }</td>
						<td>${ m.festvTpic }</td>
						<td>${ m.festvPrid }</td>
						<td>${ m.festvPlcNm }</td>
						<td>${ m.festvHostNm }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>


<c:import url="/include/bottom.jsp" />