<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
td:first-child {
	background: skyblue;
}
</style>

<section>
	<br>
	<div align=center>
		<h3>상세보기/수정</h3>
		<form action="productUpdate.do" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td>번호</td>
					<td>${ m.getProduct_id() }</td>
					<td rowspan=3><img src="${ path }/shop/img/${ m.getProduct_img() }" width=100 /></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input name=product_name value="${ m.getProduct_name() }" /></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input name=product_price value="${ m.getProduct_price() }" /></td>
				</tr>
				<tr>
					<td>상세설명</td>
					<td colspan=2><textarea rows=5 cols=40 name="product_desc">${ m.getProduct_desc() }</textarea></td>
				</tr>
				<tr>
					<td>첨부자료</td>
					<td colspan=2><input type="file" name="product_img_file"></td>
				</tr>
				<tr>
					<td align=center colspan=3>
						<input type=submit value="수정" />
						<input type=button onClick="location.href='productDelete.do?product_id=${ m.getProduct_id() }&product_img=${ m.getProduct_img() }'" value="삭제" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />