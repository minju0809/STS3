<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBoard.do">
		<table border=1>
			<tr>
				<td>번호</td>
				<td><input type=text name="seq"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type=text name="title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type=text name="writer"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit value="저장하기"></td>
			</tr>
		</table>
	</form>
	<br>
	<a href=index.jsp>홈으로</a>
</body>
</html>