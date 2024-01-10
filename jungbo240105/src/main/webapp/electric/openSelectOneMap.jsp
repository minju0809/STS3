<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
td:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>충전소 위치 상세보기</h3>
		<table border=1>
			<tr>
				<td>순번</td>
				<td><input type=text name="idx" value="${param.idx}" ></td>
			</tr>
			<tr>
				<td>지역</td>
				<td><input type=text name="region" value="${param.region}" ></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type=text name="station" value="${param.station}" ></td>
			</tr>
			<tr>
				<td>위도</td>
				<td><input type=text name="latitude" value="${param.latitude}" ></td>
			</tr>
			<tr>
				<td>경도</td>
				<td><input type=text name="longitude" value="${param.longitude}" ></td>
			</tr>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />