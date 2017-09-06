<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/registBuilding.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/address/address.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/nearestStation/nearestStation.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/numericInput/numericInput.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/googleMap/googleMapFunction.js"></script>
		<title>建物登録画面</title>
	</head>
    <body>
    <div id="wrapper">
        <!-- Navigation -->
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
                    <h1 class="page-header">建物情報登録</h1>
                </div>
            </div>
            <div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callRegistConfirmBuilding" modelAttribute="registBuildingForm">
	                <div class="col-lg-8">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
                                <span class="pull-left"> 新規登録</span>
                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
	                                    <tbody>
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
	                                            	<form:input class="form-control" path="buildingName" maxlength="150"/>
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
	                                            	〒<br>
	                                            	<p style="color: #cc0000;font-size: smaller;">ハイフンなしで入力</p>
	                                            </th>
	                                            <td>
	                                                <form:input class="btn-group input-w-3 form-control" path="zipCode" maxlength="8"/>
	                                                <button name="addressImport" id="addressImport" type="button" class="btn btn-info btn-sm">取込</button>
	                                                <button name="searchZip" id="searchZip" type="button" class="btn btn-info btn-sm" onClick="popup_modeless('${pageContext.request.contextPath}/back/callSearchZip')">郵便番号検索</button>

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
	                                            	<form:hidden path="displayNumber1" value="1"/>
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
	                                            	<form:hidden path="displayNumber2" value="2"/>
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
	                                            	<form:input  class="input-whalf form-control" path="minutesWalk3" maxlength="3"/>
	                                            	<form:hidden path="displayNumber3" value="3"/>
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
	                                            	<form:input class="form-control" path="numberOfStoreys" maxlength="4"/>
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
	                                            </td>
	                                        </tr>
	                                        <form:hidden path="latitude"/>
	                                        <form:hidden path="longitude"/>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                            	<a href="${pageContext.request.contextPath}/back/backRegistBuilding" class="btn btn-warning btn-lg">戻る</a>
									<input id="buildingRegistConfirm" type="submit" class="btn btn-primary btn-lg" value="登録確認" />
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
                                                <input type="text" class="input-xlarge form-control" id="latitudeView" disabled="disabled" />
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="item_font_size">
                                                経度
                                                <input type="text" class="input-xlarge form-control" id="longitudeView" disabled="disabled" />
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

                     <div class="panel panel-default" style="display: none;">
                        <div class="panel-heading col-lg-12">
                                <span class="pull-left"> 建物画像情報</span>
                                <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
                                    <tbody>
                                        <tr>
                                            <th>
                                                <div class="imgInput">
                                                    <img alt="" class="imgView img-responsive" style="width:230px; height:200px;">
                                                    <input type="file" class="input-xlarge form-control" style="margin-bottom:3px"  id="file_upload" value="test" >
                                                    <button class="btn btn-primary uploadModalBtn" style="margin-bottom:3px"  title="ファイルパス指定" data-imgnum="01">
                                                        <i class="fa fa-cloud-upload"></i> ファイルアップロード
                                                    </button>
                                                </div>
                                            </th>
                                        </tr>
                                    </tbody>
                                </table>
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
