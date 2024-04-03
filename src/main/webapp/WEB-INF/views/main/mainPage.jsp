<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- 슬릭 라이브러리 임포트 -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
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
		<div id=user_login_join align="right">
			<a href="user_login.do" style="text-decoration-line:none; color: black">회원가입  </a>
			<a href="user_join.do" style="text-decoration-line:none; color: black">로그인  </a>
		
		</div>
		<nav class="navbarmenu-container" >
			<ul class="menu-list" >
				<li class="depth1">
					<a href="/campFind.do">캠핑장검색</a>
					<ul class="dropdown-content">
						<li>
							<a href="campFind.do">캠핑장검색</a>
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



</div>
<h2>내일의 캠핑장 추천</h2>

<div class="slider">
	<c:forEach var="camp" items="${campList}">
		<div class="slide" style="text-align: center;">
			<c:if test="${not empty camp.camp_image}">
				<a href="campDetail.do?camp_no=${camp.camp_no}"><img src="${camp.camp_image}"></a>   /><br>
				${camp.camp_name} <br>
				${camp.camp_do_name}&nbsp;${camp.camp_city_name}
			</c:if>
		</div>
	</c:forEach>
</div>
<h2>내일의 관광지 추천</h2>
<div class="slider">
	<c:forEach var="tour" items="${tourList}">
		<c:if test="${not empty tour.tour_image1}">
			<div class="slide" style="text-align: center;">
				<a href="tourDetail.do?tour_id=${tour.tour_id}"><img src="${tour.tour_image1}" /></a> <br>
				${tour.tour_name}<br>
				${tour.tour_addr1st}&nbsp;${tour.tour_addr2nd}
			</div>
		</c:if>	
	</c:forEach>
</div>


</body>
</html>