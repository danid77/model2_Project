<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="<%=request.getContextPath()%>/member/membercheck.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/MemberDelete.do"> 
<input type="hidden" name="id" value="${sessionScope.id}">
<table>
	<caption>회원 탈퇴</caption>
	
	<tr><td>비밀번호</td>
		<td><input type=password id="passwd" name="passwd"></td>
	</tr>	
	<tr><td>비밀번호 확인</td>
		<td><input type=password id="passwd_check" name="passwd_check"></td>
	</tr>
	<tr>
		<td><input type=submit value="탈퇴"></td>
	</tr>		
</table>
</form>
</body>
</html>