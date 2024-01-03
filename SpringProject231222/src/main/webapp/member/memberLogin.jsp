<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<section>
	<br>
	<div align=center>
		<h1>로그인</h1>
		<form action="memberLogin.do" method="post" >
			<table border=1>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="관리자"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="text" name="pwd" value="1234"></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" /> 