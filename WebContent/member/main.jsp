<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="/header.jsp" %>

<!-- 세션이 있는 경우 -->
<c:if test="${sessionScope.id != null }">
	${sessionScope.id}님 환영합니다. <br><br>
	
	<a href="<%=request.getContextPath()%>/MemberDetail.do"> 마이 페이지 </a> <br><br>
	<a href="<%=request.getContextPath()%>/Logout.do"> 로그아웃 </a> <br><br>
</c:if>

<!-- 세션이 없는 경우 -->
<c:if test="${sessionScope.id == null }">
	<a href="<%=request.getContextPath()%>/MemberForm.do">회원가입</a> <br><br>
	<a href="<%=request.getContextPath()%>/LoginForm.do">로그인</a> <br><br>
</c:if>