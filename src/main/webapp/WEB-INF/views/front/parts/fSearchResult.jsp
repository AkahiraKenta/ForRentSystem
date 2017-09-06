<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<h2 class="midashi_search">検索結果一覧</h2>
<div class="result_ichiran">
	<c:if test="${searchConditionAddressList != null && searchConditionAddressList != ''}">
		<dl>
			<dt>エリア：</dt>
			<dd>
				<c:if test="${searchConditionAddressList != ''}">
					<c:if test="${fSearchConditionForm.selectedTownArea[0] == '999'}">
						<p>全て</p>
					</c:if>
					<c:if test="${fSearchConditionForm.selectedTownArea[0] != '999'}">
						<c:forEach var="address" items="${searchConditionAddressList}">
							<%--
								<p>${address.province}${address.city}${address.townArea}</p>
								<p>${address.city}${address.townArea}</p>
							--%>
							<p>${address.townArea}</p>
						</c:forEach>
					</c:if>
				</c:if>
			</dd>
		</dl>
	</c:if>
	<c:if test="${searchConditionNearestStationList != null && searchConditionNearestStationList != ''}">
		<dl>
			<dt>最寄り駅：</dt>
			<dd>
				<c:if test="${searchConditionNearestStationList != ''}">
					<c:if test="${fSearchConditionForm.selectedStationId[0] == '999'}">
						<p>全て</p>
					</c:if>
					<c:if test="${fSearchConditionForm.selectedStationId[0] != '999'}">
						<c:forEach var="searchConditionNearestStation" items="${searchConditionNearestStationList}">
							<p>${searchConditionNearestStation.stationName}</p>
						</c:forEach>
					</c:if>
				</c:if>
			</dd>
		</dl>
	</c:if>
</div>
