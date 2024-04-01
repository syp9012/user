<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 카카오에서 지원하는 sdk 파일 -->

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
<script src="<%=request.getContextPath()%>/js/user.js"></script>

</head>
<body>
	<header>
		<h2 class="login_title">로그인</h2>
	</header>

	<form method="post" action="user_login_ok.do" onsubmit="return login_check()">
		<div class="input-box">
			<input type="text" name="u_id" id="u_id" size="12" placeholder="아이디"/>
			<label for="username">아이디</label> 
		</div>
			
		<div class="input-box">	
			<input type="password" name="u_pwd" id="u_pwd" size="20" placeholder="비밀번호"/>
			<label for="password">비밀번호</label>
		</div>

		<div id="login_menu"  style="text-align: center;">
			<input type="submit" value="로그인"> 
			<input type="button" value="회원가입" onclick="location='user_join.do'" /> 
			<input type="button" value="비밀번호 찾기" onclick="location='user_findPwd.do''" /> 
		</div>
		
		
		
		
 		<!-- 카카오 로그인 -->
		<div style="text-align: center;">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=18356fc026d73f2a2835407e685fb611&redirect_uri=http://localhost/oauth/kakao/callback&response_type=code">
			<img src="/img/kakao_login.png" style="width:200px;padding:5px"> </a>
		</div>
		<!-- 네이버 로그인 -->
 		<div style="text-align: center;">
		    <a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=gWHz98Kmv8VTU8BIGrB2&redirect_uri=http://localhost/oauth/naver/callback&state=1234">
    			<img src="/img/naver_login.png"  style="width:200px;padding:5px">
			</a>   
		<div>

	</form>
</body>
</html>