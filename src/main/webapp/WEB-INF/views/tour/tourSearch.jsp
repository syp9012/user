<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<!DOCTYPE html>
<html>


<head>



<meta charset="UTF-8">
<title>캠핑장 검색</title>

</head>
<body>
<!-- 검색 -->
<form id="search" name="search" action="tourSearch.do">
	<input type="hidden" name="tourOrTour" value="tour">
	<div>
		<div>검색어</div>
		<div><input type="text" name="search_word" id="search_word" ></div>
		
		<div>
			<select name="do_name" id="do_name"></select>
			<select name="city_name" id="city_name"></select>
		</div>
	</div>
	<input type="submit" value="검색"/>
</form>

	
<!-- 게시판 출력 -->
<c:if test="${empty tourList}">
	데이터가 없습니다
</c:if>
<c:if test="${!empty tourList}">
<c:set var="no1" value="${tour.endRow}"></c:set>
<c:forEach var="searchTour" items="${tourList}">
	<c:if test="${!empty searchTour.tour_image1}">
		<div>
		<a href="tourDetail.do?tour_id=${searchTour.tour_id}&page=${page}"><img src="${searchTour.tour_image1}"></a>
		</div>
		<div>${searchTour.tour_name}</div>
		<div>${searchTour.tour_addr1}</div>
	</c:if>
	<c:if test="${empty searchTour.tour_image1}">
		<div>
		<a href="tourDetail.do?tour_id=${searchTour.tour_id}&page=${page}"><img src="/img/naver_login.png"></a>
		</div>
		<div>${searchTour.tour_name}</div>
		<div>${searchTour.tour_addr1}</div>
	</c:if>
</c:forEach>
</c:if>


<!-- 페이징 처리 -->
	


<c:if test="${startPage > 10}">
    <a href="${path }/tourSearch.do?page=${startPage - 1}&search_word=${tour.search_word}&do_name=${tour.do_name}&city_name=${tour.city_name}">이전</a></li>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}">
    <c:if test="${page == i}">
        <a href="${path }/tourSearch.do?page=${i}&search_word=${tour.search_word}&do_name=${tour.do_name}&city_name=${tour.city_name}" class="active">${i}</a>
    </c:if>
    <c:if test="${page != i}">
        <a href="${path }/tourSearch.do?page=${i}&search_word=${tour.search_word}&do_name=${tour.do_name}&city_name=${tour.city_name}">${i}</a>
    </c:if>
</c:forEach>
<c:if test="${endPage < maxPage}">
    <a href="${path }/tourSearch.do?page=${endPage + 1}&search_word=${tour.search_word}&do_name=${tour.do_name}&city_name=${tour.city_name}">다음</a>
</c:if>

	
</body>
</html>