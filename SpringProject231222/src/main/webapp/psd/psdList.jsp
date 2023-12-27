<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: skyblue;
}

/* td:nth-child(2) { */
/* 	width: 200px; */
/* } */

td:last-child {
	text-align: center;
}

</style>

<script>

</script>

<section>
	<br>
	<div align=center>
		<h3>자료목록보기</h3>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>파일명</td>
				<td>이미지</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${ li }" var="m">
				<tr>
					<td>${ m.getSeq() }</td>
					<td>
						<a href="psdOne.do?seq=${ m.getSeq() }">${ m.getTitle() }</a>
					</td>
					<td>${ m.getUploadFileStr() }</td>
					<td><img src="${ path }/psd/img/${ m.getUploadFileStr() }" width=50 height=50 /></td>
					<td>${ m.getRegdate() }</td>
					<td>
					<c:url var="url" value="psdDelete.do">
						<c:param name="seq">${ m.getSeq() }</c:param>
						<c:param name="uploadFileStr">${ m.getUploadFileStr() }</c:param>
					</c:url>
						<a href="${ url }">${ m.getCnt() }</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />