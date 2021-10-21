<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>gathering Write</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/gathering/gather.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
</head>
<body>

<form action="<%=request.getContextPath()%>/GatherModify.do" method="post">
<input type="hidden" name="no" value="${gather.no}">
<input type="hidden" name="page" value="${page}">
	  
	  
<table class="type" width="800px">
	  <caption>Santago 등산모임 게시판 수정</caption>
	
	<tr>
		<th>모임이름</th>
		<td>
			<input name="gathersubject" id="gathersubject" type="text" value="${gather.gathersubject}"/>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input name="id" id="id" type="text" value="${gather.id}" readonly="readonly"/>
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input name="gatherpw" id="gatherpw" type="password" value=""/>
		</td>
	</tr>
		
	<tr>
		<th>지역</th>
		<td><select id="local" name="local">
			<option value="">지역 선택</option>
			<option value="강남구" <c:if test="${gather.local == '강남구'}">${'selected'}</c:if> >강남구</option>
			<option value="강동구" <c:if test="${gather.local == '강동구'}">${'selected'}</c:if> >강동구</option>
			<option value="강북구" <c:if test="${gather.local == '강북구'}">${'selected'}</c:if> >강북구</option>
			<option value="관악구" <c:if test="${gather.local == '관악구'}">${'selected'}</c:if> >관악구</option>
			<option value="광진구" <c:if test="${gather.local == '광진구'}">${'selected'}</c:if> >광진구</option>
			<option value="구로구" <c:if test="${gather.local == '구로구'}">${'selected'}</c:if> >구로구</option>
			<option value="금천구" <c:if test="${gather.local == '금천구'}">${'selected'}</c:if> >금천구</option>
			<option value="노원구" <c:if test="${gather.local == '노원구'}">${'selected'}</c:if> >노원구</option>
			<option value="도봉구" <c:if test="${gather.local == '도봉구'}">${'selected'}</c:if> >도봉구</option>
			<option value="동대문구" <c:if test="${gather.local == '동대문구'}">${'selected'}</c:if> >동대문구</option>
			<option value="동작구" <c:if test="${gather.local == '동작구'}">${'selected'}</c:if> >동작구</option>
			<option value="마포구" <c:if test="${gather.local == '마포구'}">${'selected'}</c:if> >마포구</option>
			<option value="서대문구" <c:if test="${gather.local == '서대문구'}">${'selected'}</c:if> >서대문구</option>
			<option value="서초구" <c:if test="${gather.local == '서초구'}">${'selected'}</c:if> >서초구</option>
			<option value="성동구" <c:if test="${gather.local == '성동구'}">${'selected'}</c:if> >성동구</option>
			<option value="성북구" <c:if test="${gather.local == '성북구'}">${'selected'}</c:if> >성북구</option>
			<option value="송파구" <c:if test="${gather.local == '송파구'}">${'selected'}</c:if> >송파구</option>
			<option value="양천구" <c:if test="${gather.local == '양천구'}">${'selected'}</c:if> >양천구</option>
			<option value="영등포구" <c:if test="${gather.local == '영등포구'}">${'selected'}</c:if> >영등포구</option>
			<option value="용산구" <c:if test="${gather.local == '용산구'}">${'selected'}</c:if> >용산구</option>
			<option value="은평구" <c:if test="${gather.local == '은평구'}">${'selected'}</c:if> >은평구</option>
			<option value="종로구" <c:if test="${gather.local == '종로구'}">${'selected'}</c:if> >종로구</option>
			<option value="중구" <c:if test="${gather.local == '중구'}">${'selected'}</c:if> >중구</option>
			<option value="중랑구" <c:if test="${gather.local == '중랑구'}">${'selected'}</c:if> >중랑구</option>
		</select>		
		</td>
	</tr>
	<tr>
	<th>인원수</th>
	<td><select id="membercnt" name="membercnt">
				<option value="">0</option>
				<option value="1" <c:if test="${gather.membercnt == '1'}">${'selected'}</c:if> >1</option>
				<option value="2" <c:if test="${gather.membercnt == '2'}">${'selected'}</c:if> >2</option>
				<option value="3" <c:if test="${gather.membercnt == '3'}">${'selected'}</c:if> >3</option>
				<option value="4" <c:if test="${gather.membercnt == '4'}">${'selected'}</c:if> >4</option>
				<option value="5" <c:if test="${gather.membercnt == '5'}">${'selected'}</c:if> >5</option>
				<option value="6" <c:if test="${gather.membercnt == '6'}">${'selected'}</c:if> >6</option>
			</select>
	</td>	
	</tr>
	
	<tr>
		<th>Content</th>
		<td>
			<textarea name="content" id="content">${gather.content} </textarea>
		</td>
	</tr>
	
	<tr>
		<td align="center" colspan="5">			
			<input type=submit value="수정">
			<input type=reset value="취소" onclick="history.back()">
			
			<!-- 상세페이지 가는 기능 넣어야함 -->
		</td>
	</tr>
</table>
</form>

</body>
</html>
</html>