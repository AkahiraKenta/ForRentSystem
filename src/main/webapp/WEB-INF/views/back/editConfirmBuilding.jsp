<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<title>建物編集確認画面</title>
	</head>
    <body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <%@ include file="./parts/header.jsp" %>
            <%@ include file="./parts/menu.jsp" %>
        </nav>
       <!-- Page Content -->
        <div id="page-wrapper">
            <div class="row disnon">
                <div class="col-lg-12">
                    <ol class="breadcrumb">
                        <li><a href="./back/">トップ</a></li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">建物情報編集確認</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<form:form method="post" action="${pageContext.request.contextPath}/back/callEditConfirmBuilding" modelAttribute="editConfirmBuildingForm">
	                <div class="col-lg-8">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left">編集確認</span>
	                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<form:hidden path="buildingId"/>
	                                        <tr>
	                                        	<th>
                                            		建物番号
	                                            </th>
	                                            <td>
		                                            <c:out value="${editConfirmBuildingForm.buildingCode}" />
													<form:hidden path="buildingCode" />
												</td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	建物名称
	                                            </th>
	                                            <td>
		                                            <c:out value="${editConfirmBuildingForm.buildingName}" />
	                                            	<form:hidden path="buildingName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                            	建物種別
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.buildingTypeName}" />
	                                                <form:hidden path="buildingType" />
	                                                <form:hidden path="buildingTypeName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                            	〒
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.zipCode}" />
	                                                <form:hidden path="zipCode" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                            	都道府県
	                                            </th>
	                                            <td>
		                                            <c:out value="${editConfirmBuildingForm.province}" />
	                                                <form:hidden path="province" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                            	市区町村
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.cityName}" />
	                                                <form:hidden path="cityName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                            	町域
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.townAreaName}" />
	                                                <form:hidden path="townAreaName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th>
	                                           		町域以下
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.townAreaBelow}" />
	                                                <form:hidden path="townAreaBelow" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestRouteName1}" />
	                                                <form:hidden path="nearestRoute1" />
	                                                <form:hidden path="nearestRouteName1" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestStationName1}" />
	                                                <form:hidden path="nearestStation1" />
	                                                <form:hidden path="nearestStationName1" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.minutesWalk1}" />
	                                                <form:hidden path="minutesWalk1" />
	                                                <form:hidden path="displayNumber1" value="1"/>
	                                            </td>
	                                        </tr>
	                                         <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestRouteName2}" />
	                                                <form:hidden path="nearestRoute2" />
	                                                <form:hidden path="nearestRouteName2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestStationName2}" />
	                                                <form:hidden path="nearestStation2" />
	                                                <form:hidden path="nearestStationName2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.minutesWalk2}" />
	                                                <form:hidden path="minutesWalk2" />
	                                                <form:hidden path="displayNumber2" value="2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestRouteName3}" />
	                                                <form:hidden path="nearestRoute3" />
	                                                <form:hidden path="nearestRouteName3" />
	                                            </td>
	                                        </tr>
	                                         <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.nearestStationName3}" />
	                                                <form:hidden path="nearestStation3" />
	                                                <form:hidden path="nearestStationName3" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editConfirmBuildingForm.minutesWalk3}" />
	                                                <form:hidden path="minutesWalk3" />
	                                                <form:hidden path="displayNumber3" value="3" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                       		<th>
	                                            	築年月（年）
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.builtYear}" />
	                                                <form:hidden path="builtYear" />
	                                            </td>
	                                        </tr>
											<tr>
	                                       		<th>
	                                            	築年月（月）
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.builtMonth}" />
	                                                <form:hidden path="builtMonth" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                       		<th>
	                                            	階建
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.numberOfStoreys}" />
	                                                <form:hidden path="numberOfStoreys" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                       		<th>
	                                            	構造
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.structureName}" />
	                                                <form:hidden path="structureId" />
	                                            </td>
	                                        </tr>
	                                       <tr>
	                                       		<th>
	                                            	建物PRタイトル
	                                            </th>
	                                            <td>
	                                                <c:out value="${editConfirmBuildingForm.prTitle}" />
	                                                <form:hidden path="prTitle" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                       		<th>
	                                            	建物PR詳細
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="prDetail" rows="10"
	                                                	value="<c:out value=${editConfirmBuildingForm.prDetail} />" readOnly="true" />
	                                            </td>
	                                        </tr>
	                                         <form:hidden path="latitude" />
	                                         <form:hidden path="longitude" />
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                            	<input id="search" type="submit" name="back" class="btn btn-warning btn-lg" value="戻る" />
									<input id="search" type="submit" class="btn btn-primary btn-lg" value="編集完了" />
								</div>
	                        </div>
	                    </div>
	                    <!-- /.panel -->
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
				                                <c:out value="${editConfirmBuildingForm.latitude}" />
				                            </th>
				                        </tr>
				                        <tr>
				                            <th class="item_font_size">
				                                経度
				                                <c:out value="${editConfirmBuildingForm.longitude}" />
				                            </th>
				                        </tr>
				                    </tbody>
				                </table>
				            </div>
				        </div>
				     </div>
				     <script type="text/javascript">
				        $(document).ready(function(){
				            initialize();
				        });

				        // ページ読み込み完了時に実行する関数
				        function initialize() {

				            // 初期位置
				            var initialPlace = new google.maps.LatLng($("#latitude").val(), $("#longitude").val());

				            // マップ表示
				            var gMap = new google.maps.Map(document.getElementById("map"), {
				                center: new google.maps.LatLng(document.getElementById('latitude').value, document.getElementById('longitude').value),
				                rotateControl: false,
				                streetViewControl: false,
				                panControl: false,
				                mapTypeControl: false,
				                zoom:18,
				                mapTypeId: google.maps.MapTypeId.ROADMAP
				            });

				            // ドラッグできるマーカーを表示
				            var marker = new google.maps.Marker({
				                position: new google.maps.LatLng(document.getElementById('latitude').value, document.getElementById('longitude').value),
				                title: "",
				                draggable: false
				            });
				            marker.setMap(gMap);
				        }
				     </script>
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
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>