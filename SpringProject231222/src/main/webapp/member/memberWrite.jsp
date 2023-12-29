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
		<h1>회원 등록</h1>
		<form action="memberWrite.do" method="post" >
			<table border=1>
				<tr>
					<td>번호</td>
					<td><input type="text" name="memberId" value="${ member_id }"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="text" name="pwd"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>등급</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>기타</td>
					<td><input type="text" name="etc"></td>
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