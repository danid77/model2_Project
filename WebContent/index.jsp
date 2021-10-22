<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/gathering_table.css">
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table class="type" style="margin:auto; width:45%; float:left; margin-left:20px;">
<caption>등산 페이지</caption>
	<tr>
		<th>등산코스명</th>
		<th>난이도</th>
		<th>소요시간</th>
		<th>길찾기</th>
	</tr>

	<c:forEach var="cos" items="${coslist}">
		<tr>
			<td>
				<a href="./GetCosInfo.do?cosName=${cos.cosName}">${cos.cosName}</a>
			</td>
			<td>${cos.cosDifficulty}</td>
			<td>${cos.cosTakeTime}</td>
			<td><a href="${cos.cosLink}">길찾기</a></td>
		</tr>
	</c:forEach>

	
	</tbody>
	
</table>


<table class="type" style="margin:auto; width:45%; float:right; margin-right:20px;">
	<tbody>
	<caption>모임게시판</caption>
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
			<td><a href="./GatherDetailAction.do?no=${b.no}&page=${page}">
					${b.gathersubject} </a></td>
			<td>${b.id}</td>
			<td><fmt:formatDate value="${b.reg_date}"
					pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
		</tr>
		<tr>

		</tr>
	</c:forEach>

</table>

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
			<c:if test="${i == page}">
				<!-- 현재페이지 -->
		[${i}] <!-- 링크 안걸음 -->
			</c:if>
			<c:if test="${i != page}">
				<!-- 현재페이지 아닌 경우 -->
				<a href="./GatherListAction.do?page=${i}">[${i}]</a>
			</c:if>
		</c:forEach>

		<!-- 다음 블럭으로 이동 -->
		<c:if test="${endpage < pageCount}">
			<a href="./GatherListAction.do?page=${startPage+10}"> 다음 </a>
		</c:if>

		<!-- 마지막 페이지로 이동 -->
		<a href="./GatherListAction.do?page=${pageCount}"> >> </a>
	</c:if>
</center>
</body>
</html>