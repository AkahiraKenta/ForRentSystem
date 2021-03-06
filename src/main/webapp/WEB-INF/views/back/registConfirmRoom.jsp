<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/registConfirmRoom.js"></script>
		<title>部屋登録確認画面</title>
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
                    <h1 class="page-header">部屋情報登録確認</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callRegistCompleteRoom" modelAttribute="registConfirmRoomForm">
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
	                                            	<c:out value="${registConfirmRoomForm.buildingCode}" />
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
	                                            	<c:out value="${registConfirmRoomForm.buildingName}" />
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
                                <span class="pull-left">部屋登録</span>
                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                				<table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		部屋コード
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.roomCode}" />
	                                            	<form:hidden path="roomCode" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		部屋番号
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.roomNumber}" />
	                                            	<form:hidden path="roomNumber" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	階数
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.numberOfStoreysName}" />
	                                            	<form:hidden path="numberOfStoreysId" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		募集ステータス
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.recruitmentStatusName}" />
	                                            	<form:hidden path="recruitmentStatus" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	間取り
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.floorPlanName}" />
	                                            	<form:hidden path="floorPlanId" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		面積平米
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.space}" />
	                                            	<form:hidden path="space" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		賃料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.rent}" />
	                                            	<form:hidden path="rent" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	共益費有無
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.commonServiceFeeClassName}" />
	                                            	<form:hidden path="commonServiceFeeClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		共益費
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.commonServiceFee}" />
	                                            	<form:hidden path="commonServiceFee" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	管理費区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.administrativeCostClassName}" />
	                                            	<form:hidden path="administrativeCostClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		管理費
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.administrativeCost}" />
	                                            	<form:hidden path="administrativeCost" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	敷金有無
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.securityDepositClassName}" />
	                                            	<form:hidden path="securityDepositClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		敷金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.securityDeposit}" />
	                                            	<form:hidden path="securityDeposit" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	礼金有無
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.keyMoneyClassName}" />
	                                            	<form:hidden path="keyMoneyClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		礼金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.keyMoney}" />
	                                            	<form:hidden path="keyMoney" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	保険料区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.premiumClassName}" />
	                                            	<form:hidden path="premiumClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保険料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.premium}" />
	                                            	<form:hidden path="premium" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	更新料区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.renewalFeeClassName}" />
	                                            	<form:hidden path="renewalFeeClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		更新料
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.renewalFee}" />
	                                            	<form:hidden path="renewalFee" />
	                                            </td>
	                                        </tr>
	                                        <tr>
		                                        <th class="item_font_size">
	                                            	保証金区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.securityMoneyClassName}" />
	                                            	<form:hidden path="securityMoneyClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保証金
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.securityMoney}" />
	                                            	<form:hidden path="securityMoney" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		償却
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.amortization}" />
	                                            	<form:hidden path="amortization" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		保証会社必須フラグ
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.guarantyCompanyName}" />
	                                            	<form:hidden path="guarantyCompanyFlag" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		公開フラグ
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.publicationName}" />
	                                            	<form:hidden path="publicationFlag" />
	                                            </td>
	                                        </tr>

	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		契約形態
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.contractFormName}" />
	                                            	<form:hidden path="contractForm" />
	                                            </td>
	                                        </tr>

	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		引渡方法
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.deliveryMethodName}" />
	                                            	<form:hidden path="deliveryMethod" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                        	<th>
	                                            	<span title="code" class="item_font_size">
	                                            		引渡時期
	                                            	</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.deliveryTime}" />
	                                            	<form:hidden path="deliveryTime" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">契約期間</th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.contractPeriod}" />
	                                            	<form:hidden path="contractPeriod" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	注意事項
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="importantPoints" rows="10"
	                                            		value="<c:out value=${registConfirmRoomForm.importantPoints} />" readOnly="true" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	部屋PRタイトル
	                                            	<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${registConfirmRoomForm.roomPrTitle}" />
	                                            	<form:hidden path="roomPrTitle" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
	                                            	部屋PR詳細
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="roomPrDetail" rows="10"
	                                            		value="<c:out value=${registConfirmRoomForm.roomPrDetail} />" readOnly="true" />
	                                            </td>
	                                        </tr>
	                                   </tbody>
	                               </table>
	                            </div>
	                			<div class="btnBox">
									<input id="roomRegistConfirm" type="submit" name="back" class="btn btn-warning btn-lg" value="戻る" />
									<input id="roomRegistConfirm" type="submit" class="btn btn-primary btn-lg" value="登録完了" />
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
	                        			<form:hidden path="equipmentArray"/>
			                        	<c:forEach var="equipment" items="${equipmentList}" varStatus="status">
			                        		<c:if test="${status.index % 2 == 0}" >
				                        		 <tr>
				                        	</c:if>
			                        		 	<td style="border:none;">
	                        		 				<input type="checkbox" id="equipment${status.index}" name="equipmentArray" value="${equipment.id}" disabled="disabled"
	                        		 				<c:forEach var="equipmentCheck" items="${equipmentArray}" varStatus="statusCheck">
	                        		 					<c:if test="${equipment.id  == equipmentCheck}" >
	                        		 						checked="checked"
	                        		 					</c:if>
	                        		 				</c:forEach>
	                        		 				/>
													<label for="equipment${status.index}">
			                        		 			<c:out value="${equipment.name}"/>
			                        		 		</label>
			                        		 	</td>
				                        	<c:if test="${status.index % 2 == 1}" >
				                        		 <tr>
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
	                        			<form:hidden path="goodForConditionArray"/>
			                        	<c:forEach var="goodForCondition" items="${goodForConditionList}" varStatus="status">
			                        		<c:if test="${status.index % 2 == 0}" >
				                        		 <tr>
				                        	</c:if>
			                        		 	<td style="border:none;">
				                        		 	<input type="checkbox" id="goodForCondition${status.index}" name="goodForConditionArray" value="${goodForCondition.id}" disabled="disabled"
		                        		 				<c:forEach var="goodForConditionCheck" items="${goodForConditionArray}" varStatus="statusCheck">
		                        		 					<c:if test="${goodForCondition.id == goodForConditionCheck}" >
		                        		 						checked="checked"
		                        		 					</c:if>
		                        		 				</c:forEach>
	                        		 					/>
			                        		 		<label for="goodForCondition${status.index}">
			                        		 			<c:out value="${goodForCondition.name}"/>
			                        		 		</label>
			                        		 	</td>
				                        	<c:if test="${status.index % 2 == 1}" >
				                        		 <tr>
				                        	</c:if>
			                        	</c:forEach>
			                        </tbody>
			                    </table>
	                        </div>
	                    </div>
		            </div><!-- /.col-lg-4 -->
                 </form:form>
            </div><!-- /.row -->

        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>