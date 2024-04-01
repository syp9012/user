<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%-- <link rel="stylesheet" type="text/css" href="./css/admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/member.css" /> --%>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="<%=request.getContextPath()%>/js/user.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css" />

</head>
<body>

	<h2 class="join_title">회원가입</h2>
	<form method="post" action="user_join_ok.do"
		onsubmit="return join_check()" enctype="multipart/form-data">

		<div class="form-group">
			<label for="u_id">아이디</label> 
			<input type="text" name="u_id" id="u_id" size="20" class="input_box" onchange="id_check()" />
		</div>
		<div id="idcheck"></div>

		<div class="form-group">
			<label for="u_pwd">비밀번호</label> 
			<input type="password" name="u_pwd" id="u_pwd" size="14" class="input_box"/>
		</div>

		<div class="form-group">
			<label for="u_pwd2">비밀번호 확인</label> 
			<input type="password" name="u_pwd2" id="u_pwd2" size="14" class="input_box" />
		</div>
		
		<div class="form-group">
			<label for="u_nickname">닉네임</label> 
			<input type="text" name="u_nickname" id="u_nickname" size="10" class="input_box"/>
		</div>
		<div id="nicknamecheck"></div>

		<div class="form-group">
			<label for="u_phone">휴대폰번호</label> 
			<input type="text" name="u_phone" id="u_phone" size="14" class="input_box" on/>
		</div>
		<div id=phonecheck></div>


		<div style='text-align:center'>
			<input type="submit" value="회원가입" class="input_button" /> 
			<input type="button" value="가입취소" class="input_button" onclick="location.href='user_login.do'" />
		</div>
	</form>

</body>
</html>
