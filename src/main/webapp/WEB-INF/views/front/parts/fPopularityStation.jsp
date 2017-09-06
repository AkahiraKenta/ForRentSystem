<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- 人気駅から探す --%>
<link rel="stylesheet" href="resources/css/front/part/popularityStation.css">
<div class="top_eki">
	<h2 class="midashi_train">人気駅から探す</h2>
	<div class="top_eki_box">
		<dl>
			<c:forEach var="popularityStation" items="${popularityStationList}" varStatus="status">
				<c:if test="${popularityStation.rank == 1}">
					<dt class="lank1">
				</c:if>
				<c:if test="${popularityStation.rank != 1}">
					<dt>
				</c:if>
						${popularityStation.rank}位
					</dt>
				<c:if test="${popularityStation.rank == 1}">
					<dd class="lank1">
				</c:if>
				<c:if test="${popularityStation.rank != 1}">
					<dd>
				</c:if>
						<a href="#" onclick="onHref('./searchResultByPopularityStation?stationId=${popularityStation.stationId}', this)">
							${popularityStation.stationName}(${popularityStation.popularityStationCount})
						</a>
					</dd>
				<input type="hidden" id="popularityStation_${popularityStation.rank}"
					 value="${popularityStation.stationId}"/>
			</c:forEach>
		</dl>
		<div class="search_other">
			<a href="./searchStation">＞他の駅から探す</a>
		</div>
	</div>
</div>
