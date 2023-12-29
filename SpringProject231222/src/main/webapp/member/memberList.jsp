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

</style>

<section>
	<br>
	<div align=center>
		<h3>회원목록보기</h3>
		<table border=1>
			<tr>
				<td>순번</td>
				<td>번호</td>
				<td>이름</td>
				<td>연락처</td>
				<td>지역</td>
				<td>등급</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<tr>
					<td>${ status.count }</td>
					<td>${ m.getMemberId() }</td>
					<td>
						<a href="memberOne.do?memberId=${ m.getMemberId() }">${ m.getName() }</a>
					</td>
					<td>${ m.getPhone() }</td>
					<td>${ m.getAddress().substring(0,2) }</td>
					<td>${ m.getGrade() }</td>
					<c:url var="url" value="memberDelete.do">
						<c:param name="memberId">${ m.getMemberId() }</c:param>
					</c:url>
					<td><a href="${ url }">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<form action="memberList.do">
			<select name="ch1">
				<option value=name>이름</option>
				<option value=grade>등급</option>
				<option value=address>주소</option>
			</select>
			<input type=text name="ch2" />
			<input type=submit value=검색 />
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />