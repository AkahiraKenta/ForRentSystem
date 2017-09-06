<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/editRoom.js"></script>
		<title>部屋編集画面</title>
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
                    <h1 class="page-header">部屋情報編集</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callEditConfirmRoom" modelAttribute="editRoomsForm">
	                <div class="col-lg-8">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
                                <span class="pull-left">建物情報</span>
                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<form:hidden path="buildingId"/>
	                                    	<tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		建物番号
	                                            	</span>
	                                            </th>

	                                            <td>
	                                            	<c:out value="${editRoomsForm.buildingCode}" />
													<form:hidden path="buildingCode" />
	                                            </td>
	                                        </tr>
											<tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		建物名称
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${editRoomsForm.buildingName}" />
	                                            	<form:hidden path="buildingName" />
	                                            </td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
                                <span class="pull-left"> 部屋情報編集</span>
                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<form:hidden path="roomId"/>
	                                    	<tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		部屋コード
	                                            		<span class="label label-danger">必須</span>
	                                            	</span>
	                                            </th>

	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="roomCode" maxlength="20"/>
	                                            	<form:errors path="roomCode" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		部屋番号
	                                            		<span class="label label-danger">必須</span>
	                                            	</span>
	                                            </th>

	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="roomNumber" maxlength="20"/>
	                                            	<form:errors path="roomNumber" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	階数
	                                            </th>
	                                            <td>
	                                            	<form:select path="numberOfStoreysId"  items="${floorList}" itemLabel="floorName" itemValue="floorClassId">
													</form:select>
	                                            </td>
	                                            <form:hidden path="numberOfStoreysName"/>
	                                        </tr>
	                                        <tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		募集ステータス
	                                            	</span>
	                                            </th>

	                                            <td>
	                                            	<form:select path="recruitmentStatus"  items="${recruitmentStatusList}" itemLabel="name" itemValue="id">
													</form:select>
	                                            	<form:hidden path="recruitmentStatusName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	間取り
	                                            </th>
	                                            <td>
	                                            	<form:select path="floorPlanId"  items="${floorPlanList}" itemLabel="floorPlanName" itemValue="floorPlanId">
													</form:select>
	                                            </td>
	                                            <form:hidden path="floorPlanName"/>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		面積平米
	                                            	</span>
	                                            </th>
	                                            <td>
													<form:input class="input-xlarge form-control" path="space" maxlength="6"/>
													<form:errors path="space" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		賃料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="rent" maxlength="9"/>
	                                            	<form:errors path="rent" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	共益費有無
	                                            </th>
	                                            <td>
	                                            	<form:select path="commonServiceFeeClass" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="commonServiceFeeClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		共益費
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="commonServiceFee" maxlength="9"/>
	                                            	<form:errors path="commonServiceFee" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	管理費区分
	                                            </th>
	                                            <td>
	                                            	<form:select path="administrativeCostClass" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="administrativeCostClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		管理費
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="administrativeCost" maxlength="9"/>
	                                            	<form:errors path="administrativeCost" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	敷金有無
	                                            </th>
	                                            <td>
	                                            	<form:select path="securityDepositClass" items="${securityDepositClassList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="securityDepositClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		敷金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="securityDeposit" maxlength="9"/>
	                                            	<form:errors path="securityDeposit" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	礼金有無
	                                            </th>
	                                            <td>
	                                            	<form:select path="keyMoneyClass" items="${keyMoneyClassList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="keyMoneyClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		礼金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="keyMoney" maxlength="9"/>
	                                            	<form:errors path="keyMoney" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	保険料区分
	                                            </th>
	                                            <td>
	                                            	<form:select path="premiumClass" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="premiumClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保険料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="premium" maxlength="9"/>
	                                            	<form:errors path="premium" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                         <tr>
		                                        <th class="item_font_size">
	                                            	更新料区分
	                                            </th>
	                                            <td>
	                                            	<form:select path="renewalFeeClass" items="${renewalFeeClassList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="renewalFeeClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		更新料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="renewalFee" maxlength="9"/>
	                                            	<form:errors path="renewalFee" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	保証金区分
	                                            </th>
	                                            <td>
	                                            	<form:select path="securityMoneyClass" items="${securityMoneyClassList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="securityMoneyClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保証金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="securityMoney" maxlength="9"/>
	                                            	<form:errors path="securityMoney" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		償却
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="amortization" maxlength="9"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保証会社必須フラグ
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:select path="guarantyCompanyFlag" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="guarantyCompanyName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		公開フラグ
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:select path="publicationFlag" items="${publicationFlag}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="publicationName"/>
	                                            </td>
	                                        </tr>

	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		契約形態
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:select path="contractForm"  items="${contractFormList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="contractFormName"/>
	                                            </td>
	                                        </tr>

	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		引渡方法
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:select path="deliveryMethod"  items="${delivaryMethodList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="deliveryMethodName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		引渡時期
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="deliveryTime" maxlength="20"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">契約期間</th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="contractPeriod" maxlength="20"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	注意事項
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="importantPoints" rows="10"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	部屋PRタイトル
	                                            	<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="roomPrTitle" maxlength="200"/>
	                                            	<form:errors path="roomPrTitle" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	部屋PR詳細
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="roomPrDetail" rows="10"/>
	                                            </td>
	                                        </tr>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
									<a href="${pageContext.request.contextPath}/back/backEditRoom?buildingId=${editRoomsForm.buildingId}&roomId=${editRoomsForm.roomId}" class="btn btn-warning btn-lg">戻る</a>
									<input id="edit" type="submit" class="btn btn-primary btn-lg" value="編集確認" />
								</div>
	                        </div>
	                    </div>
	                    <!-- /.panel -->
	                </div>
	                <div class="col-lg-4">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left"> 設備</span>
	                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body" >
	                        	<table class="table" style="font-size:small;">
	                        		<tbody>
			                        	<c:forEach var="equipment" items="${equipmentList}" varStatus="status">
			                        		<c:if test="${status.index % 2 == 0}" >
				                        		 <tr>
				                        	</c:if>
			                        		 	<td style="border:none;">
	                        		 				<input type="checkbox" id="equipment${status.index}" name="equipmentArray" value="${equipment.id}"
	                        		 				<c:forEach var="roomEquilpment" items="${roomEquilpmentIdList}" varStatus="statusCheck">
	                        		 					<c:if test="${equipment.id  == roomEquilpment}" >
	                        		 						checked="checked"
	                        		 					</c:if>
	                        		 				</c:forEach>
	                        		 				/>
			                        		 		<label for="equipment${status.index}">
			                        		 			<c:out value="${equipment.name}"/>
			                        		 		</label>
			                        		 	</td>
				                        	<c:if test="${status.index % 2 == 1}" >
				                        		 </tr>
				                        	</c:if>
			                        	</c:forEach>
			                        </tbody>
			                    </table>
	                        </div>
	                    </div>

	                    <div class="panel panel-default">
                       		<div class="panel-heading">
	                                <span class="pull-left"> こだわり条件</span>
	                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body" >
	                        	<table class="table" style="font-size:small;">
	                        		<tbody>
			                        	<c:forEach var="goodForCondition" items="${goodForConditionList}" varStatus="status">
			                        		<c:if test="${status.index % 2 == 0}" >
				                        		 <tr>
				                        	</c:if>
			                        		 	<td style="border:none;">
			                        		 		<input type="checkbox" id="goodForCondition${status.index}" name="goodForConditionArray" value="${goodForCondition.id}"
				                        		 	<c:forEach var="roomGoodForCondition" items="${roomGoodForConditionIdList}" varStatus="statusCheck">
		                        		 					<c:if test="${goodForCondition.id == roomGoodForCondition}" >
		                        		 						checked="checked"
		                        		 					</c:if>
	                        		 				</c:forEach>
	                        		 				/>
	                        		 				<label for="goodForCondition${status.index}">
			                        		 			<c:out value="${goodForCondition.name}"/>
			                        		 		</label>
			                        		 	</td>
				                        	<c:if test="${status.index % 2 == 1}" >
				                        		 </tr>
				                        	</c:if>
			                        	</c:forEach>
			                        </tbody>
			                    </table>
	                        </div>
	                    </div>

		            </div><!-- /.col-lg-4 -->
				</form:form>

				<div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left"> 部屋画像情報</span>
                            <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
                                    <tbody>
                                        <tr>
                                            <th>
	                                            <div class="imgRoomInput">
                                               		<c:forEach var="roomImage" items="${roomImageList}" varStatus="status">
													 	<div id="imageDiv_${roomImage.imageId}">
													 		<c:out value="${roomImage.imageCaption}"></c:out>
													 		<img id="imageView_${roomImage.imageId}" alt="" class="imgView img-responsive" src="${filePath}${roomImage.buildingId}/${roomImage.roomId}/${roomImage.fileName}" style="margin-bottom:15px; width:130px; height:100px;">
														</div>
													</c:forEach>
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
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>