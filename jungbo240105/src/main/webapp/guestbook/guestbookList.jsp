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
		<table border=1>
			<tr>
				<td>순번</td>
				<td>이름</td>
				<td>메모</td>
				<td>날짜</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="palegreen" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="aquamarine" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ m.guestbook_idx }</td>
						<td>${ m.guestbook_name }</td>
						<td width=300>${ m.guestbook_memo }</td>
						<td>${ m.guestbook_today }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />