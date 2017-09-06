<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<div id ="pager" style="text-align: center">
	<form:hidden path="totalNumber"/>
	<form:hidden path="currentPage"/>
	<form:hidden path="viewNumber"/>
	<form:hidden path="pageTotalNumber"/>


	<a class="callPager" href="#">
		<span id="prev" style="margin-right:15px">
			前へ＜＜
		</span>
	</a>
	<c:forEach begin="${beginPage}" end="${endPage}" varStatus="status">
		<c:if test="${currentPageNumber == status.index}">
			<span id="pager_${status.index}" style="margin-right:5px">
				${status.index}
			</span>
		</c:if>
		<c:if test="${currentPageNumber != status.index}">
			<a class="callPager" href="#">
				<span id="pager_${status.index}" style="margin-right:5px">
					${status.index}
				</span>
			</a>
		</c:if>
	</c:forEach>
	<a class="callPager" href="#">
		<span id="next" style="margin-left:10px">
			＞＞次へ
		</span>
	</a>

</div>
