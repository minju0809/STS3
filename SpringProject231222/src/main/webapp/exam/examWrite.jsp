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
		<h1>성적 입력</h1>
		<form action="examWrite.do" method="post">
			<table border=1>
				<tr>
					<td>학번</td>
					<td><input type="text" name="sno"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="sname"></td>
				</tr>
				<tr>
					<td>국어</td>
					<td><input type="text" name="kor"></td>
				</tr>
				<tr>
					<td>영어</td>
					<td><input type="text" name="eng"></td>
				</tr>
				<tr>
					<td>수학</td>
					<td><input type="text" name="math"></td>
				</tr>
				<tr>
					<td>역사</td>
					<td><input type="text" name="hist"></td>
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