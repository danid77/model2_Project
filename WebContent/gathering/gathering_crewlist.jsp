<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table>
	<caption>${gather_name}</caption>
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>지역</td>
		<td>성별</td>
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
