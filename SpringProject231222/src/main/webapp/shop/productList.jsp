<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

td {
	whiteSpace: nowrap;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>상품목록보기</h3>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가격</td>
				<td>상세설명</td>
				<td>이미지이름</td>
				<td>이미지</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${ li }" var="m">
				<tr>
					<td>${ m.getProduct_id() }</td>
					<td>
						<a href="productOne.do?product_id=${ m.getProduct_id() }">${ m.getProduct_name() }</a>
					</td>
					<td>${ m.getProduct_price() }</td>
					<td>${ m.getProduct_desc() }</td>
					<td>${ m.getProduct_img() }</td>
					<td><img src="${ path }/shop/img/${ m.getProduct_img() }" width=50 height=50 /></td>
					<c:url var="url" value="productDelete.do">
						<c:param name="product_id">${ m.getProduct_id() }</c:param>
						<c:param name="product_img">${ m.getProduct_img() }</c:param>
					</c:url>
					<td><a href="${ url }">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />