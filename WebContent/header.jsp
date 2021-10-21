<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>

</style>

<link rel="stylesheet" href="<%=request.getContextPath()%>/header.css">

</head>
<body>
		<header>
			<div class="head">
				<nav>
					<ul class="loginfo-container">
						<c:if test="${sessionScope.id != null }">
							<li class="loginfo-item"><a href="<%=request.getContextPath()%>/MemberDetail.do"> 마이 페이지 </a></li> <br><br>
							<li class="loginfo-item"><a href="<%=request.getContextPath()%>/Logout.do"> 로그아웃 </a></li> <br><br>
						</c:if>
						<c:if test="${sessionScope.id == null }">
							<li class="loginfo-item"><a href="<%=request.getContextPath()%>/MemberForm.do">회원가입</a></li> <br><br>
							<li class="loginfo-item"><a href="<%=request.getContextPath()%>/LoginForm.do">로그인</a></li> <br><br>
						</c:if>					
					</ul>
				</nav>
				<nav>
					<ul class="nav-container">
						<li class ="nav-itemImg"><a href="<%=request.getContextPath()%>index.jsp"><img src="<%=request.getContextPath()%>/image/title.png" style="padding:10px; padding-left:40px;"></a></li>			
						<li class="nav-item"><a href="<%=request.getContextPath()%>/GetCosList.do">등산페이지</a> </li>
						<li class="nav-item"><a href="<%=request.getContextPath()%>/GatherList.do">모임게시판</a> </li>
					</ul>
				</nav>
			 </div>
		</header>
</body>
</html>