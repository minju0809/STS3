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
				<td>대학명</td>
				<td>영문명</td>
				<td>지역</td>
				<td>주소</td>
				<td>홈페이지</td>
				<td>전화</td>
				<td>팩스</td>
				<td>대표메일</td>
			</tr>
			<c:forEach items="${ li2 }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="moccasin" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="lemonchiffon" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ status.index }</td>
						<td>${ m.name }</td>
						<td>${ m.english }</td>
						<td>${ m.region }</td>
						<td>${ m.address }</td>
						<td>${ m.homepage }</td>
						<td>${ m.tel }</td>
						<td>${ m.fax }</td>
						<td>${ m.email }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>


<c:import url="/include/bottom.jsp" />