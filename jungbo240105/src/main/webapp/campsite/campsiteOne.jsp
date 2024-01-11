<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>캠핑장 상세보기</h3>
		
		<table border=1>
			<tr>
				<td width=350px>지도확인</td>
				<td>상세보기</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<table border=1>
						<tr>
							<td>순번</td>
							<td><input type=text name="idx" value="${m.idx}" ></td>
						</tr>
						<tr>
							<td>캠핑장이름</td>
							<td><input type=text name="campsite" value="${m.campsite}" ></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type=text name="address" value="${m.address}" ></td>
						</tr>
						<tr>
							<td>번호</td>
							<td><input type=text name="tel" value="${m.tel}" ></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br>
		<a href="campsiteList.do">캠핑장 목록</a>
	</div>
	<br>
</section>


<c:import url="/include/bottom.jsp" />