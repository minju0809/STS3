<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

td:last-child {
/* 	text-align: center; */
}

</style>

<section>
	<br>
	<div align=center>
		<h3>주문 회원 목록 보기</h3>
		<table border=1>
			<tr>
				<td>순번</td>
				<td>주문번호</td>
				<td>이름</td>
				<td>연락처</td>
				<td>특이사항</td>
				<td>주문날짜</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<tr>
					<td>${ status.count }</td>
					<td>${ m.orderId }</td>
					<td>${ m.name }</td>
					<td>${ m.phone }</td>
					<td>${ m.etc }</td>
					<td>${ m.today }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />