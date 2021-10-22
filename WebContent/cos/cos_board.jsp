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
<script src="<%=request.getContextPath()%>/cos/comment.js"></script>
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
            </script> <script>
                var container = document.getElementById('map');
                var options = {
                    center: new kakao.maps.LatLng(${cosInfo.cosLatitude}, ${cosInfo.cosLongitude}),
                    level: 6
                };
                
                var map = new kakao.maps.Map(container, options);

                // 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다
                var positions = [];
                </script> <script type="text/javascript"
					src="<%=request.getContextPath()%>/cos/cos2.js"></script>

				<script type="text/javascript">
                // 지도에 표시할 선을 생성합니다
                var polyline = new kakao.maps.Polyline({
                    path: linePath2, // 선을 구성하는 좌표배열 입니다
                    strokeWeight: 5, // 선의 두께 입니다
                    strokeColor: 'green', // 선의 색깔입니다
                    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle: 'solid' // 선의 스타일입니다
                });

                // 지도에 선을 표시합니다 
                polyline.setMap(map);  
                </script> 
                
                
                <script type="text/javascript"
					src="<%=request.getContextPath()%>/cos/cos3.js"></script> 
					<script
					type="text/javascript">
                     // 지도에 표시할 선을 생성합니다
                     var polyline = new kakao.maps.Polyline({
                         path: linePath3, // 선을 구성하는 좌표배열 입니다
                         strokeWeight: 5, // 선의 두께 입니다
                         strokeColor: 'red', // 선의 색깔입니다
                         strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                         strokeStyle: 'solid' // 선의 스타일입니다
                     });

                     // 지도에 선을 표시합니다 
                     polyline.setMap(map);
                     </script>
                     
                     <script type="text/javascript" src="<%=request.getContextPath()%>/cos/cos4.js"></script>
				<script type="text/javascript">
                     // 지도에 표시할 선을 생성합니다
                     var polyline = new kakao.maps.Polyline({
                         path: linePath4, // 선을 구성하는 좌표배열 입니다
                         strokeWeight: 5, // 선의 두께 입니다
                         strokeColor: 'darkblue', // 선의 색깔입니다
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

	<!-- 댓글 부분 -->
	<div id="comment">
		<table class="type" style="align: center;">
			<!-- 댓글 목록 -->
			<c:if test="${requestScope.commentList != null}">
				<c:forEach var="comment" items="${requestScope.commentList}">

					<tr>
						<!-- 아이디, 작성날짜 -->
						<th width="150">
							<div>
								<c:if test="${comment.comment_level > 1}">
                                &nbsp;&nbsp;&nbsp;&nbsp; 답글<!-- 답변글일경우 아이디 앞에 공백을 준다. -->
								</c:if>


								${comment.comment_id}<br> <font size="2">
									${comment.comment_date}</font>
							</div>
						</th>
						<!-- 본문내용 -->
						<td width="550" style="">
							<div class="text_wrapper">${comment.comment_content}</div>
						</td>
						<!-- 버튼 -->
						<th width="100" style="font-size: 5px;">
							<div id="btn" style="text-align: center; font-size: 15px;">
								<a href="#" onclick="cmReplyOpen(${comment.comment_num})">[답변]</a><br>
								<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
								<c:if test="${comment.comment_id == sessionScope.id}">
									<a href="#" onclick="cmUpdateOpen(${comment.comment_num})">[수정]</a>
									<br>
									<a href="#" onclick="cmDeleteOpen(${comment.comment_num})">[삭제]</a>
								</c:if>
							</div>
						</th>
					</tr>

				</c:forEach>
			</c:if>

			<!-- 로그인 했을 경우만 댓글 작성가능 -->
			<c:if test="${sessionScope.id !=null}">
				<tr>
					<form id="writeCommentForm">
						<input type="hidden" name="comment_board"
							value="${cosInfo.cosName}"> <input type="hidden"
							name="comment_id" value="${sessionScope.id}">
						<!-- 아이디-->
						<th width="150">
							<div>${sessionScope.id}</div>
						</th>
						<!-- 본문 작성-->
						<td width="550"><textarea name="comment_content" rows="4"
								cols="70"></textarea></td>
						</th>
						<!-- 댓글 등록 버튼 -->
						<th width="100">
							<div id="btn" style="text-align: center;">
								<p>
									<a href="#" onclick="writeCmt()">[댓글등록]</a>
								</p>
							</div>
						</th>
					</form>
				</tr>
			</c:if>

		</table>
	</div>


</body>
</html>
