<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {				
			document.getElementById('u_zipcode').value = data.zonecode;
			document.getElementById('u_addr1').value = data.address;				
		}
	}).open();
}
</script>

<script src="<%=request.getContextPath()%>/js/user.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css" />

</head>
<body>
	<form name="user_edit" method="post" action="user_edit_ok.do"
  		 enctype="multipart/form-data">
		
		<div class="form-group">
			<label for="u_id">아이디</label> 
			${u_id}
		</div>

		<div class="form-group">
			<label for="u_pwd">비밀번호</label> 
			<input type="password" name="u_pwd" id="u_pwd" size="14" class="input_box"/>
		</div>
		
		<div class="form-group">
			<label for="u_nickname">닉네임</label> 
			<input type="text" name="u_nickname" id="u_nickname" size="10" class="input_box" value="${user.u_nickname}"/>
		</div>
		<div id="nicknamecheck"></div>

		<div class="form-group">
			<label for="u_phone">휴대폰번호</label> 
			<input type="text" name="u_phone" id="u_phone" size="14" class="input_box" value="${user.u_phone}"/>
		</div>

		<div class="form-group">
			<label for="u_birth">생년월일</label> 
			<input type="date" name="u_birth" id="u_birth" size="14" class="input_box" value="${user.u_birth}"/>
		</div>
		
		<div class="form-group">
			<label for="u_zipcode">우편번호</label> 
			<input type="text" name="u_zipcode" id="u_zipcode" size="14" class="input_box" value="${user.u_zipcode}"/>
			<br>
			<input type="button" value="우편번호검색" class="input_button"
      		onclick="openDaumPostcode()" />
		</div>
		
		<div class="form-group">
			<label for="u_addr1">주소</label> 
			<input type="text" name="u_addr1" id="u_addr1" size="100" class="input_box" value="${user.u_addr1}"/>
		</div>
		
		<div class="form-group">
			<label for="u_addr2">세부주소</label> 
			<input type="text" name="u_addr2" id="u_addr2" size="30" class="input_box" value="${user.u_addr2}"/>
		</div>
		
		<div class="form-group">
			<label for="u_email">이메일주소</label> 
			<input type="text" name="u_email" id="u_email" size="30" class="input_box" value="${user.u_email}"/>
			@<input type="text" name="u_domain" id="u_domain" size="20" class="input_box" value="${user.u_domain}"/>
		</div>
		
		<div class="form-group">
			<label for="u_profile1">프로필사진</label> 
			<input type="file" name="u_profile1" id="u_profile1"  class="input_box"/>
		</div>
		
		
	<div id="join_menu"  style="text-align: center;">
	<input type="submit" value="회원수정" class="input_button" />
	<input type="reset" value="수정취소" class="input_button" 
	    		onclick="history.go(-1)" />
	</div>
	
	</form>


</body>
</html>