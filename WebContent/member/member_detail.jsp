<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

</head>
<body>

	<form method="post">
		<table>
			<caption>마이 페이지</caption>					
			<tr>
				<td>
					<c:set var = "profile" value="${member.image}"></c:set>
					<c:if test="${empty profile}"><img src="./upload/profile.png" width=200px heigh=200px></c:if>
					<c:if test="${!empty profile}"><img src="./upload/${member.image}" width=200px heigh=200px></c:if>
				</td>
				<td>
					이름:  ${member.name}<br>
					생년월일: ${member.year}년 ${member.month}월 ${member.day}일<br>
					성별: ${member.gender}<br>
					이메일: ${member.mailid}@${member.domain}<br>
					핸드폰: ${member.phone1}-${member.phone2}-${member.phone3}<br>
					지역: ${member.local}<br>
					가입일: ${member.register}<br><br>
					<input type="button" value="회원 정보 수정" 
						onClick="location.href='<%=request.getContextPath()%>/MemberUpdateAction.do'">
					<input type="button" value="비밀번호 변경"
						onClick="location.href='<%=request.getContextPath()%>/MemberChangePWAction.do'">
					<input type="button" value="회원 탈퇴"
						onClick="location.href='<%=request.getContextPath()%>/MemberDeleteAction.do'">
				</td>
			</tr>
			</table>
			
			<table>	
				<tr><td colspan=2>내 모임 리스트</td></tr>
				<c:forEach var="mylist" items="${list}">
					<tr><td>
						<a href="./GatherDetailAction.do?no=${mylist.no}&page=1">
							${mylist.gather_name}
						</a>
					</td></tr>	
				</c:forEach>		
			</table>
	</form>

</body>
</html>