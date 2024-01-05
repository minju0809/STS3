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

.product_container {
	background-color: bisque;
	display: inline-flex;
	width: 140px;
	align-content: center;
	border: 1px solid black;
}

.product_container a {
	text-decoration: none;
}
</style>

<section>
	<br>
	<div align=center>
		<h3>상품목록보기2</h3>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<div class="product_container">
					<div>
						상품번호: ${ m.getProduct_id() }<br>
						<img src="${ path }/shop/img/${ m.getProduct_img() }" width=50 height=50 /><br>
						상품이름: ${ m.getProduct_name() }<br>
						상품가격: ${ m.getProduct_price() }
					</div>
				</div>
			</c:forEach>
		<form action="productList.do">
			<select name="ch1">
				<option value=product_name>상품명</option>
				<option value=product_desc>상세설명</option>
			</select>
			<input type=text name="ch2" />
			<input type=submit value=검색 />
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />