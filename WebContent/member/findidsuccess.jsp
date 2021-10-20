<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 성공</title>
</head>
<body>

<form>
	<table>
		<tr><th>아이디 찾기 결과</th></tr>
		<tr><td>아이디는 ${userid}입니다.</td></tr>
	</table>
</form>

<%
	session.removeAttribute("userid");
%>


</body>
</html>