<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="<%=request.getContextPath()%>/GetCosList.do">
	<input type="submit" value="귀찮아">
	</form>
	
	<form method="get" action="member/main.jsp">
	<input type="submit" value="회원">
	</form>
</body>
</html>