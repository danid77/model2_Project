<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>gathering Write</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 	<script src="<%=request.getContextPath()%>/gathering/gather.js"></script>	-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
</head>
<body>
	<form action="<%=request.getContextPath()%>/GatherDelete.do"
		method="post">
		<input type="hidden" name="no" value="${param.no}"> <input
			type="hidden" name="page" value="${param.page}">
		<!--  <h2 align="center">Santago 등산모임 게시판 삭제</h2> -->

		<table class="type">
			<!-- <tr align="center" valign="middle">
		<td colspan="5">등산모임 게시판</td>
	</tr> -->

			<tr>
				<th>모임 비밀번호</th>
				<td><input name="gatherpw" id="gatherpw" type="password"
					size="10" maxlength="10" value="" /></td>
			</tr>

			<tr>
				<td colspan="2" style="height: 1px;"></td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><input type=submit value="삭제"> <input
					type=reset value="취소"></td>
			</tr>
		</table>
	</form>

</body>
</html>