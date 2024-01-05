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

<script>
	function ck1() {
		memo = f1.guestbook_memo.value;
		name = f1.guestbook_name.value;
		
		if(memo == "") {
			alert(memo + "메모를 입력해주세요");
			return false;
		}
		if(name == "") {
			alert(name + "이름를 입력해주세요");
			return false;
		}
		
	}
</script>

<section>
	<br>
	<div align=center>
		<h3>방명록  (레코드 수: ${totalCount})</h3>
		1.페이지 사이즈 : ${pageSize} &emsp;&emsp;
		2.페이지 List사이즈(아래숫자갯수) : ${pageListSize}<br>
		3.전체레코두 수 : ${totalCount}&emsp;&emsp;
		4.총페이지수 : ${totalPage}  <br>
		5.현재레코드 : ${start}&emsp;&emsp;
		6.현재페이지 : ${currentPage}<br>
		7.가로하단 시작 :${listStartPage}&emsp;&emsp;
		8.가로 하단 마지막 : ${listEndPage}
		
		<form name=f1 action="guestbookWrite.do"  onSubmit="return ck1()">
			<table border=1>
				<tr>
					<td>메모</td>
					<td>이름</td>
					<td>등록</td>
				</tr>
				<tr>
					<td><input type="text" name="guestbook_memo"></td>
					<td><input type="text" name="guestbook_name"></td>
					<td align=center><input type=submit value="등록하기"></td>
				</tr>
			</table>
		</form>
		<table border=1>
			<tr>
				<td>rownum</td>
				<td>rnum</td>
				<td>순번</td>
				<td>이름</td>
				<td>메모</td>
				<td>날짜</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="palegreen" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="aquamarine" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ m.rownum }</td>
						<td>${ m.rnum }</td>
						<td>${ m.guestbook_idx }</td>
						<td>${ m.guestbook_name }</td>
						<td width=300>${ m.guestbook_memo }</td>
						<td>${ m.guestbook_today }</td>
						<td><a href="guestbookDelete.do?guestbook_idx=${ m.guestbook_idx }&start=${ start }&ch1=${ch1}&ch2=${ch2}">삭제</a></td>
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
		
		<c:forEach var="i" begin="${listStartPage}"  end="${listEndPage}"  >
			<c:set var="startVar"  value="${(i-1) * pageSize + 1}" />
			<c:if test="${i <= totalPage}">
				<a href="guestbookList.do?start=${startVar}&ch1=${ch1}&ch2=${ch2}">[${i}]</a>&nbsp;
			</c:if>
		</c:forEach>
		
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