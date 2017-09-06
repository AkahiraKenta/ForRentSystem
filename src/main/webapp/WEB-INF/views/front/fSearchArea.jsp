<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<link rel="stylesheet" href="resources/css/front/part/popularityArea.css">
		<script src="resources/js/front/part/fSearchArea.js"></script>
		<title>エリアから探す｜KURASHI｜不動産サイト</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%--エリアから探す--%>
				<h2 class="midashi_area">エリアから探す</h2>
				<form:form method="post" action="${pageContext.request.contextPath}/callSearchArea" modelAttribute="fSearchConditionForm" name="fSearchConditionForm">
					<c:forEach var="buildingAddressListMap" items="${buildingAddressListMap}" varStatus="provinceStatus">
						<section class="search_area">
							<h5>${buildingAddressListMap.key}</h5>
							<c:forEach var="cityMap" items="${buildingAddressListMap.value}" varStatus="cityStatus">
								<div class="search_area_name">
									<h6>${cityMap.key}</h6>
									<div>
										<input id="checkAllArea${provinceStatus.index}${cityStatus.index}" name="checkAllArea" type="checkbox" value="">
										<label for="checkAllArea${provinceStatus.index}${cityStatus.index}">すべてのエリアを選択</label>
									</div>
								</div>
								<div class="search_area_name2">
									<c:forEach var="townAreaList" items="${cityMap.value}" varStatus="townAreaStatus">
										<c:if test="${townAreaStatus.index == 0}">
											<input id="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}" name="selectedTownArea" type="checkbox" value="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}">
										</c:if>
										<c:if test="${townAreaStatus.index % 5 != 0}">
											<input id="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}" name="selectedTownArea" type="checkbox" value="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}" style="margin-left:20px">
										</c:if>
										<c:if test="${townAreaStatus.index > 4 && townAreaStatus.index % 5 == 0}">
											<br>
											<input id="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}" name="selectedTownArea" type="checkbox" value="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}">
										</c:if>
										<label for="${townAreaList.province}_${townAreaList.city}_${townAreaList.townArea}">${townAreaList.townArea}(${townAreaList.count})</label>
									</c:forEach>
									<input id="selectedTownAreaList" type="hidden" value="${selectedTownAreaList}"/>
								</div>
							</c:forEach>
						</section>
					</c:forEach>
				</form:form>
				<p class="btn_vio"><a href="#" id="searchResultArea" onclick="onSubmit('fSearchConditionForm',this);">エリアで検索する</a></p>
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