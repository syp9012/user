<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${result == 1 }">
	<script>
		alert("회원가입 되었습니다.");
		location.href="user_login.do"
	</script>
</c:if>

<c:if test="${result == 2 }">
	<script>
		alert("회원가입 되어 있습니다.");
		history.go(-1);
	</script>
</c:if>