<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/floorPlan.js"></script>
		<title>間取り管理画面</title>
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
                    <h1 class="page-header">間取り管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">間取り一覧</span>
                            <span class="pull-right">
                                <a href="#" id="addFloorPlan" class="selectModalBtn">
                                	間取り追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </span>
                            <div class="clearfix"></div>
                        </div>
                      	<form id="floorPlanForm" method="post" action="${pageContext.request.contextPath}/back/listFloorPlan">
							<div id="resultMessage" style="padding-top:10px">
								<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
							</div>
	                        <div class="panel-body">
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
													間取り名称
	                                            </th>
	                                            <th style="width: 128px;"></th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="floorPlan" items="${floorPlanList}">
	                                    		<tr id="listFloorPlan_${floorPlan.floorPlanId}">
	                                    			<td>
														<input type="text" class="form-control" id="floorPlanName_${floorPlan.floorPlanId}" value="${floorPlan.floorPlanName}"/>
													</td>
	                                    			<td>
	                                    				<button type="button" id="updateFloorPlan_${floorPlan.floorPlanId}" name="updateFloorPlan" class="btn btn-primary btn-sm">更新</button>
	                                    				<button type="button" id="deleteFloorPlan_${floorPlan.floorPlanId}" name="deleteFloorPlan" class="btn btn-danger btn-sm">削除</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                        </div>
						</form>
		            </div>
				</div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
