<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<!--人気エリアから探す-->
<link rel="stylesheet" href="resources/css/front/part/popularityArea.css">
<script src="resources/js/front/part/fpopularityArea.js"></script>
<div class="top_area">
	<h2 class="midashi_area">人気エリアから探す</h2>
	<div class="top_area_box">
		<form:form method="post" action="${pageContext.request.contextPath}/searchResultByTownArea" modelAttribute="fSearchConditionForm" name="fSearchConditionForm">
			<dl>
				<c:forEach var="popularityArea" items="${popularityAreaList}" varStatus="status">
					<c:if test="${popularityArea.rank == 1}">
						<dt class="lank1">
					</c:if>
					<c:if test="${popularityArea.rank != 1}">
						<dt>
					</c:if>
							${popularityArea.rank}位
						</dt>
					<c:if test="${popularityArea.rank == 1}">
						<dd class="lank1">
					</c:if>
					<c:if test="${popularityArea.rank != 1}">
						<dd>
					</c:if>
							<a href="#" name="townArea">
								${popularityArea.townArea}(${popularityArea.popularityAreaCount})
							</a>
						</dd>
					<input type="hidden" id="popularityArea_${popularityArea.rank}"
						 value="${popularityArea.popularityAreaId}"/>
				</c:forEach>
			</dl>
			<div class="search_other">
				<a href="./searchArea">＞他のエリアから探す</a>
			</div>
			<form:hidden path="selectedTownArea"/>
		</form:form>
	</div>
</div>
