<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<link rel="stylesheet" href="/gathering_table.css">
	<%@ include file="/header.jsp" %>

<table class="type">
<tbody>
	<caption>게시판 목록</caption>
	<tr>
		<th>번호</th>
		<th>모임 이름</th>
		<th>모임장</th>
		<th>날짜</th>
	</tr>

	<c:set var="num" value="${listcount - (page-1) * 10 }" />
	<c:forEach var="b" items="${gatherlist}">
		<tr>
			<td>${num}<c:set var="num" value="${num-1}" />
			</td>
			<td>
			<a href="./GatherDetailAction.do?no=${b.no}&page=${page}">
				${b.gathersubject} 
			</a>
			</td>
			<td>${b.id}</td>
			<td><fmt:formatDate value="${b.reg_date}"
					pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
		</tr>
		<tr>
		
		</tr>
	</c:forEach>
</tbody>
</table><br><br>

<a href="./GatherForm.do">글쓰기</a>
<br>
모임 갯수 : ${listcount}개
<br>

<!-- 페이지 처리 -->
<center>
<c:if test="${listcount > 0}">

<!-- 1페이지로 이동 -->
<a href="./GatherListAction.do?page=1"> << </a>

<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10}">
	<a href="./GatherListAction.do?page=${startPage - 10}"> 이전 </a>
</c:if>

<!-- 각 블럭에 10개의 -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i == page}">	<!-- 현재페이지 -->
		[${i}] <!-- 링크 안걸음 -->
	</c:if>
	<c:if test="${i != page}">	<!-- 현재페이지 아닌 경우 -->
		<a href="./GatherListAction.do?page=${i}">[${i}]</a>
	</c:if>
</c:forEach>

<!-- 다음 블럭으로 이동 -->
<c:if test="${endpage < pageCount}">
		<a href="./GatherListAction.do?page=${startPage+10}"> 다음 </a>
</c:if>

<!-- 마지막 페이지로 이동 -->
<a href="./GatherListAction.do?page=${pageCount}" > >> </a>
</c:if>
</center>





