<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<link rel="stylesheet" href="resources/css/front/part/popularityStation.css">
		<script src="resources/js/front/part/fSearchStation.js"></script>
		<title>最寄り駅から探す｜KURASHI｜不動産サイト</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%--最寄り駅から探す--%>
				<h2 class="midashi_train">最寄り駅から探す</h2>
				<section class="search_area">
					<form:form method="post" action="${pageContext.request.contextPath}/callSearchRouteAndStation" modelAttribute="fSearchConditionForm" name="fSearchConditionForm">
						<c:forEach var="routeAndStationMap" items="${nearestStationListMap}" varStatus="mapStatus">
							<div class="search_area_name">
								<h6>${routeAndStationMap.value[0].routeName}</h6>
								<div>
									<input id="checkAllStation${mapStatus.index}" name="checkAllStation" type="checkbox" value="">
									<label for="checkAllStation${mapStatus.index}">すべての駅を選択</label>
								</div>
							</div>
							<div class="search_area_name2">
							 	<c:forEach var="routeAndStationList" items="${routeAndStationMap.value}" varStatus="listStatus">
							 		<c:if test="${listStatus.index == 0}">
										<input id="${routeAndStationList.routeId}_${routeAndStationList.stationId}"
											name="selectedStationId" type="checkbox" value="${routeAndStationList.routeId}_${routeAndStationList.stationId}">
									</c:if>
									<c:if test="${listStatus.index % 5 != 0}">
										<input id="${routeAndStationList.routeId}_${routeAndStationList.stationId}"
											name="selectedStationId" type="checkbox" value="${routeAndStationList.routeId}_${routeAndStationList.stationId}"
											style="margin-left:20px">
									</c:if>
									<c:if test="${listStatus.index > 4 && listStatus.index % 5 == 0}">
										<br>
										<input id="${routeAndStationList.routeId}_${routeAndStationList.stationId}"
											name="selectedStationId" type="checkbox" value="${routeAndStationList.routeId}_${routeAndStationList.stationId}">
									</c:if>

									<label for="${routeAndStationList.routeId}_${routeAndStationList.stationId}">${routeAndStationList.stationName}(${routeAndStationList.count})</label>
								</c:forEach>
								<input id="selecteStationList" type="hidden" value="${selecteStationList}"/>
							</div>
						</c:forEach>
					</form:form>
				</section>
				<p class="btn_vio"><a href="#" id="searchResultStation" onclick="onSubmit('fSearchConditionForm',this);return false;">最寄り駅で検索する</a></p>
			</div>
			<%-- /左コンテンツ --%>

			<%-- 右カラム --%>
			<aside>
				<%-- おすすめ物件 --%>
				<%@ include file="./parts/fRecommendedRoom.jsp" %>
				<hr>
				<%-- 当サイトについて --%>
				<%@ include file="./parts/fExplainedSite.jsp" %>
				<hr>
				<%-- バナー --%>
				<%@ include file="./parts/fBanner.jsp" %>
			</aside>
			<%--/右カラム--%>
		</div>
		<%--/contents--%>
		<%-- ページ上部へ戻る --%>
		<div id="gototop">
			<a href="#">
				<img src="/images/common/gototop.jpg" width="89" height="70" alt="ページ上部へ">
			</a>
		</div>
		<%-- フッター --%>
		<%@ include file="./parts/fFooter.jsp" %>
	</body>
</html>