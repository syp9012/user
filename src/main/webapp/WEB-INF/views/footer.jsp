<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- JS -->
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

	
	
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />

<body>
<div class="header-inner">
	
	<nav class="navbarmenu-wrap">
		<h1>
			<a href="main.do">
				<img src="/img/logo_gr01.png" style="width:140px;">
			</a>
		</h1>
		<div id=user_login_join align="right">
			<a href="user_login.do" style="text-decoration-line:none; color: black">회원가입  </a>
			<a href="user_join.do" style="text-decoration-line:none; color: black">로그인  </a>
		
		</div>
		<div class="navbarmenu-container" >
			<ul class="menu-list" >
				<li class="depth1">
					<a href="campSearch.do">캠핑장검색</a>
					<ul class="dropdown-content">
						<li>
							<a href="campSearch.do">캠핑장검색</a>
						<li>
					</ul>
				</li>
				<li class="depth1">
					<a href="tourSearch.do">관광지검색</a>
					<ul class="dropdown-content">
						<li>
							<a href="tourSearch.do">"관광지검색"</a>
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
			</ul>
		</div>
	</nav>
</div>
	
</head>
<body>