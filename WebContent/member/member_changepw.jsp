<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 외부 자바스크립트 파일 불러오기 -->
<%-- <script src="<%=request.getContextPath()%>/member/membercheck.js"></script> --%>

<script>
// 비밀번호 유효성 검사
$(document).ready(function(){
	$("form").submit(function(){
		
		if($("#passwd_old").val() == ""){
			alert("현재 비밀번호를 입력하세요.");
			$("#passwd_old").focus();
			return false;
		}	
		if($("#passwd_new").val()==""){
			alert("새 비밀번호를 입력하세요.");
			$("#passwd_new").focus();
			return false;
		}
		if($("#passwd_new_check").val()==""){
			alert("새 비밀번호 확인을 입력하세요.");
			$("#passwd_new_check").focus();
			return false;
		}
		if($("#passwd_new_check").val() != $("#passwd_new").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#passwd_new_check").focus();
			return false;
		}
		if($("#passwd_new").val() == $("#passwd_old").val()){
			alert("새 비밀번호가 현재 비밀번호와 같습니다. 새로운 비밀번호를 입력해주세요.");
			$("#passwd_new").val("").focus();
			$("#passwd_new_check").val("");
			return false;
		}		
	});
	
	//비밀번호 정규식 검사 : 영문자+숫자+특수조합(8~25자리 입력)
	$("#passwd_new").focusout(function(){
		var passwdtype = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
		if($("#passwd_new").val() != ""){
			  
			if (!passwdtype.test(passwd_new.value)) {
				alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~12자리를 입력해주세요.");
			$("#passwd_new").val("").focus();
			return false;
			}
		}
	});
});

</script>


</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/MemberChangePW.do">
	<input type="hidden" name="id" value="${member.id}">
	<table class="type">
		<caption>비밀번호 변경</caption>
		
		<tr><td align="center"><input type="password" id="passwd_old" name="passwd_old" placeholder="현재 비밀번호"></td></tr>
		<tr><td align="center"><input type="password" id="passwd_new" name="passwd_new" placeholder="새 비밀번호"></td></tr>
		<tr><td align="center"><input type="password" id="passwd_new_check" name="passwd_new_check" placeholder="새 비밀번호 확인"></td></tr>
	
		<tr><td align="center"><input type="submit" value="변경"></td></tr>
	</table>
	</form>
</body>
</html>