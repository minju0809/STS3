<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<div id="map" style="width:100%;height:500px;"></div>
		<table border=1>
			<tr>
				<td>순번</td>
				<td>캠핑장이름</td>
				<td>주소</td>
				<td>번호</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="moccasin" />	
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="lemonchiffon" />
				</c:if>
					<tr bgcolor="${ bgcolor }">
						<td>${ m.idx }</td>
						<td><a href="${path}/campsiteOne.do?idx=${m.idx}">${ m.campsite }</a></td>
						<td>${ m.address }</td>
						<td>${ m.tel }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</section>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${keyValue}&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.5591088, 126.97089395), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

var locations = [
    <c:forEach items="${li}" var="m" varStatus="status">
        { address: '<c:out value="${m.address}" />', name: '<c:out value="${m.campsite}" />' }
        <c:if test="${!status.last}">,</c:if>
    </c:forEach>
];

for (var i = 0; i < locations.length; i++) {
    searchAddress(locations[i]);
}

function searchAddress(location) {
// 주소로 좌표를 검색합니다
	geocoder.addressSearch(location.address, function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + location.name + '</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	}); 
}
</script>

<c:import url="/include/bottom.jsp" />