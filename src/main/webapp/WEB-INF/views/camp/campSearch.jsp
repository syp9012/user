<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<!DOCTYPE html>
<html>


<head>

</head>
<body>

<form id="search" name="search" action="campSearch.do">
	<input type="hidden" name="CampOrTour" value="camp">
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
<c:if test="${empty campList}">
	데이터가 없습니다
</c:if>
<c:if test="${!empty campList}">
<c:set var="no1" value="${camp.endRow}"></c:set>
<c:forEach var="searchCamp" items="${campList}">
	<c:if test="${!empty searchCamp.camp_image}">
		<div>
		<a href="campDetail.do?camp_no=${searchCamp.camp_no}&page=${page}"><img src="${searchCamp.camp_image}"></a>
		</div>
		<div>${searchCamp.camp_name}</div>
		<div>${searchCamp.camp_addr1}</div>
	</c:if>
	<c:if test="${empty searchCamp.camp_image}">
		<div>
		<a href="campDetail.do?camp_no=${searchCamp.camp_no}&page=${page}"><img src="/img/naver_login.png"></a>
		</div>
		<div>${searchCamp.camp_name}</div>
		<div>${searchCamp.camp_addr1}</div>
	</c:if>
</c:forEach>
</c:if>


<!-- 페이징 처리 -->
	


<c:if test="${startPage > 10}">
    <a href="${path }/campSearch.do?page=${startPage - 1}&search_word=${camp.search_word}&do_name=${camp.do_name}&city_name=${camp.city_name}">이전</a></li>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}">
    <c:if test="${page == i}">
        <a href="${path }/campSearch.do?page=${i}&search_word=${camp.search_word}&do_name=${camp.do_name}&city_name=${camp.city_name}" class="active">${i}</a>
    </c:if>
    <c:if test="${page != i}">
        <a href="${path }/campSearch.do?page=${i}&search_word=${camp.search_word}&do_name=${camp.do_name}&city_name=${camp.city_name}">${i}</a>
    </c:if>
</c:forEach>
<c:if test="${endPage < maxPage}">
    <a href="${path }/campSearch.do?page=${endPage + 1}&search_word=${camp.search_word}&do_name=${camp.do_name}&city_name=${camp.city_name}">다음</a>
</c:if>

	
</body>
</html>