<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="<%=request.getContextPath()%>/member/membercheck.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/MemberDelete.do"> 
<input type="hidden" name="id" value="${sessionScope.id}">
<table class="type">
	<caption>회원 탈퇴</caption>
	
	<tr><th>비밀번호</th>
		<td><input type=password id="passwd" name="passwd"></td>
	</tr>	
	<tr><th>비밀번호 확인</th>
		<td><input type=password id="passwd_check" name="passwd_check"></td>
	</tr>
	<tr>
		<td colspan="5" align="center" ><input type=submit value="탈퇴"></td>
	</tr>		
</table>
</form>
</body>
</html>