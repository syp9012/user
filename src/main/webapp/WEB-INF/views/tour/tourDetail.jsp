<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 검색</title>
</head>
<body>

<div> : ${tour.tour_images}</div>
<div>관광지명 : ${tour.tour_name}</div>
<div>홈페이지 주소 : ${tour.tour_url}</div>
<div>전화번호 : ${tour.tour_tel}</div>
<div>주소 : ${tour.tour_addr1}</div>



<h1>상세정보</h1>
<div>시군구 : ${tour.tour_city_name}</div>
<div>세부주소 : ${tour.tour_addr2}</div>
<div>우편번호 : ${tour.tour_zipcode}</div>
<div>상세내용 : ${tour.tour_desc}</div>
<div>유모차여부 : ${tour.tour_babycarry}</div>
<div>애완동물여부 : ${tour.tour_animal_able}</div>
<div>이용가능나이 : ${tour.tour_age_able}</div>
<div>세계문화유산유무 : ${tour.tour_heritage1}</div>
<div>세계자연유산유무 : ${tour.tour_heritage2}</div>
<div>세계기록유산유무 : ${tour.tour_heritage3}</div>
<div>문의및안내 : ${tour.tour_infocenter}</div>
<div>개장일 : ${tour.tour_open_date}</div>
<div>주차시설 : ${tour.tour_parking}</div>
<div>쉬는날 : ${tour.tour_dayoff}</div>
<div>이용시간 : ${tour.tour_usetime}</div>


<h1>지도 출력</h1>

<div id="map" style="width:500px;height:400px; text-align:center;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c14db14988057dc0387ab78d000e6d1d&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(${tour.tour_locy}, ${tour.tour_locx}), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 


var coords = new kakao.maps.LatLng(${tour.tour_locy}, ${tour.tour_locx});

// 결과값으로 받은 위치를 마커로 표시합니다
var marker = new kakao.maps.Marker({
    map: map,
    position: coords
});

// 인포윈도우로 장소에 대한 설명을 표시합니다
var infowindow = new kakao.maps.InfoWindow({
    content: '<div style="width:150px;text-align:center;padding:6px 0;">${tour.tour_name}</div>'
});
infowindow.open(map, marker);

// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
map.setCenter(coords);

</script>


</body>
</html>