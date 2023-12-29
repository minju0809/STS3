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
		<h3>회원 상세보기/수정</h3>
		<form action="memberUpdate.do">
			<table border=1>
				<tr>
					<td>번호</td>
					<td>${ m.getMemberId() }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input name=name value="${ m.getName() }" /></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input name=pwd value="${ m.getPwd() }" /></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input name=phone value="${ m.getPhone() }" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input name=address value="${ m.getAddress() }" /></td>
				</tr>
				<tr>
					<td>등급</td>
					<td><input name=grade value="${ m.getGrade() }" /></td>
				</tr>
				<tr>
					<td>기타</td>
					<td><input name=etc value="${ m.getEtc() }" /></td>
				</tr>
				<tr>
					<td align=center colspan=2>
						<input type=button onClick="location.href='memberList.do'" value="목록" />
						<input type=submit value="수정" />
						<input type=button onClick="location.href='memberDelete.do?memberId=${ m.getMemberId() }'" value="삭제" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />