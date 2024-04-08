<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
<form action="updateNotice.do">
	<input type="hidden" name="page" value="${page}" />
	<input type="hidden" name="searchWord" value="${searchWord}" />
	<div>제목</div>
	<div><input type="text" name=no_subject id= no_subject value="${notice.no_subject}"></div>
	<div>내용</div>
	<div><textarea rows="20" cols="1000" placeholder="내용은 1000자 이내로 입력하세요." name=no_content, value="${notice.no_content}"></textarea> </div>
	<div><input type="submit" value="수정"></div>
	<div><input type="button" value="취소" onclick="location.href='noticeList.do'"></div>
</form>

</body>
</html>