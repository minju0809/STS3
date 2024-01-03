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

<script>
	function updateAll() {
		alert("전체수정");
		f1.action="shopTotalUpdate.do"
	}
	
	function orderAll() {
		alert("전체주문");
		f1.action="shopOrderAll.do"
	}
</script>

<section>
	<br>
	<div align=center>
		<h3>장바구니목록보기</h3>
		<form name=f1>
			<table border=1>
				<tr>
					<td>순번</td>
					<td>img</td>
					<td>cart_id</td>
					<td>memberId</td>
					<td>product_id</td>
					<td>product_name</td>
					<td>price</td>
					<td>A(T)</td>
					<td>amount</td>
					<td>total</td>
					<td>삭제</td>
				</tr>
				<c:forEach items="${ li }" var="m" varStatus="status">
					<input type=hidden name="memberId" value="${ m.getMemberId() }" />
					<input type=hidden name="cart_id" value="${ m.getCart_id() }" />
					<input type=hidden name="product_id" value="${ m.getProduct_id() }" />
					<input type=hidden name="product_name" value="${ m.getProduct_name() }" />
					<tr>
						<td>${ status.count }</td>
						<td><img src="${ path }/shop/img/${ m.getProduct_img() }" width=50 height=50 /></td>
						<td>${ m.getCart_id() }</td>
						<td>${ m.getMemberId() }</td>
						<td>${ m.getProduct_id() }</td>
						<td>${ m.getProduct_name() }</td>
						<td>${ m.getProduct_price() }</td>
						<td>${ m.getAmount() }</td>
						<td>
							<c:if test="${ m.getAmount() gt 5 }">
								<select name=amount>
									<c:forEach var="p" begin="1" end="5">
										<c:if test="${p == 5 }" >
											<option value="${ p }" selected>${ p }</option>
										</c:if>
										<c:if test="${p != 5 }" >
											<option value="${ p }">${ p }</option>
										</c:if>
									</c:forEach>
								</select>
								<td>${ 5 * m.getProduct_price() }</td>
							</c:if>
							<c:if test="${ m.getAmount() le 5 }">
								<select name=amount>
									<c:forEach var="p" begin="1" end="5">
										<c:if test="${ m.getAmount() == p }" >
											<option value="${ p }" selected>${ p }</option>
										</c:if>
										<c:if test="${ m.getAmount() != p }" >
											<option value="${ p }">${ p }</option>
										</c:if>
									</c:forEach>
								</select>
								<td>${ m.getAmount() * m.getProduct_price() }</td>
							</c:if>
						</td>
						<td><a href="shopRecordDelete.do?cart_id=${ m.getCart_id() }&memberId=${login.getMemberId()}">삭제</a></td>
					</tr>
					<c:set var="total" value="${ total = total + m.getAmount() * m.getProduct_price() }"></c:set>
				</c:forEach>
				<tr>
					<td colspan="11" align="right">전체 구매 금액: 
					<fmt:formatNumber pattern="0,000" value="${total}" />원</td>
				</tr>
			</table>
			<br>
			<input type=button value="전체삭제" onclick="location.href='shopTotalDelete.do?memberId=${login.getMemberId()}'" />
			<input type=submit value="전체수정" onclick="updateAll()" />
			<input type=submit value="전체주문" onclick="orderAll()" />
			<input type=button value="상품목록" onclick="location.href='productList.do'" />
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />