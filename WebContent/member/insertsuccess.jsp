<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
	alert("회원 가입이 완료되었습니다. \n로그인 화면으로 이동합니다.");
	location.href="<%=request.getContextPath()%>/LoginForm.do";	
</script>

</body>
</html>