<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<section>
	<br>
	<div align=center>
		<h1>${ loginVO.getName() }님 환영합니다</h1>
		${ login.getMemberId() }
		<br>
		${ login.getName() }
		<br>
		${ login.getPwd() }
	</div>
	<br>
</section>

<c:import url="/include/bottom.jsp" />
