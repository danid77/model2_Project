<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table class="type" width="1000px" hight="600px">
		<caption>모임 상세 페이지</caption>
		<tr>
			<th width="200px">제목</th>
			<td width="400px">${gather.gathersubject}</td>
			<td colspan="2"><input type="button" value="모임 참가"
				onclick="location.href='./GatherCrewList.do?no=${gather.no}&page=${page}'"></td>
		</tr>

		<tr>

			<th>모임인원</th>
			<td>${gather.membercnt}</td>
			<th width="200px">지역</th>
			<td width="400px">${gather.local}</td>
		</tr>

		<tr>
			<th>내용</th>
			<td colspan="4">${content}</td>
		</tr>

		<tr>
			<td align="center" colspan="5"><input type="button"
				value="모임원 조회"
				onClick="location.href='./GatherCrewListView.do?no=${gather.no}&page=${page}' ">

				<input type="button" value="수정"
				onClick="location.href='./GatherModifyAction.do?no=${gather.no}&page=${page}' ">

				<input type="button" value="삭제"
				onClick="location.href='./GatherDeleteAction.do?no=${gather.no}&page=${page}' ">

				<input type="button" value="목록"
				onClick="location.href='./GatherListAction.do?page=${page}' ">

			</td>
		</tr>
	</table>

</body>
</html>