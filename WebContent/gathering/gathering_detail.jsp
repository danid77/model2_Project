<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>모임 상세 페이지</h2>

<table>
<tr>
<td>제목</td>
<td>${gather.gathersubject}</td>
<td><input type="button" value="모임 참가" onclick="location.href='./GatherCrewList.do?no=${gather.no}&page=${page}'"></td>
</tr>

<tr>

<td>모임인원</td>
<td>${gather.membercnt}</td>
<td>지역</td>
<td>${gather.local}</td>
</tr>

<tr>
<td>내용</td>
</tr>
<tr>
<td>${content}</td>
</tr>

<tr><td>
			
			<input type="button" value="모임원 조회" onClick="location.href='./GatherCrewListView.do?no=${gather.no}&page=${page}' ">
			
			<input type="button" value="수정" onClick="location.href='./GatherModifyAction.do?no=${gather.no}&page=${page}' ">
			
			<input type="button" value="삭제" onClick="location.href='./GatherDeleteAction.do?no=${gather.no}&page=${page}' ">
			
			<input type="button" value="목록" onClick="location.href='./GatherListAction.do?page=${page}' ">

		</td>
</tr>
</table>

</body>
</html>