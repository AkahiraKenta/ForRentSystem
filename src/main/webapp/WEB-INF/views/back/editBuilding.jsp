<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/address/address.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/nearestStation/nearestStation.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/editBuilding.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/numericInput/numericInput.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/googleMap/googleMapFunction.js"></script>
		<title>建物編集画面</title>
	</head>
    <body>
	    <div id="wrapper">
	        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	            <%@ include file="./parts/header.jsp" %>
	            <%@ include file="./parts/menu.jsp" %>
	        </nav>
	        <div id="page-wrapper">
	            <div class="row disnon">
	                <div class="col-lg-12">
	                    <ol class="breadcrumb">
	                        <li><a href="./back/">トップ</a></li>
	                    </ol>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">建物情報編集</h1>
	                </div>
	            </div>
	            <div class="row">
		            <form:form method="post" action="${pageContext.request.contextPath}/back/editConfirmBuilding" modelAttribute="editBuildingForm">
		                <div class="col-lg-8">
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
	                                <span class="pull-left"> 編集</span>
	                                <div class="clearfix"></div>
		                        </div>
		                        <div class="panel-body">
		                            <div class="table-responsive">
		                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
		                                    <tbody>
		                                    	<form:hidden path="buildingId"/>
		                                        <tr>
		                                            <th class="item_font_size">
	                                            		建物番号
		                                            	<span class="label label-danger">必須</span>
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-w-7 form-control" path="buildingCode" maxlength="20"/>
		                                            	<form:errors path="buildingCode" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	建物名称
		                                            	<span class="label label-danger">必須</span>
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-xlarge form-control" path="buildingName" maxlength="150"/>
		                                            	<form:errors path="buildingName" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	建物種別
		                                            </th>
		                                            <td>
		                                            	<form:select path="buildingType"  items="${buildingTypeList}" itemLabel="name" itemValue="id">
														</form:select>
		                                            </td>
		                                            <form:hidden path="buildingTypeName"/>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	〒
		                                            </th>
		                                            <td>
		                                                <form:input class="btn-group input-w-3 form-control" path="zipCode" maxlength="8"/>
		                                                <button name="addressImport" id="addressImport" type="button" class="btn btn-info btn-sm">取込</button>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	都道府県
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control" path="province" readOnly="true"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            市区町村
		                                            </th>
		                                            <td>
		                                            	<form:select path="city">
		                                           		</form:select>
		                                           		<form:hidden path="cityName"/>
		                                            	<!--
		                                            	<form:input class="input-xlarge form-control" path="city" disabled="true"/>
		                                            	 -->
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	町域
		                                            </th>
	                                            	<td>
		                                           		<form:select path="townArea">
		                                            	</form:select>
		                                            	<form:hidden path="townAreaName"/>
		                                            	<!--
		                                            	<form:input class="input-xlarge form-control" path="townArea" disabled="true"/>
		                                            	 -->
	                                            	</td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	町域以下
		                                            </th>
		                                            <td>
		                                            	<form:input class="btn-group input-w-7 form-control" path="townAreaBelow" maxlength="100"/>
		                                            	<button id="googleMapUpdateButton" type="button" class="btn btn-info btn-sm">地図更新</button>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅1(沿線)
		                                            </th>
		                                            <td>
		                                            	<form:select path="nearestRoute1" items="${nearestRouteList1}" itemLabel="routeName" itemValue="routeId" class="nearestRoute">
														</form:select>
		                                         		<form:hidden path="nearestRouteName1"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅1(駅)
		                                            </th>
		                                            <td>
		                                            	<form:select path="nearestStation1"  items="${nearestStationList1}" itemLabel="stationName" itemValue="stationId">
														</form:select>
														<form:hidden path="nearestStationName1"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅1(徒歩分)
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control" path="minutesWalk1" maxlength="3"/>
		                                            	<form:errors path="minutesWalk1" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                         <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅2(沿線)
		                                            </th>
		                                            <td>
	                             	                    <form:select path="nearestRoute2" items="${nearestRouteList2}" itemLabel="routeName" itemValue="routeId" class="nearestRoute">
														</form:select>
		                                             	<form:hidden path="nearestRouteName2"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅2(駅)
		                                            </th>
		                                            <td>
		                                            	<form:select path="nearestStation2"  items="${nearestStationList2}" itemLabel="stationName" itemValue="stationId">
														</form:select>
														<form:hidden path="nearestStationName2"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅2(徒歩分)
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control" path="minutesWalk2" maxlength="3"/>
		                                            	<form:errors path="minutesWalk2" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅3(沿線)
		                                            </th>
		                                            <td>
		                                            	<form:select path="nearestRoute3" items="${nearestRouteList3}" itemLabel="routeName" itemValue="routeId" class="nearestRoute">
														</form:select>
														<form:hidden path="nearestRouteName3"/>
		                                            </td>
		                                        </tr>
		                                         <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅3(駅)
		                                            </th>
		                                            <td>
		                                            	<form:select path="nearestStation3"  items="${nearestStationList3}" itemLabel="stationName" itemValue="stationId">
														</form:select>
		                                            	<form:hidden path="nearestStationName3"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	最寄駅3(徒歩分)
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control" path="minutesWalk3" maxlength="3"/>
		                                            	<form:errors path="minutesWalk3" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	築年月（年）
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control" path="builtYear" maxlength="4"/>
		                                            	<form:errors path="builtYear" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	築年月（月）
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-whalf form-control"  path="builtMonth" maxlength="2"/>
		                                            	<form:errors path="builtMonth" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	階建
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-xlarge form-control" path="numberOfStoreys" maxlength="4"/>
		                                            	<form:errors path="numberOfStoreys" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	構造
		                                            </th>
		                                            <td>
		                                            	<form:select path="structureId"  items="${structureList}" itemLabel="structureName" itemValue="structureId">
														</form:select>
														<form:hidden path="structureName"/>
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	建物PRタイトル
		                                            	<span class="label label-danger">必須</span>
		                                            </th>
		                                            <td>
		                                            	<form:input class="input-xlarge form-control" path="prTitle" maxlength="200"/>
		                                            	<form:errors path="prTitle" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <tr>
		                                            <th class="item_font_size">
		                                            	建物PR詳細
		                                            </th>
		                                            <td>
		                                            	<form:textarea  class="form-control" path="prDetail" rows="10"/>
		                                            	<form:errors path="prDetail" cssClass="validateErrors" />
		                                            </td>
		                                        </tr>
		                                        <form:hidden path="latitude"/>
		                                        <form:hidden path="longitude"/>
		                                   </tbody>
		                               </table>
		                            </div>
		                            <div class="btnBox">
		                            	<a href="${pageContext.request.contextPath}//back/backEditBuilding?buildingId=${editBuildingForm.buildingId}" class="btn btn-warning btn-lg">戻る</a>
										<input id="confirm" type="submit" class="btn btn-primary btn-lg" value="編集確認" />
									</div>
		                        </div>
		                    </div>
		                </div>
	   			    </form:form>
	                <div class="col-lg-4">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                        	<span class="pull-left"> 建物位置情報</span>
	                        	<div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
	                                    <tbody>
	                                        <tr>
	                                            <th>
	                                                <div id="map"></div>
	                                            </th>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                                緯度
	                                                <input type="text" class="input-xlarge form-control" id="latitudeView" readOnly="readonly"/>
	                                            </th>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                                経度
	                                                <input type="text" class="input-xlarge form-control" id="longitudeView" readOnly="readonly"/>
	                                            </th>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                     </div>

						 <%-- GoogleMap作成 START --%>
						 <script type="text/javascript">googleMapSetUp();</script>
						 <%-- GoogleMap作成 E N D --%>

	                     <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left"> 建物画像情報</span>
	                            <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                            	<c:if test="${buildingImage.imageId != null}">
		                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
		                                    <tbody>
	                              				<tr>
													<th>
														<div class="imgInput">
		                                              		<div id="imageDiv_${buildingImage.imageId}">
		                                              			<c:out value="${buildingImage.imageCaption}"></c:out>
														 		<img id="imageView_${buildingImage.imageId}" alt="" class="imgView img-responsive" src="${filePath}${buildingImage.buildingId}/${buildingImage.fileName}" style="margin-bottom:15px; width:130px; height:100px;">
															</div>
		                                              	</div>
													</th>
		                                        </tr>
		                                    </tbody>
		                                </table>
									</c:if>
	                            </div>
	                        </div>
	                    </div>
	                </div>
		        </div>
	        </div>
	        <%@ include file="./parts/footer.jsp" %>
	    </div>
    </body>
</html>