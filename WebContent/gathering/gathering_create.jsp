<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>gathering Write</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/gathering/gather.js"></script>

<link rel="stylesheet" href="/gathering_table.css">
<%@ include file="/header.jsp"%>
<!--  스타일용 코드  -->
</head>
<body>

	<form action="<%=request.getContextPath()%>/GatherAddAction.do"
		method="post">

		<!-- 	  
<h2 align="center">Santago 등산모임 게시판</h2>	  
  -->
		<table class="type">
			<!-- <tr align="center" valign="middle">
		<td colspan="5">Santago 모임 게시판</td>
	</tr> -->
			<tr>
				<th>모임이름</th>
				<td><input name="gathersubject" id="gathersubject" type="text"
					size="50" maxlength="100" value="" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="id" id="id" type="text" size="10"
					maxlength="10" value="${id}" readonly /></td>
			</tr>

			<tr>
				<th>게시판 비밀번호 설정</th>
				<td><input name="gatherpw" id="gatherpw" type="password"
					size="10" maxlength="10" value="" /></td>
			</tr>

			<tr>
				<th>지역</th>
				<td><select id="local" name="local" style="width: 300px">
						<option value="">지역 선택</option>
						<option value="강남구">강남구</option>
						<option value="강동구">강동구</option>
						<option value="강북구">강북구</option>
						<option value="관악구">관악구</option>
						<option value="광진구">광진구</option>
						<option value="구로구">구로구</option>
						<option value="금천구">금천구</option>
						<option value="노원구">노원구</option>
						<option value="도봉구">도봉구</option>
						<option value="동대문구">동대문구</option>
						<option value="동작구">동작구</option>
						<option value="마포구">마포구</option>
						<option value="서대문구">서대문구</option>
						<option value="서초구">서초구</option>
						<option value="성동구">성동구</option>
						<option value="성북구">성북구</option>
						<option value="송파구">송파구</option>
						<option value="양천구">양천구</option>
						<option value="영등포구">영등포구</option>
						<option value="용산구">용산구</option>
						<option value="은평구">은평구</option>
						<option value="종로구">종로구</option>
						<option value="중구">중구</option>
						<option value="중랑구">중랑구</option>
				</select></td>
			</tr>
			<tr>
				<th>인원수</th>
				<td><select id="membercnt" name="membercnt"
					style="width: 300px">
						<option value="">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
				</select></td>
			</tr>

			<tr>
				<th>Content</th>
				<td><textarea name="content" id="content" cols="67" rows="15"></textarea>
				</td>
			</tr>

			<tr align="center" valign="middle">
				<td colspan="5"><input type=submit value="등록"> <input
					type=reset value="취소"></td>
			</tr>
		</table>
	</form>

</body>
</html>