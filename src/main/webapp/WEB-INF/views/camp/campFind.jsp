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



</body>
</html>