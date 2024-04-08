<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<body>

	<div class="board_wrap">
		<div class="board_title">
			<strong>공지사항</strong>
			<p>공지사항을 빠르고 정확하게 안내드립니다.</p>
			<div class="board_list_wrap">
				<div class="board_list">
					<div class="top">
						<div class="num">글번호</div>
						<div class="title">제목</div>
						<div class="writer">작성자</div>
						<div class="count">조회수</div>
						<div class="date">등록일</div>
					</div>	
					
					<c:forEach var="list" items="${noticeList}">
						<c:set var="no" value="${no}"></c:set>
						<div>
							<div class="num">${no}</div>
							<div class="title"><a href="noticeDetail.do?no_no=${list.no_no}&page=${page}">${list.no_subject}</a></div>
							<div class="writer">관리자</div>
							<div class="count">${list.no_readcount}</div>
							<div class="date">${list.no_date}</div>
						</div>
						<c:set var="no" value="${no - 1}"></c:set>
					</c:forEach>
					<div class="board_page">
							<c:if test="${startPage > 10}">
							    <div class="bt prev">
							    	<a href="${path }/noticeList.do?page=${startPage - 1}&search_word=${$notice.searchWord}">이전</a>
								</div>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
								    <div class="num on">
									    <c:if test="${page == i}">
									        <a href="${path }/noticeList.do?page=${i}&search_word=&search_word=${$notice.searchWord}" class="active">${i}</a>
									    </c:if>
								    </div>
								   	<div class="num">
									    <c:if test="${page != i}">
									        <a href="${path }/noticeList.do?page=${i}&search_word=${$notice.searchWord}">${i}</a>
									    </c:if>
									</div>
								</c:forEach>
								<c:if test="${endPage < maxPage}">
									<div class="bt next">
								    	<a href="${path }/noticeList.do?page=${endPage + 1}&search_word=${$notice.searchWord}">다음</a>
									</div>
								</c:if>
					</div>
					<div class="bt_wrap">
						<a href="noticeList.do" class="on">목록</a>
						<a href="<c:url value='/insertNoticeForm.do' />" class="on">글작성</a>
					</div>
					ㄴ
					<form action="noticeList.do">
						<input type="hidden" name="page" value="${page}" />
						<div><input type="text" name="search_word" id="search_word" ></div>
						<input type="submit" value="검색">
					</form>

				</div>
			</div>
		</div>
	</div>
	


</body>
</html>