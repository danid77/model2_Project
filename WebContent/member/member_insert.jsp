<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="../header.jsp" %>

<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="<%=request.getContextPath()%>/member/membercheck.js"></script>

</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/MemberInsert.do" enctype="multipart/form-data">
		<table class="type">
			<caption>회원 가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type=text autofocus="autofocus" id="id" name="id">
					<input type=button value="중복 검사" id="idcheck">
					<div id="myid"></div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type=password id="passwd" name="passwd"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type=password id="passwd_check" name="passwd_check"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type=text id="name" name="name"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type=text size=4 maxlength=4 id="year" name="year"
						placeholder="년도(4자)"> 
					<select id="month" name="month">
						<option value="">월</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> 
					<input type="text" id="day" name="day" placeholder="일">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type=radio id="male" name="gender" value="남자">남자
					<input type=radio id="female" name="gender" value="여자">여자</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type=text size=10 id="mailid" name="mailid">
					@ <input type=text size=10 id="domain" name="domain"> <select
					id="email">
						<option value="">직접 입력</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="gmail.com">지메일</option>
						<option value="nate.com">네이트</option>
				</select></td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td><select id="phone1" name="phone1">
						<option value="">번호 선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="018">018</option>
						<option value="019">019</option>
				</select> - <input type=text size=4 id="phone2" name="phone2" maxlength=4>
					- <input type=text size=4 id="phone3" name="phone3" maxlength=4>
				</td>
			</tr>
			<tr>
				<th>지역</th>
				<td><select id="local" name="local">
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
				<th>프로필 이미지 *선택</th>
				<td><label class="button" for="image" >업로드</label><input type="file" id="image" name="image"style="display:none"></td>
			</tr>
			<tr>
				<td align="center" colspan="5"><input type=submit value="가입" >
			</tr>
		</table>
	</form>


</body>
</html>