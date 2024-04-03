<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- 슬릭 라이브러리 임포트 -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId="></script>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장 검색</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<script src="<%=request.getContextPath()%>/js/main.js"></script>
</head>
<body>
<div class="header-inner">
	
	<div class="navbarmenu-wrap">
		<h1>
			<a href="recommend.do">
				<img src="/img/logo_gr01.png" style="width:140px;">
			</a>
		</h1>
		<div>
		<a href="">회원가입  </a>
		<a href="">로그인  </a>
		
		</div>
		
		<nav class="navbarmenu-container">
			<ul class="menu-list">
				<li class="depth1">
					<a href="">캠핑장검색</a>
					<ul class="dropdown-content">
						<li>
							<a href="">캠핑장검색</a>
						<li>
					</ul>
				</li>
				<li class="depth1">
					<a href="">관광지검색</a>
					<ul class="dropdown-content">
						<li>
							<a href="">"관광지검색"</a>
						<li>
					</ul>
				</li>
				<li class="depth1">
					<a href="">날씨조회</a>
					<ul class="dropdown-content">
						<li>
							<a href="">날씨조회</a>
						<li>
					</ul>
				</li>
				<li class="depth1">
					<a href="">공지사항</a>
					<ul class="dropdown-content">
						<li>
							<a href="">공지사항</a>
						<li>
					</ul>
				</li>
		</nav>
	</div>


<h1>상세정보</h1>
${tour.tour_id}
${tour.tour_name}
${tour.tour_url}
${tour.tour_tel}
${tour.tour_city_name}
${tour.tour_addr1}
${tour.tour_addr2}
${tour.tour_zipcode}

${tour.tour_desc}
${tour.tour_babycarry}
${tour.tour_animal_able}
${tour.tour_age_able}
${tour.tour_heritage1}
${tour.tour_heritage2}
${tour.tour_heritage3}
${tour.tour_infocenter}
${tour.tour_open_date}
${tour.tour_parking}
${tour.tour_dayoff}
${tour.tour_usetime}
${tour.tour_images}



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