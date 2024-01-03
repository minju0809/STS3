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
		<h3>주문 목록 보기</h3>
			회원번호: ${ orderMember.memberId }<br>
			이름: ${ orderMember.name }<br>
			연락처: ${ orderMember.phone }<br>
			등급: ${ orderMember.grade }<br>
			주소: ${ orderMember.address }<br>
			주문날짜: ${ orderMember.today }<br>
			특이사항: ${ orderMember.etc }<br>
		
		<table border=1>
			<tr>
				<td>순번</td>
				<td>주문번호</td>
				<td>장바구니번호</td>
				<td>회원번호</td>
				<td>제품번호</td>
				<td>과자이름</td>
				<td>상품가격</td>
				<td>수량</td>
				<td>구매가격</td>
			</tr>
			<c:forEach items="${ li }" var="o" varStatus="status">
				<tr>
					<td>${ status.count }</td>
					<td>${ o.orderId }</td>
					<td>${ o.cart_id }</td>
					<td>${ o.memberId }</td>
					<td>${ o.product_id }</td>
					<td>${ o.product_name }</td>
					<td>${ o.product_price }</td>
					<td>${ o.amount }</td>
					<td>${ o.price }</td>
				</tr>
				<c:set var="totalPrice" value="${ totalPrice = totalPrice + o.price }"></c:set>
			</c:forEach>
			<tr>
				<td colspan=9 align=right>
					총 구매 가격: ${ totalPrice }원<br>
				<c:if test="${ totalPrice gt 10000 }">
					배송비: <s>3000원</s> <c:out value="500원" /><br>
					총 결제 금액: <c:out value="${ 500 + totalPrice }" />
				</c:if>
				<c:if test="${ totalPrice le 10000 }">
					배송비: <c:out value="3000원" /><br>
					총 결제 금액: <c:out value="${ 3000 + totalPrice }" /> 
				</c:if>
				</td>
			</tr>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />