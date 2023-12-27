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
		<form action="psdWrite.do" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>첨부자료</td>
					<td><input type="file" name="uploadFileStr"></td>
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