<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
	<div>제목</div>
	<div>${notice. }</div>
	<div>내용</div>
	<div><textarea rows="20" cols="1000" placeholder="내용은 1000자 이내로 입력하세요." name=no_content></textarea> </div>
		<div><input type="submit" value="작성"></div>
		<div><input type="button" value="취소" onclick="location.href='noticeList.do'"></div>
	</form>
</body>
</html>