<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 입력</title>
</head>
<body>
<form action="insertNotice.do">
	<input type="hidden" name="page" value="${page}" />
	<div>제목</div>
	<div><input type="text" name=no_subject id= no_subject></div>
	<div>내용</div>
	<div><textarea rows="20" cols="1000" placeholder="내용은 1000자 이내로 입력하세요." name=no_content></textarea> </div>
	<div><input type="submit" value="작성"></div>
	<div><input type="button" value="취소" onclick="location.href='noticeList.do'"></div>
</form>

</body>
</html>