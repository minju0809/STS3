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
		<h3>장바구니목록보기</h3>
		<table border=1>
			<tr>
				<td>순번</td>
				<td>product_img</td>
				<td>cart_id</td>
				<td>memberId</td>
				<td>product_id</td>
				<td>product_name</td>
				<td>price</td>
				<td>amount</td>
				<td>total</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<tr>
					<td>${ status.count }</td>
					<td><img src="${ path }/shop/img/${ m.getProduct_img() }" width=50 height=50 /></td>
					<td>${ m.getCart_id() }</td>
					<td>${ m.getMemberId() }</td>
					<td>${ m.getProduct_id() }</td>
					<td>${ m.getProduct_name() }</td>
					<td>${ m.getProduct_price() }</td>
					<td>${ m.getAmount() }</td>
					<td>${ m.getAmount() * m.getProduct_price() }</td>
				</tr>
				<c:set var="total" value="${ total = total + m.getAmount() * m.getProduct_price() }"></c:set>
			</c:forEach>
			<tr>
				<td colspan="9" align="right">전체 구매 금액: 
				<fmt:formatNumber pattern="0,000" value="${total}" /></td>
			</tr>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />