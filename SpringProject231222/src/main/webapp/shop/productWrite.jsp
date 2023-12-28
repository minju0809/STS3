<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
table {
/* 	width: 500px; */
/* 	height: 250px; */
}
</style>

<section>
	<br>
	<div align=center>
		<h1>자료실 입력</h1>
		<form action="productWrite.do" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td>상품번호</td>
					<td><input type="text" name="product_id" value="${ productId }"></td>
				</tr>
				<tr>
					<td>상품이름</td>
					<td><input type="text" name="product_name"></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="product_price"></td>
				</tr>
				<tr>
					<td>상세설명</td>
					<td><input type="text" name="product_desc"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="product_img_file"></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="등록하기"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />