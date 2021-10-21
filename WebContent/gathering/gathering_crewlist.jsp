<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/gathering_table.css">
<%@ include file="/header.jsp"%>

<table class="type">
	<caption>${gather_name}</caption>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>지역</th>
		<th>성별</th>
	</tr>
	<c:forEach var="people" items="${plist}">
	<tr>
		<td>${people.id}</td>
		<td>${people.local}</td>
		<td>${people.gender}</td>
	</tr>
	</c:forEach>
	
<tr><td><input type="button" value="뒤로가기" onClick="location.href='./GatherDetailAction.do?no=${no}&page=${page}'"></td></tr>
</table>
