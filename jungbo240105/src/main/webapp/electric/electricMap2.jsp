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
		<div id="map" style="width:100%;height:350px;"></div>
	</div>
	<br>
</section>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${keyValue}&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.51541335, 127.7297758), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 영등포구 경인로 846 (영등포동 618-496)', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">영등포역</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>

<c:import url="/include/bottom.jsp" />