<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<form:form method="post" action="${pageContext.request.contextPath}/callSearchCondition" modelAttribute="fSearchConditionForm" name="fSearchConditionForm">
	<div class="acordion" style="cursor: pointer;">
		<h2 class="midashi_jyouken_block">
			条件で絞り込む
		</h2>
	</div>
	<div class="result_jyouken" style="display:none">
		<table width="712" border="0" cellspacing="0" cellpadding="0">
			<tr>
			    <td width="15%" class="jyouken_td">物件タイプ</td>
			    <td id="buildingTypeList" width="85%">
		    		<c:forEach var="buildingType" items="${buildingTypeList}" varStatus="status">
						<input id="selectedBuildingType${buildingType.id}" name="selectedBuildingType" type="checkbox" value="${buildingType.id}">
						<label for="selectedBuildingType${buildingType.id}" style="margin-right:10px">${buildingType.name}</label>
					</c:forEach>
					<input type="hidden" id="selectedBuildingTypeHidden" name="selectedBuildingTypeHidden" value="${selectedBuildingTypeHidden}" />

				    <%--
				    	<form:checkboxes path="selectedBuildingType" items="${buildingTypeList}" itemLabel="name" itemValue="id" />
				    --%>
				</td>
			</tr>
			<tr>
				<td class="jyouken_td">設備</td>
				<td id="equipmentList">
					<c:forEach var="equipment" items="${equipmentList}" varStatus="status">
						<c:if test="${status.index % 4 == 0 && status.index >= 4}">
							<br>
						</c:if>
						<input id="selectedEquipment${equipment.id}" name="selectedEquipment" type="checkbox" value="${equipment.id}">
						<label for="selectedEquipment${equipment.id}" style="margin-right:10px">${equipment.name}</label>
					</c:forEach>
					<input type="hidden" id="selectedEquipmentHidden" name="selectedEquipmentHidden" value="${selectedEquipmentHidden}" />

					<%--
					<form:checkboxes path="selectedEquipment" items="${equipmentList}" itemLabel="name" itemValue="id" />
					 --%>
				</td>
			</tr>
			<tr>
			    <td class="jyouken_td">賃料</td>
			    <td>
			    	<form:select path="rentFromClassId" items="${rentFromClassList}" itemLabel="name" itemValue="id" />
			    	～
			    	<form:select path="rentToClassId" items="${rentToClassList}" itemLabel="name" itemValue="id" />
			    </td>
			</tr>
			<tr>
			    <td class="jyouken_td">間取り</td>
			    <td id="floorPlanList">
			    	<c:forEach var="floorPlan" items="${floorPlanList}" varStatus="status">
						<c:if test="${status.index % 6 == 0 && status.index >= 6}">
							<br>
						</c:if>
						<input id="selectedFloorPlan${floorPlan.floorPlanId}" name="selectedFloorPlan" type="checkbox" value="${floorPlan.floorPlanId}">
						<label for="selectedFloorPlan${floorPlan.floorPlanId}" style="margin-right:10px">${floorPlan.floorPlanName}</label>
					</c:forEach>
					<input type="hidden" id="selectedFloorPlanHidden" name="selectedFloorPlanHidden" value="${selectedFloorPlanHidden}" />

					<%--
				    <form:checkboxes path="selectedFloorPlan" items="${floorPlanList}" itemLabel="floorPlanName" itemValue="floorPlanId" />
				     --%>
			    </td>
			</tr>
			<tr>
				<td class="jyouken_td">駅徒歩</td>
				<td>
					<form:radiobuttons  path="selectedMinutesWalkClass" items="${minutesWalkClassList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td class="jyouken_td">築年数</td>
				<td>
					<form:radiobuttons  path="selectedBuiltClass" items="${builtClassList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td class="jyouken_td">こだわり条件</td>
				<td id="goodForConditionList">
					<c:forEach var="goodForCondition" items="${goodForConditionList}" varStatus="status">
						<c:if test="${status.index % 4 == 0 && status.index >= 4}">
							<br>
						</c:if>
						<input id="selectedGoodForCondition${goodForCondition.id}" name="selectedGoodForCondition" type="checkbox" value="${goodForCondition.id}">
						<label for="selectedGoodForCondition${goodForCondition.id}" style="margin-right:10px">${goodForCondition.name}</label>
					</c:forEach>
					<input type="hidden" id="selectedGoodForConditionHidden" name="selectedGoodForConditionHidden" value="${selectedGoodForConditionHidden}" />

					<%--
					<form:checkboxes path="selectedEquipment" items="${equipmentList}" itemLabel="name" itemValue="id" />
					 --%>
				</td>
			</tr>
		</table>

		<%--“この条件で絞り込む”ボタン --%>
		<p class="btn_vio">
			<form:hidden path="selectedStationId"/>
			<form:hidden path="selectedTownArea"/>
			<a href="#" id="searchRefineCondition"  onclick="onSubmit('fSearchConditionForm',this);">この条件で絞り込む</a>
		</p>
	</div>
</form:form>












<%--
<div>
	<div>
		<label>
			■条件で絞り込む
		</label>
	</div>
	<div>
		<table>
			<tr>
				<td>
					物件タイプ
				</td>
				<td>
					<form:checkboxes path="selectedBuildingType" items="${buildingTypeList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td>
					設備
				</td>
				<td>
					<form:checkboxes path="selectedEquipment" items="${equipmentList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td>
					賃料
				</td>
				<td>
					<form:select path="rentFromClassId" items="${rentFromClassList}" itemLabel="name" itemValue="id" />
					～
					<form:select path="rentToClassId" items="${rentToClassList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td>
					間取り
				</td>
				<td>
					<form:checkboxes path="selectedFloorPlan" items="${floorPlanList}" itemLabel="floorPlanName" itemValue="floorPlanId" />
				</td>
			</tr>
			<tr>
				<td>
					駅徒歩
				</td>
				<td>
					<form:radiobuttons  path="selectedMinutesWalkClass" items="${minutesWalkClassList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td>
					築年数
				</td>
				<td>
					<form:radiobuttons  path="selectedBuiltClass" items="${builtClassList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
			<tr>
				<td>
					こだわり条件
				</td>
				<td>
					<form:checkboxes path="selectGoodForCondition" items="${goodForConditionList}" itemLabel="name" itemValue="id" />
				</td>
			</tr>
		</table>
		<input id="searchRefineCondition" type="submit" class="btn btn-primary btn-sm" value="この条件で絞り込む" />
	</div>
</div>
 --%>