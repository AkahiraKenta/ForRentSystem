<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>こだわり条件管理画面</title>
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
                    <h1 class="page-header">こだわり条件管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">こだわり条件一覧</span>
                            <span class="pull-right">
                                <a href="#" id="addGoodForCondition" class="selectModalBtn">
                                	こだわり条件追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </span>
                            <div class="clearfix"></div>
                        </div>
						<div id="resultMessage" style="padding-top:10px">
							<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
						</div>
                        <div class="panel-body">
                        	<form id="goodForConditionForm" method="get" action="${pageContext.request.contextPath}/back/deleteGoodForCondition">
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
	                                                表示順
	                                            </th>
	                                            <th >
	                                                条件名称
	                                            </th>
	                                            <th style="width: 128px;"></th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="goodForCondition" items="${goodForConditionList}">
	                                    		<tr id="goodForCondition_${goodForCondition.conditionId}">
	                                    			<td class="rank">
														${goodForCondition.displayNumber}
													</td>
	                                    			<td>
														<input type="text" class="form-control" id="conditionName_${goodForCondition.conditionId}" value="${goodForCondition.conditionName}"/>
													</td>
	                                    			<td>
	                                    				<input type="hidden" id="conditionId_${goodForCondition.conditionId}" name="conditionId" value="${goodForCondition.conditionId}"/>
	                                    				<button type="button" id="updateGoodForCondition_${goodForCondition.conditionId}" name="updateGoodForCondition" class="btn btn-primary btn-sm">更新</button>
	                                    				<button type="button" id="deleteGoodForCondition_${goodForCondition.conditionId}" name="deleteGoodForCondition" class="btn btn-danger btn-sm">削除</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div id="saveButton" class="btnBox">
	                                <button type="button" id="updateGoodForConditionDisplayNumber" class="btn btn-primary btn-md">保存</button>
	                            </div>
                            </form>
                        </div>
		            </div>
				</div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/part/goodForCondition.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
