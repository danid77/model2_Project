<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 성공</title>
</head>
<body>

<form>
	<table>
		<tr><th>비밀번호 찾기 결과</th></tr>
		<tr><td>${userid}님의 비밀번호는 ${userpasswd}입니다.</td></tr>
	</table>
</form>

<%
	session.removeAttribute("userid");
	session.removeAttribute("userpasswd");
%>

</body>
</html>