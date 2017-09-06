<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/googleMap/googleMapFunction.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/detailBuilding.js"></script>
		<title>建物詳細画面</title>
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
                    <h1 class="page-header">建物情報詳細</h1>
                </div>
            </div>
            <div class="row">
	            <form:form method="post" action="${pageContext.request.contextPath}/back/callEditBuilding" modelAttribute="detailBuildingForm">
	                <div class="col-lg-8">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
                                <span class="pull-left"> 詳細確認</span>
                                <div class="clearfix"></div>
	                        </div>
							<div>
								<h3  class="text-center text-success">
									<strong>
										<c:out value="${message}"></c:out>
									</strong>
								</h3>
							</div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                        <form:hidden path="buildingId" id="buildingId"/>
	                                        <tr>
	                                            <th>
	                                            	<span title="code" class="item_font_size">
	                                            		建物番号
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.buildingCode}" />
													<form:hidden path="buildingCode" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	建物名称
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.buildingName}" />
	                                            	<form:hidden path="buildingName" />
	                                            </td>

	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	建物種別
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.buildingTypeName}" />
	                                                <form:hidden path="buildingType" />
	                                                 <form:hidden path="buildingTypeName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">〒</th>
	                                            <td>
													<c:out value="${detailBuildingForm.zipCode}" />
	                                                <form:hidden path="zipCode" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	都道府県
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.province}" />
	                                                <form:hidden path="province" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	市区町村
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.city}" />
	                                                <form:hidden path="city" />
                                            	</td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	町域
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.townArea}" />
	                                                <form:hidden path="townArea" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	町域以下
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.townAreaBelow}" />
	                                                <form:hidden path="townAreaBelow" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestRouteName1}" />
	                                                <form:hidden path="nearestRoute1" />
	                                                <form:hidden path="nearestRouteName1" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestStationName1}" />
	                                                <form:hidden path="nearestStation1" />
	                                                <form:hidden path="nearestStationName1" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅1(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.minutesWalk1}" />
	                                                <form:hidden path="minutesWalk1" />
	                                            </td>
	                                        </tr>
	                                         <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestRouteName2}" />
	                                                <form:hidden path="nearestRoute2" />
	                                                <form:hidden path="nearestRouteName2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestStationName2}" />
	                                                <form:hidden path="nearestStation2" />
	                                                <form:hidden path="nearestStationName2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅2(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.minutesWalk2}" />
	                                                <form:hidden path="minutesWalk2" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(沿線)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestRouteName3}" />
	                                                <form:hidden path="nearestRoute3" />
	                                                <form:hidden path="nearestRouteName3" />
	                                            </td>
	                                        </tr>
	                                         <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(駅)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.nearestStationName3}" />
	                                                <form:hidden path="nearestStation3" />
	                                                <form:hidden path="nearestStationName3" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	最寄駅3(徒歩分)
	                                            </th>
	                                            <td>
	                                            	<c:out value="${detailBuildingForm.minutesWalk3}" />
	                                                <form:hidden path="minutesWalk3" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	築年月（年）
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.builtYear}" />
	                                                <form:hidden path="builtYear" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	築年月（月）
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.builtMonth}" />
	                                                <form:hidden path="builtMonth" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	階建
	                                            </th>
	                                            <td class="col-sm-10">
													<c:out value="${detailBuildingForm.numberOfStoreys}" />
	                                                <form:hidden path="numberOfStoreys" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	構造
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.structureName}" />
	                                                <form:hidden path="structureId" />
	                                                <form:hidden path="structureName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	建物PRタイトル
	                                            </th>
	                                            <td>
													<c:out value="${detailBuildingForm.prTitle}" />
	                                                <form:hidden path="prTitle" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	建物PR詳細
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="prDetail" rows="10"
	                                                	value="<c:out value=${detailBuildingForm.prDetail} />" readOnly="true" />
	                                            </td>
	                                        </tr>
	                                        <form:hidden path="latitude" />
	                                         <form:hidden path="longitude" />
	                                   </tbody>
	                               </table>
	                            </div>
		                        <div class="btnBox">
									<a href="${pageContext.request.contextPath}/back/backDetailBuilding" class="btn btn-warning btn-lg">戻る</a>
									<input id="edit" type="submit" class="btn btn-primary btn-lg" value="編集" />
									<a id="deleteBuilding" href="#" class="btn btn-danger btn-lg">削除</a>
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
												<c:out value="${detailBuildingForm.latitude}" />
                                            </th>
                                        </tr>
                                        <tr>
                                            <th class="item_font_size">
                                                経度
												<c:out value="${detailBuildingForm.longitude}" />
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
                               <div id="addImageLink">
	                               <span class="pull-right">
	                                   <a href="#" class="imageFileUploadBtn">
	                                   	画像追加
	                                   	<i class="fa fa-arrow-circle-right"></i>
	                                   </a>
	                               </span>
                               </div>
                               <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
   							<div>
								<h3 id="messageH3" class="text-center">
									<strong>
										<p id="message"></p>
									</strong>
								</h3>
							</div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
                                    <tbody>
                           				<tr>
											<th>
												<form id="imageDeleteForm" method="post" action="${pageContext.request.contextPath}/back/imageDeleteForm">
                                                	<div class="imgInput">
                                                		<c:if test="${buildingImage != null }">
                                                			<div id="imageDiv_${buildingImage.imageId}">
	                                                			<c:out value="${buildingImage.imageCaption}"></c:out>
															 	<img id="imageView_${buildingImage.imageId}" alt="" class="imgView img-responsive" src="${filePath}${buildingImage.buildingId}/${buildingImage.fileName}" style="width:130px; height:100px;">
																<button id="imageDelete_${buildingImage.buildingId}_${buildingImage.imageId}" name="imageDelete" type="button" style="margin-bottom:15px" class="btn btn-danger btn-sm">削除</button>
															</div>
														</c:if>
                                                	</div>
	                                            </form>
											</th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
	            <div class="col-lg-8">
		            <div class="panel panel-default">
                        <div class="panel-heading">
                                <span class="pull-left">部屋一覧</span>
                                <span class="pull-right">
                                    <form:form id="registRoom" method="post" action="${pageContext.request.contextPath}/callRegistRoom" modelAttribute="detailBuildingForm" name="detailBuildingForm">
                                        <a href="${pageContext.request.contextPath}/back/callRegistRoomForDetailBuilding?buildingId=${detailBuildingForm.buildingId}" class="selectModalBtn">
                                        	部屋登録
                                        	<i class="fa fa-arrow-circle-right"></i>
                                    	</a>
                                    </form:form>
                                </span>
                                <div class="clearfix"></div>
                        </div>

		                <div class="panel-body">
		                    <div class="table-responsive">
		                        <table class="table table-striped table-bordered table-hover " id="edit-mainDataList">
		                            <form:form method="post" action="${pageContext.request.contextPath}/back/callDetailRoom" modelAttribute="listRoomsForm">
			                             <thead>
			                                 <tr>
			                                     <th>
			                                         部屋コード
			                                     </th>
			                                     <th>
			                                         部屋番号
			                                     </th>
			                                     <th>
			                                         募集ステータス
			                                     </th>
			                                     <th style="width:100px;"></th>
			                                 </tr>
			                             </thead>
			                             <tbody>
			                             	<c:forEach var="rooms" items="${listRoomsForm}">
												<tr>
													<td>${rooms.roomCode}</td>
													<td>${rooms.roomNumber}</td>
													<td>${rooms.recruitmentStatusName}</td>
													<td>
														<input id="roomsDetail"type="button" class="btn btn-info btn-xs" value="詳細"
															onclick="location.href = '${pageContext.request.contextPath}/back/callDetailRoom?buildingId=${rooms.buildingId}&roomId=${rooms.roomId}&transactionFlag=1'"/>
														<input id="roomsDetailDelete"type="button" class="btn btn-danger btn-xs" value="削除"
															onclick="location.href = '${pageContext.request.contextPath}/back/callDetailRoomDelete?buildingId=${rooms.buildingId}&roomId=${rooms.roomId}&transactionFlag=2'"/>
													</td>
												</tr>
											</c:forEach>
			                            </tbody>
		                        	</form:form>
		                    	</table>
		                	</div>
		            	</div>
		        	</div>
		        </div>
		    </div>
        </div>

        <%-- ファイルアップロードダイアログ --%>
        <script src="${pageContext.request.contextPath}/resources/js/part/imageFileUpload.js"></script>
        <%@ include file="./parts/imageFileUpload.jsp" %>
		<%@ include file="./parts/footer.jsp" %>
    </div>
    </body>
</html>