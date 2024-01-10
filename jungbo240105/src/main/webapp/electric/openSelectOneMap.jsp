<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
.table1 tr:first-child {
	background: tan;
}

.table2 td:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>충전소 위치 상세보기</h3>
		
		<table border=1 class="table1">
			<tr>
				<td>지도확인</td>
				<td>상세보기</td>
				<td>메모</td>
			</tr>
			<tr>
				<td width=250px>
					<div id="map" style="width:100%;height:150px;"></div>
				</td>
				<td>
					<table border=1 class="table2">
						<tr>
							<td>순번</td>
							<td><input type=text name="idx" value="${m.idx}" ></td>
						</tr>
						<tr>
							<td>지역</td>
							<td><input type=text name="region" value="${m.region}" ></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type=text name="station" value="${m.station}" ></td>
						</tr>
						<tr>
							<td>위도</td>
							<td><input type=text name="latitude" value="${m.latitude}" ></td>
						</tr>
						<tr>
							<td>경도</td>
							<td><input type=text name="longitude" value="${m.longitude}" ></td>
						</tr>
					</table>
				</td>
				<td>
					<form action="memoInsert.do">
						<input type=hidden name=gangwonIdx value="${m.idx}" />
						<table border=1 class="table2">
							<tr>
								<td>작성자</td>
								<td><input type=text name=name ></td>
							</tr>
							<tr>
								<td>메모</td>
								<td><input type=text name=memo ></td>
							</tr>
							<tr>
								<td colspan=2><input type=submit value="메모저장" ></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<table border=1 class="table1" width=715>
			<tr>
				<td>idx</td><td>memo</td><td>name</td><td>today</td>
			</tr>
			<c:forEach items="${ memo }" var="m">
				<c:if test="${!empty m.idx }">
					<tr>
						<td>${m.idx}</td>
						<td>${m.memo}</td>
						<td>${m.name}</td>
						<td>${m.today}</td>
					</tr>
				</c:if>
				</c:forEach>
		</table>
		<br>
		<a href="electricList.do">목록</a>
		<a href="electricMap1.do">지도</a>
	</div>
	<br>
</section>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${keyValue}"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${m.latitude}, ${m.longitude}), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${m.latitude}, ${m.longitude}); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px;">${param.station}<br><a href="https://map.kakao.com/link/map/${param.station},${param.latitude},${param.longitude}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${param.station},${param.latitude},${param.longitude}" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(${m.latitude}, ${m.longitude}); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>

<c:import url="/include/bottom.jsp" />