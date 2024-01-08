<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
td:first-child {
	background: tan;
}
</style>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	jQuery.ajaxSetup({cache:false})
	var path = '${path}';
// 	alert(path);
	
	$(document).ready(function () {
		$("#snoBtn").click(function () {
			var snoVal = $("#sno").val().trim();
			var data = {sno: snoVal};
			
			$.ajax({
				type : "GET",
				url : path+"/snoCk.do",
				data : data,
				success : function (data) {
					if (data == "T") {
						alert("사용 가능한 학번입니다.")
					} else {
						alert("이미 있는 학번입니다.")
						$("#sno").val("");
						$("#sno").focus();
					}
				}
			})
		})
		
		$("#snameBtn").click(function () {
			var snameVal = $("#sname").val().trim();
			var data = {sname: snameVal};
				
			$.ajax({
				type : "GET",
				url : path+"/snameCk.do",
				data : data,
				success : function (data) {
					if (data == "T") {
						alert(snameVal + "는(은) 사용 가능한 이름입니다.")
					} else {
						alert(snameVal + "는(은) 이미 있는 이름입니다.")
						$("#sname").val("");
						$("#sname").focus();
					}
				}
			})
		})
	}) 

	function formCk() {
	    var sno = $("#sno").val().trim();
	    if (sno.length !== 5 || isNaN(sno)) {
	        alert("5자리 숫자 학번을 입력해주세요");
	        $("#sno").val("");
	        $("#sno").focus();
	        return false;
	    }
	}
	
</script>

<section>
	<br>
	<div align=center>
	
		<h1>성적등록</h1>
		<hr>
		<form name=f1 action="examInsert.do" method="POST" onSubmit="return formCk()">
			<table border=1>
				<tr>
					<td>학번</td>
					<td><input type="text" name="sno" id="sno"><input type=button value="중복체크" id="snoBtn" /></td>
					
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="sname" id="sname"><input type=button value="중복체크" id="snameBtn" /></td>
				</tr>
				<tr>
					<td>국어</td>
					<td><input type="text" name="kor"></td>
				</tr>
				<tr>
					<td>영어</td>
					<td><input type="text" name="eng"></td>
				</tr>
				<tr>
					<td>수학</td>
					<td><input type="text" name="math"></td>
				</tr>
				<tr>
					<td>역사</td>
					<td><input type="text" name="hist"></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="글등록하기"></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="examList.do">성적 목록으로</a>
	</div>
	<br>
	
</section>

<c:import url="/include/bottom.jsp" />