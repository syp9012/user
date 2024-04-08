<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>메인 페이지</title>
</head>
<body>


	<form id="search" name="search" action=".do">
		<div>
			<div>검색어</div>
			<div><input type="text" name="search_word" id="search_word"></div>
			
			<div>
				<select name="CampOrTour" id="CampOrTour">
					<option value="camp">캠핑장</option>
					<option value="tour">관광지</option>
				</select>
				<select name="do_name" id="do_name"></select>
				<select name="city_name" id="city_name"></select>
		</div>
		<input type="submit" value="검색"/>
	</form>


<h2>오늘의 캠핑장 추천</h2>

<div class="autoplay">
	<c:forEach var="camp" items="${campList}">
		<div style="text-align:center;">
			<c:if test="${not empty camp.camp_image}">
				<a href="campDetail.do?camp_no=${camp.camp_no}"><img src="${camp.camp_image}" style="width:500px; heigth 500px;"></a><br>
				${camp.camp_name} <br>
				${camp.camp_do_name}&nbsp;${camp.camp_city_name}
			</c:if>
		</div>
	</c:forEach>
</div>
<h2>오늘의 관광지 추천</h2>

<div class="autoplay">
	<c:forEach var="tour" items="${tourList}">
		<c:if test="${not empty tour.tour_image1}">
			<div style="text-align:center;">
				<a href="tourDetail.do?tour_id=${tour.tour_id}"><img src="${tour.tour_image1}"  style="width:500px; heigth 500px;" /></a> <br>
				${tour.tour_name}<br>
				${tour.do_name}&nbsp;${tour.city_name}
			</div>
		</c:if>	
	</c:forEach>
</div>


<div class="notice">
	





</div>




</body>
</html>