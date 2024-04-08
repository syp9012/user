<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>캠핑장 검색</title>
<script>
// 상세정보 
function boardlist(page){
	$("#writeform").hide();
	$("#detail").hide();
	$("#updateform").hide();
	$("#deleteform").hide();
	
	$("#mytable").show();
	$("#pagination").show();
	
	$.ajax({
		type : "GET", // select 방식
		url : "${pageContext.request.contextPath}/campDetail.do?camp_no="++"&page="+page
	$("#write").show();
	$("#write").click(function(){
	});
}






</script>
<style type="text/css">
	.content {display:flex;}
</style>
</head>
<body>

<h1>캠핑장 정보</h1>
<div>
	<div class="content">
		<img src=${camp.camp_image}>
		<div>
			캠핑장명 : ${camp.camp_name}
			캠핑장 전화번호 : ${camp.camp_tel}
			캠핑장 홈페이지 주소 : ${camp.camp_url}
		</div>
	</div>
</div>	
	<div>캠핑장 소개</div><div>${camp.camp_open_season}</div>


<div class="bt_wrap">
	<a href="noticeList.do" class="on">목록</a>
	<a href="insertNoticeForm.do" class="on">글작성</a>
</div>


	
<div id="detail">
	<div>캠핑장 소개 : ${camp.camp_intro}</div>
	<div>캠핑장 상세소개 : ${camp.camp_desc}</div>
	<div>캠핑장 전체면적 : ${camp.camp_scale}</div>
	<div>캠핑장 보험가입유무 : ${camp.camp_insurance}</div>
	<div>캠핑장 사업주체 : ${camp.camp_owner}</div>
	<div>캠핑장 휴무기간 시작일 : ${camp.camp_dayoff_start}</div>
	<div>캠핑장 휴무기간 종료일 : ${camp.camp_dayoff_end}</div>
	<div>캠핑장 특징 : ${camp.camp_feature}</div>
	<div>캠핑장 업종 : ${camp.camp_type}</div>
	<div>캠핑장 입지구분 : ${camp.camp_nature_type}</div>
	<div>캠핑장 도 : ${camp.camp_do_name}</div>
	<div>캠핑장 시군구 : ${camp.camp_city_name}</div>
	<div>캠핑장 우편번호 : ${camp.camp_zipcode}</div>
	<div>캠핑장 주소 : ${camp.camp_addr1}</div>
	<div>캠핑장 상세주소 : ${camp.camp_addr2}</div>
	
	
	<div>캠핑장 예약페이지 주소 : ${camp.camp_reserve_url}</div>
	<div>캠핑장 예약 구분 : ${camp.camp_reserve_type}</div>
	<div>캠핑장 일반야영장 : ${camp.camp_normal_no}</div>
	<div>캠핑장 자동차야영장 개수 : ${camp.camp_car_no}</div>
	<div>캠핑장 글램핑장 개수 : ${camp.camp_glamp_no}</div>
	<div>캠핑장 카라반 개수 : ${camp.camp_carav_no}</div>
	<div>캠핑장 글램핑 내부시설 : ${camp.camp_glamp_inner_fclty}</div>
	<div>캠핑장 카라반 내부시설 : ${camp.camp_carav_inner_fclty}</div>
	
	<div>캠핑장 운영일 : ${camp.camp_open_date}</div>
	<div>캠핑장 화장실 개수 : ${camp.camp_toilet_no}</div>
	<div>캠핑장 샤워장 개수 : ${camp.camp_shower_no}</div>
	<div>캠핑장 개수대 개수 : ${camp.camp_sink_no}</div>
	<div>캠핑장 부대시설 : ${camp.camp_add_fclty}</div>
	<div>캠핑장 주변이용가능시설 : ${camp.camp_able_fclty}</div>
	<div>캠핑장 캠핑장비대여 : ${camp.camp_equip_rent}</div>
	<div>캠핑장 애완동물출입 : ${camp.camp_able_animal}</div>
</div>







<div id="map" style="width:500px;height:400px; text-align:center;"></div>



<h1>지도 출력</h1>

<div id="map" style="width:500px;height:400px; text-align:center;"></div>


<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(${camp.camp_locy}, ${camp.camp_locx}), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 


var coords = new kakao.maps.LatLng(${camp.camp_locy}, ${camp.camp_locx});

// 결과값으로 받은 위치를 마커로 표시합니다
var marker = new kakao.maps.Marker({
    map: map,
    position: coords
});

// 인포윈도우로 장소에 대한 설명을 표시합니다
var infowindow = new kakao.maps.InfoWindow({
    content: '<div style="width:150px;text-align:center;padding:6px 0;">${camp.camp_name}</div>'
});
infowindow.open(map, marker);

// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
map.setCenter(coords);
 
  


</script>


</body>
</html>