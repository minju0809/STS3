<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="/include/top.jsp" />

<style>
th {
	background: tan;
}

table input {
	width: 96%;
}

td:last-child {
	text-align: center;
}

</style>

<section>
	<br>
	<div align=center>
		<h3>캠핑장 상세보기</h3>
		
		<table border=1>
			<tr>
				<td colspan=6>
					<div id="map" style="width:100%;height:300px;"></div>
				</td>
			</tr>
			<tr>
				<th>캠핑장이름</th>
				<td><input type=text name="campsite" value="${m.campsite}" ></td>
				<th>번호</th>
				<td><input type=text name="tel" value="${m.tel}" ></td>
				<th>오픈</th>
				<td><input type=text name="tel" value="${m.open}" ></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan=3><input type=text name="address" value="${m.address}" ></td>
				<th>마감</th>
				<td><input type=text name="tel" value="${m.close}" ></td>
			</tr>
			<tr>
				<th>홈페이지</th>
				<td colspan=3><input type=text name="tel" value="${m.homepage}" ></td>
				<th>펫유무</th>
				<td><input type=text name="tel" value="${m.pet}" ></td>
			</tr>
			<tr>
				<th>면적</th>
				<td><input type=text name="tel" value="${m.area}" ></td>
				<th>주차</th>
				<td><input type=text name="tel" value="${m.parking}" ></td>
				<th>총 인원</th>
				<td><input type=text name="tel" value="${m.people}" ></td>
			</tr>
			<tr>
				<th>상세설명</th>
				<td colspan=3><textarea cols="50" rows="5">${m.etc}</textarea></td>
				<th>예약</th>
				<td><input type=text name="tel" value="${m.reservation}" ></td>
			</tr>
		</table>
		<br>
		<a href="campsiteList.do">캠핑장 목록</a>
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
    { address: '${m.address}', name: '${m.campsite}' }
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