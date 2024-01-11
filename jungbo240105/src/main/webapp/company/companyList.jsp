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
				<td>이름</td>
				<td>주소</td>
				<td>대표</td>
				<td>기타</td>
				<td>위도</td>
				<td>경도</td>
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
						<td>${ m.entrprsNm }</td>
						<td>${ m.rdnmadr }</td>
						<td>${ m.rprsntvNm }</td>
						<td>${ m.mainGoods }</td>
						<td>${ m.latitude }</td>
						<td>${ m.logitude }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>


<c:import url="/include/bottom.jsp" />