<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/gathering_table.css">
	<%@ include file="/header.jsp" %>
<!-- 외부 자바스크립트 파일 불러오기 -->
<script src="<%=request.getContextPath()%>/member/membercheck.js"></script>

</head>
<body>

	<form method="post" action="<%=request.getContextPath()%>/MemberUpdate.do" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${member.id}">
		<table class="type">
			<caption>회원 정보 수정</caption>
			<tr>
				<th>아이디</th>
				<td>${member.id}</td>
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
				<td><input type=text id="name" name="name" value="${member.name}"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type=text size=4 maxlength=4 id="year" name="year"
						placeholder="년도(4자)" value="${member.year}"> 
					<select id="month" name="month">
						<option value="" >월</option>
						<option value="01" <c:if test="${member.month==01}">${'selected'}</c:if> >1</option>
						<option value="02" <c:if test="${member.month==02}">${'selected'}</c:if> >2</option>
						<option value="03" <c:if test="${member.month==03}">${'selected'}</c:if> >3</option>
						<option value="04" <c:if test="${member.month==04}">${'selected'}</c:if> >4</option>
						<option value="05" <c:if test="${member.month==05}">${'selected'}</c:if> >5</option>
						<option value="06" <c:if test="${member.month==06}">${'selected'}</c:if> >6</option>
						<option value="07" <c:if test="${member.month==07}">${'selected'}</c:if> >7</option>
						<option value="08" <c:if test="${member.month==08}">${'selected'}</c:if> >8</option>
						<option value="09" <c:if test="${member.month==09}">${'selected'}</c:if> >9</option>
						<option value="10" <c:if test="${member.month==10}">${'selected'}</c:if> >10</option>
						<option value="11" <c:if test="${member.month==11}">${'selected'}</c:if> >11</option>
						<option value="12" <c:if test="${member.month==12}">${'selected'}</c:if> >12</option>
					</select> 
					<input type="text" id="day" name="day" placeholder="일" value="${member.day}">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<c:if test="${member.gender == '남자' }">	
						<input type=radio id="male" name="gender" value="남자" checked> 남자
						<input type=radio id="female" name="gender" value="여자">여자
					</c:if>	
					<c:if test="${member.gender == '여자' }">	
						<input type=radio id="male" name="gender" value="남자"> 남자
						<input type=radio id="female" name="gender" value="여자" checked>여자
					</c:if>	
		</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type=text size=10 id="mailid" name="mailid" value="${member.mailid}">
					@ <input type=text size=10 id="domain" name="domain" value="${member.domain}"> 
					<select id="email">
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
					<option value="">번호선택</option>				
					<option value="010" <c:if test="${member.phone1=='010'}">${'selected'}</c:if> >010</option>
					<option value="011" <c:if test="${member.phone1=='011'}">${'selected'}</c:if> >011</option>				
					<option value="016" <c:if test="${member.phone1=='016'}">${'selected'}</c:if> >016</option>				
					<option value="018" <c:if test="${member.phone1=='018'}">${'selected'}</c:if> >018</option>	
					<option value="019" <c:if test="${member.phone1=='019'}">${'selected'}</c:if> >019</option>
				</select> - <input type=text size=4 id="phone2" name="phone2" maxlength=4 value="${member.phone2}">
					- <input type=text size=4 id="phone3" name="phone3" maxlength=4 value="${member.phone3}">
				</td>
			</tr>
			<tr>
				<th>지역</th>
				<td><select id="local" name="local">
						<option value="">지역 선택</option>
						<option value="강남구" <c:if test="${member.local=='강남구'}">${'selected'}</c:if> >강남구</option>
						<option value="강동구" <c:if test="${member.local=='강동구'}">${'selected'}</c:if>>강동구</option>
						<option value="강북구" <c:if test="${member.local=='강북구'}">${'selected'}</c:if>>강북구</option>
						<option value="관악구" <c:if test="${member.local=='관악구'}">${'selected'}</c:if>>관악구</option>
						<option value="광진구" <c:if test="${member.local=='광진구'}">${'selected'}</c:if>>광진구</option>
						<option value="구로구" <c:if test="${member.local=='구로구'}">${'selected'}</c:if>>구로구</option>
						<option value="금천구" <c:if test="${member.local=='금천구'}">${'selected'}</c:if>>금천구</option>
						<option value="노원구" <c:if test="${member.local=='노원구'}">${'selected'}</c:if>>노원구</option>
						<option value="도봉구" <c:if test="${member.local=='도봉구'}">${'selected'}</c:if>>도봉구</option>
						<option value="동대문구" <c:if test="${member.local=='동대문구'}">${'selected'}</c:if>>동대문구</option>
						<option value="동작구" <c:if test="${member.local=='동작구'}">${'selected'}</c:if>>동작구</option>
						<option value="마포구" <c:if test="${member.local=='마포구'}">${'selected'}</c:if>>마포구</option>
						<option value="서대문구" <c:if test="${member.local=='서대문구'}">${'selected'}</c:if>>서대문구</option>
						<option value="서초구" <c:if test="${member.local=='서초구'}">${'selected'}</c:if>>서초구</option>
						<option value="성동구" <c:if test="${member.local=='성동구'}">${'selected'}</c:if>>성동구</option>
						<option value="성북구" <c:if test="${member.local=='성북구'}">${'selected'}</c:if>>성북구</option>
						<option value="송파구" <c:if test="${member.local=='송파구'}">${'selected'}</c:if>>송파구</option>
						<option value="양천구" <c:if test="${member.local=='양천구'}">${'selected'}</c:if>>양천구</option>
						<option value="영등포구" <c:if test="${member.local=='영등포구'}">${'selected'}</c:if>>영등포구</option>
						<option value="용산구" <c:if test="${member.local=='용산구'}">${'selected'}</c:if>>용산구</option>
						<option value="은평구" <c:if test="${member.local=='은평구'}">${'selected'}</c:if>>은평구</option>
						<option value="종로구" <c:if test="${member.local=='종로구'}">${'selected'}</c:if>>종로구</option>
						<option value="중구" <c:if test="${member.local=='중구'}">${'selected'}</c:if>>중구</option>
						<option value="중랑구" <c:if test="${member.local=='중랑구'}">${'selected'}</c:if>>중랑구</option>
				</select></td>
			</tr>
			<tr>
				<th>프로필 이미지</th>
				<td><label class="button" for="image" >업로드</label><input type="file" id="image" name="image" style="display:none"></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type=submit value="수정">
					<input type=reset value="취소"></td>
			</tr>
		</table>
	</form>


</body>
</html>