<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/displayNumber.js"></script>
		<title>表示件数管理画面</title>
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
                    <h1 class="page-header">表示件数管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
            	<form:form modelAttribute="displayNumberForm" method="post" action="${pageContext.request.contextPath}/back/displayNumber">
	                <div class="col-lg-6">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">表示件数一覧</span>
	                            <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                        	<div id="resultMessage" style="padding-top:10px">
									<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
								</div>
	                            <div class="table-responsive">
                            		<table class="table table-striped table-bordered table-hover table-condensed">
	                                	<thead>
	                                		<tr>
	                                            <th>
													システム設定名称
	                                            </th>
	                                            <th>
	                                            	表示件数
	                                            </th>
	                                            <th style="width: 36px;"></th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="systemSetting" items="${systemSettingList}">
	                                    		<tr id="systemSetting_${systemSetting.systemSettingId}">
	                                    			<td>
														${systemSetting.systemSettingName}
													</td>
													<td>
														<c:if test="${systemSetting.systemSettingId == 1}">
															<form:select path="newArticleDisplayNumberId" items="${newArticleDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 2}">
															<form:select path="popularityStationDisplayNumberId" items="${popularityStationDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 3}">
															<form:select path="popularityAreaDisplayNumberId" items="${popularityAreaDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 4}">
															<form:select path="newsDisplayNumberId" items="${newsDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 5}">
															<form:select path="bannerDisplayNumberId" items="${bannerDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 6}">
															<form:select path="recommendedRoomDisplayNumberId" items="${recommendedRoomDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
														<c:if test="${systemSetting.systemSettingId == 7}">
															<form:select path="articleListDisplayNumberId" items="${articleListDisplayNumberList}" itemLabel="name" itemValue="id">
															</form:select>
														</c:if>
													</td>
	                                    			<td>
	                                    				<button type="button" id="updateDisplayNumber" name="updateDisplayNumber" class="btn btn-primary btn-sm">保存</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                        </div>
			            </div>
					</div>
				</form:form>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
