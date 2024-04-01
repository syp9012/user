<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 메인화면</title>
</head>
<body>

	<h2 class="main_title">사용자 메인화면</h2>  
	<form method="post" action="user_logout.do"> 
		<div>닉네임   ${u_nickname}</div>
		<div><img src="${pageContext.request.contextPath}/upload/${u_profile}" style="width: 100px;"></div>
		

     
	</form>
	<div style="text-align: center;">
		<input type="button" value="정보수정" onclick="location.href='user_edit.do'">
		<input type="button" value="회원탈퇴" onclick="location.href='user_delete.do'">
		<input type="button" value="로그아웃" onclick="location.href='user_logout.do'"/>     
	</div>	

</body>
</html>