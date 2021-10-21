<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>
	$(document).ready(function(){
		$("form").submit(function(){
			if($("#id").val()==""){
				alert("아이디을 입력하세요.");
				$("#id").focus();
				return false;
			}
			if($("#mailid").val()==""){
				alert("이메일 아이디를 입력하세요.");
				$("#mailid").focus();
				return false;
			}
			if($("#domain").val()==""){
				alert("이메일 도메인을 입력하세요.");
				$("#domain").focus();
				return false;
			}
		}); // submit end
		
		// 도메인 선택
		$("#email").change(function(){
			if($("#email").val() == ""){	// 직접 입력 선택	
//				$("#domain").attr("readonly", false);
				$("#domain").removeAttr("readonly");
				$("#domain").val("").focus();			
			}else{							// 도메인명 선택
				$("#domain").val($("#email").val());
			    $("#domain").attr("readonly","readonly");
			}
		}); // change end		
	});	// ready end
</script>

</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/MemberFindPW.do">
		<table>
			<tr>
				<th colspan=2>비밀번호 찾기</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type=text id="id" name="id" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type=text size=10 id="mailid" name="mailid"> @
					<input type=text size=10 id="domain" name="domain">
					<select id="email">
						<option value="">직접 입력</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="gmail.com">지메일</option>
						<option value="nate.com">네이트</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		
		</table>
	
	</form>


</body>
</html>