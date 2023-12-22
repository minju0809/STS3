<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
table {
	width: 500px;
	height: 250px;
}
</style>

<section>
	<br>
	<div align=center>
		<h1>게시판 글 등록</h1>
		<form action="write.do" method="post">
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows=5 cols=40 name="content"></textarea></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="글등록하기"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />