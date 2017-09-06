<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>人気駅設定画面</title>
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
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">人気駅設定</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">人気駅情報一覧</span>
                            <span class="pull-right">
                                <a href="#" id="addPopularityStation" class="selectModalBtn">
                                	人気駅追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>

                            </span>
                            <div class="clearfix"></div>
                        </div>
						<div id="resultMessage" style="padding-top:10px">
							<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
						</div>
                        <div class="panel-body">
                        	<form id="popularityStationForm" method="post" action="${pageContext.request.contextPath}/back/deletePopularityStation">
	                            <div class="table-responsive">
	                            	<div class="row">
	                            		<div class="col-sm-6">
	                            			<div class="dataTables_length">
	                            			</div>
	                            		</div>
	                            		<div class="col-sm-6">
	                            			<div class="dataTables_filter">

	                            			</div>
	                            		</div>
	                            	</div>
                            		<table class="table table-striped table-bordered table-hover table-condensed">
	                                	<thead>
	                                		<tr>
	                                			<th>
	                                                順位
	                                            </th>
	                                			<!--
	                                			<th>
	                                                駅ID
	                                            </th>
	                                             -->
	                                            <th >
	                                                駅名称
	                                            </th>
	                                            <th style="width: 36px;">
	                                            </th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="popularityStation" items="${popularityStationList}">
	                                    		<tr id="popularityStation_${popularityStation.stationId}">
	                                    			<td class="rank">
														${popularityStation.rank}
													</td>
													<!--
	                                    			<td>
	                                    				${popularityStation.stationId}
	                                    			</td>
	                                    			 -->
                                    			 	<td>
	                                    				${popularityStation.stationName}
	                                    				<input type="hidden" id="popularityStationId_${popularityStation.stationId}" name="popularityStationId" value="${popularityStation.stationId}"/>
	                                    			</td>
	                                    			<td>
	                                    				<button type="button" id="deletePopularityStation" class="btn btn-danger btn-xs">削除</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                                <button type="button" id="updatePopularityStation" class="btn btn-primary btn-md">保存</button>
	                            </div>
                            </form>
                        </div>
		            </div>
		            <%-- ダイアログ --%>
		            <div class="modal fade" id="selectModal" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">
		            	<div class="modal-dialog">
		            		<div class="modal-content">
		            			<div class="modal-header bg-primary">
		            				<button type="button" class="close" data-dismiss="modal">
			            				<span aria-hidden="true">&times;</span>
			            				<span class="sr-only">Close</span>
		            				</button>
                                    <h4 class="modal-title" id="UploadModalLabel">人気駅選択</h4>
		            			</div>
		            			<form id="stationForm" method="post" action="${pageContext.request.contextPath}/back/registPopularityStation" enctype="multipart/form-data">
			            			<div class="modal-body">
										<div>
			            					<p>
			            						沿線を選択後に、物件情報に紐付く駅情報が表示されます。
			            						<br>
			            						人気駅設定された駅情報は表示されません。
			            					</p>
			            				</div>
			            				<div class="panel-heading">
			            					沿線
			            					<select id="routeList">
		            							<option value="0"></option>
			            						<c:forEach  var="route" items="${routeList}">
			            							<option value="${route.routeId}">${route.routeName}</option>
			            						</c:forEach>
			            					</select>
			            				</div>
			            				<table id="stationTable" class="table table-striped table-bordered table-hover table-condensed">
		                                	<thead>
		                                		<tr>
		                                			<%--
		                                			<th class="header">
		                                                駅ID
		                                            </th>
		                                             --%>
		                                            <th class="header">
		                                                駅名称
		                                            </th>
		                                            <th style="width: 36px;"></th>
		                                		</tr>
		                                	</thead>
		                                    <tbody id="stationList">

		                                   </tbody>
		                               </table>
			            			</div>
			            		</form>
		            			<div class="modal-footer">
		            				 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
		            			</div>
		            		</div>
		            	</div>

		            </div>
				</div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
	<script src="${pageContext.request.contextPath}/resources/js/part/popularityStation.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
