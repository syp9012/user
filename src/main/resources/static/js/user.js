// 로그인 유효성 검사
function login_check() {
	if ($.trim($("#u_id").val()) == "") {
		alert("아이디를 입력하세요");
		$("#u_id").val("").focus();
		return false;
	}
	if ($.trim($("#u_pwd").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#u_pwd").val("").focus();
		return false;
	}
}

// 회원가입 유효성 검사
function join_check(){
	 if($.trim($("#u_id").val())==""){
		 alert("아이디를 입력하세요!");
		 $("#u_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#u_pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#u_pwd").val("").focus();
		 return false;
	 }
	 if($.trim($("#u_id").val()).length < 4){
		var newtext='<font color="red">아이디는 4자 이상이어야 합니다.</font>';
	}
	 if($.trim($("#u_pwd2").val())==""){
		 alert("비밀번호 확인을 입력하세요!");
		 $("#u_pwd2").val("").focus();
		 return false;
	 }
	 if($.trim($("#u_pwd").val()) != $.trim($("#u_pwd2").val())){
		 alert("비밀번호가 다릅니다!");
		 $("#u_pwd").val("");
		 $("#u_pwd2").val("");
		 $("#u_pwd").focus();
		 return false;
	 }
	 if($.trim($("#u_nickname").val())==""){
		 alert("닉네임을 입력하세요!");
		 $("#u_nickname").val("").focus();
		 return false;
	 }

	 if($.trim($("#u_phone").val())==""){
		 alert("휴대폰 번호를 입력하세요!");
		 $("#u_phone").val("").focus();
		 return false;
	 }
 }
 
// 아이디 중복 체크
function id_check(){
	$("#idcheck").hide();//idcheck span 아이디 영역을 숨긴다.
	var u_id=$("#u_id").val();
	//1.입력글자 길이 체크
	if($.trim($("#u_id").val()).length < 4){
		var newtext='<font color="red">아이디는 4자 이상이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#u_id").val("").focus();
		return false;
	};
	if($.trim($("#u_id").val()).length > 12){
		var newtext='<font color="red">아이디는 12자 이하이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);
		$("#u_id").val("").focus();
		return false;
	};
	//입력아이디 유효성 검사
	if(!(validate_userid(u_id))){
		var newtext='<font color="red">아이디는 영문소문자,숫자 조합만 가능합니다.</font>';
		$("#idcheck").text('');		
		$("#idcheck").show();		
		$("#idcheck").append(newtext);
		$("#u_id").val("").focus();
		return false;
	};
	

	//아이디 중복확인
    $.ajax({
        type:"POST",
        url:"/user_idcheck.do",
        success: function (data) { // 콜백함수로 돌려받는값은 member_idcheck.do -> idcheckResult.jsp 에서 출력된 EL값입니다.
//        	alert("return success="+data);
      	  if(data==1){			//중복 ID
      		var newtext='<font color="red">중복 아이디입니다.</font>';
      			$("#idcheck").text('');
        		$("#idcheck").show();
        		$("#idcheck").append(newtext);
          		$("#u_id").val('').focus();
          		return false;
	     
      	  }else{				//사용 가능한 ID
      		var newtext='<font color="blue">사용가능한 아이디입니다.</font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append(newtext);
      		$("#u_pwd1").focus();
      	  }  	    	  
        }
        ,
    	  error:function(e){
    		  alert("data error"+e);
    	  }
      });//$.ajax	
};



// 정규 표현식 검사
function validate_userid(u_id){
  var pattern= new RegExp(/^[a-z0-9]+$/);  //영문 소문자,숫자 가능,정규표현식
  
  return pattern.test(u_id); // boolean 타입 리턴
};
 


//  정보수정 유효성 검사
function edit_check(){

	 if($.trim($("#u_pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#u_pwd").val("").focus();
		 return false;
	 }

	 if($.trim($("#u_pwd2").val())==""){
		 alert("비밀번호 확인을 입력하세요!");
		 $("#u_pwd2").val("").focus();
		 return false;
	 }
	 if($.trim($("#u_pwd").val()) != $.trim($("#u_pwd2").val())){
		 alert("비밀번호가 다릅니다!");
		 $("#u_pwd").val("");
		 $("#u_pwd2").val("");
		 $("#u_pwd").focus();
		 return false;
	 }
	 if($.trim($("#u_nickname").val())==""){
		 alert("닉네임을 입력하세요!");
		 $("#u_nickname").val("").focus();
		 return false;
	 }

	 if($.trim($("#u_phone").val())==""){
		 alert("휴대폰 번호를 입력하세요!");
		 $("#u_phone").val("").focus();
		 return false;
	 }
 }









 
 
 
 