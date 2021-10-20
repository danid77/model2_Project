<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="<%=request.getContextPath()%>/member/logincheck.js"></script>

</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/MemberLogin.do">
		<table>
			<caption>로그인</caption>
			<tr align=center>
				<td><input type=text size=30 id="id" name="id"
					autofocus="autofocus" placeholder="아이디"></td>
			</tr>
			<tr align=center>
				<td><input type="password" size=30 id="passwd" name="passwd"
					placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"><br>
				</td>
			</tr>
		</table>
		<div class="login_bottom">
			<a href="<%=request.getContextPath()%>/MemberFindIDAction.do">아이디 찾기</a> | <a href="<%=request.getContextPath()%>/MemberFindPWActioin.do">비밀번호 찾기</a> | <a href="<%=request.getContextPath()%>/MemberForm.do">회원가입</a>
		</div>
	</form>

</body>
</html>