<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="gathering_table.css">
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:48%; marge:10px; float:left;">
	<%@ include file="cos/cos_list2.jsp" %>
	</div>
<div style="width:48%; marge:10px; float:left;">
	<%@ include file="gathering/gathering_list2.jsp" %>
	</div>
</body>
</html>