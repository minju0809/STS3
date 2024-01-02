<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>장바구니목록보기</h3>
		<table border=1>
			<tr>
				<td>순번</td>
				<td>cart_id</td>
				<td>memberId</td>
				<td>product_id</td>
				<td>product_name</td>
				<td>amount</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<tr>
					<td>${ status.count }</td>
					<td>${ m.getCart_id() }</td>
					<td>${ m.getMemberId() }</td>
					<td>${ m.getProduct_id() }</td>
					<td>${ m.getProduct_name() }</td>
					<td>${ m.getAmount() }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />