<%--
  Created by IntelliJ IDEA.
  User: byeon
  Date: 2021-10-13
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/gathering_table.css">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="/cos/reply.js"></script>
<title>등산코스 페이지</title>

</head>
<body>
	<jsp:include page="/header.jsp" flush="true" />
	<table class="type">
		<caption>${cosInfo.cosName}</caption>
		<tr>
			<td colspan="2">
				<div id="map" style="width: 500px; height: 400px;"></div> <script
					type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4f2288fb9ad2f5f8a631f9dd4490a2ff">
            </script> 
            <script>
                var container = document.getElementById('map');
                var options = {
                    center: new kakao.maps.LatLng(${cosInfo.cosLatitude}, ${cosInfo.cosLongitude}),
                    level: 7
                };
                
                var map = new kakao.maps.Map(container, options);

                // 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다
                var positions = [];
                </script>                   
                


 				<script type="text/javascript" src="<%=request.getContextPath()%>/cos/cos2.js"></script>
<%-- 				<script type="text/javascript" src="<%=request.getContextPath()%>/cos/cos3.js"></script>  --%>
           
           <script type="text/javascript">
                // 지도에 표시할 선을 생성합니다
                var polyline = new kakao.maps.Polyline({
                    path: linePath2, // 선을 구성하는 좌표배열 입니다
                    strokeWeight: 5, // 선의 두께 입니다
                    strokeColor: '#FFAE00', // 선의 색깔입니다
                    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle: 'solid' // 선의 스타일입니다
                });

                // 지도에 선을 표시합니다 
                polyline.setMap(map);  
                </script>
                
                <script type="text/javascript" src="<%=request.getContextPath()%>/cos/cos3.js"></script> 
                
                <script type="text/javascript">
                     // 지도에 표시할 선을 생성합니다
                     var polyline = new kakao.maps.Polyline({
                         path: linePath3, // 선을 구성하는 좌표배열 입니다
                         strokeWeight: 5, // 선의 두께 입니다
                         strokeColor: '#FFAE00', // 선의 색깔입니다
                         strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                         strokeStyle: 'solid' // 선의 스타일입니다
                     });

                     // 지도에 선을 표시합니다 
                     polyline.setMap(map);
                


                positions.push({
                    content: '<div>헬기 착륙장</div>',
                    latlng: new kakao.maps.LatLng(33.450705, 126.570677)
                })


                for (var i = 0; i < positions.length; i++) {
                    // 마커를 생성합니다
                    var marker = new kakao.maps.Marker({
                        map: map, // 마커를 표시할 지도
                        position: positions[i].latlng // 마커의 위치
                    });

                    // 마커에 표시할 인포윈도우를 생성합니다
                    var infowindow = new kakao.maps.InfoWindow({
                        content: positions[i].content // 인포윈도우에 표시할 내용
                    });

                    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                    // 이벤트 리스너로는 클로저를 만들어 등록합니다
                    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                }

                // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
                function makeOverListener(map, marker, infowindow) {
                    return function () {
                        infowindow.open(map, marker);
                    };
                }

                // 인포윈도우를 닫는 클로저를 만드는 함수입니다
                function makeOutListener(infowindow) {
                    return function () {
                        infowindow.close();
                    };
                }
            </script>
			</td>
		</tr>
		<tr>
			<th>난이도</th>
			<td>${cosInfo.cosDifficulty}</td>
		</tr>
		<tr>
			<th>길이</th>
			<td>${cosInfo.cosLength}</td>
		</tr>
		<tr>
			<th>소요 시간</th>
			<td>${cosInfo.cosTakeTime}</td>
		</tr>
		<tr>
			<th>길찾기</th>
			<td><a href="${cosInfo.cosLink}">길찾기</a></td>
		</tr>

	</table>

	<table class="type" width="800px">
		<caption>맛집 & 명소 목록</caption>
		<tr>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>운영 시간</th>
			<th>교통편</th>
		</tr>
		<c:forEach var="foodandplace" items="${list}">
			<tr>
				<td>${foodandplace.name}</td>
				<td>${foodandplace.tel}</td>
				<td>${foodandplace.address}</td>
				<td>${foodandplace.time}</td>
				<td>${foodandplace.trans}</td>
			</tr>

		</c:forEach>
	</table>
	<br>
	<br>
	
	<div>
		<div class="w3-border_w3-padding" align="center" font-family="Sans-Serif">댓글</div>
		<div class="w3-border_w3-padding" align="center" font-family="Sans-Serif">
			
			<c:if test="${ id == null }">
					<textarea align="center" rows="5" cols="50" class="w3-input w3-border newLogin" readonly>로그인 후 댓글 달기</textarea>
			</c:if>
			
			<c:if test="${ id != null }">
				<i class="fa fa-user w3-padding-16"></i> ${ id }
            	
            	<form>
					<input type="hidden" name="cos_name" id="cos_name"
						value="${ cosInfo.cosName }">
						<input type="hidden" name="id" id="id" value="${ id }">
					<textarea align="center" rows="5" cols="50" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
					<input type="button" class="w3-button w3-border" id="reply_btn" value="댓글 등록">
				
				</form>
			</c:if>
			<%--    <script src="/cos/reply.js"></script>--%>

		</div>
		<div>
			<div class="w3-border_w3-padding" align="center" font-family="Sans-Serif">
				댓글목록(<i class="fa fa-commenting-o" align="center" font-family="Sans-Serif"></i> <span class="reply_count" align="center" font-family="Sans-Serif"></span>)
			</div>
			<div id="replyList" align="center" font-family="Sans-Serif"></div>
		</div>
	</div>


</body>
</html>
