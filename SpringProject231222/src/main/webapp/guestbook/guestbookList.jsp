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
		<h3>방명록  (레코드 수: ${totalCount})</h3>
		<table border=1>
			<tr>
				<td>rownum</td>
				<td>rnum</td>
				<td>순번</td>
				<td>이름</td>
				<td>메모</td>
				<td>날짜</td>
			</tr>
			<c:forEach items="${ li }" var="m">
				<tr>
					<td>${ m.rownum }</td>
					<td>${ m.rnum }</td>
					<td>${ m.guestbook_idx }</td>
					<td>${ m.guestbook_name }</td>
					<td width=300>${ m.guestbook_memo }</td>
					<td>${ m.guestbook_today }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="guestbookList.do?start=1&ch1=${ch1}&ch2=${ch2}">처음으로</a>
		<c:if test="${ start != 1 }">
			<a href="guestbookList.do?start=${ start - pageSize }&ch1=${ch1}&ch2=${ch2}">이전</a>
		</c:if>
		<c:if test="${ start == 1 }">
			이전
		</c:if>
		<c:if test="${ currentPage != totalPage }">
			<a href="guestbookList.do?start=${ start + pageSize }&ch1=${ch1}&ch2=${ch2}">다음</a>
		</c:if>
		<c:if test="${ currentPage == totalPage }">
			다음
		</c:if>
		
		<a href="guestbookList.do?start=${ lastPage }&ch1=${ch1}&ch2=${ch2}">마지막으로</a>
		
		<hr>
		<form action=guestbookList.do>
			<select name="ch1">
				<option value="guestbook_name">이름</option>
				<option value="guestbook_memo">메모</option>
				<option value="guestbook_today">날짜</option>
			</select>
			<input type=text name="ch2"/>
			<input type=submit value="검색" />
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />