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
		<h3>상세보기/수정</h3>
		<form action="update.do">
			<table border=1>
				<tr>
					<td>사진</td>
					<td><img src="${ path }/psd/img/${ m.getUploadFileStr() }" /></td>
				</tr>
				<tr>
					<td>번호</td>
					<td>${ m.getSeq() }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input name=title value="${ m.getTitle() }" /></td>
				</tr>
				<tr>
					<td>첨부자료</td>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td>날짜</td>
					<td>${ m.getRegdate() }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${ m.getCnt() }</td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="수정" /></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />