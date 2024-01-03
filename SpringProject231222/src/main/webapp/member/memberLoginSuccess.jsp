<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<section>
	<br>
	<div align=center>
		<h1>${ loginVO.getName() }님 환영합니다</h1>
		회원번호: ${ login.getMemberId() }
		<br>
		회원이름: ${ login.getName() }
		<br>
		비밀번호: ${ login.getPwd() }
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />

