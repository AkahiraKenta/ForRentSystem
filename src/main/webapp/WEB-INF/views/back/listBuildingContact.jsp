<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/listBuildingContact.js"></script>
		 <script src="${pageContext.request.contextPath}/resources/js/part/pager.js"></script>
		<title>物件お問合せ一覧画面</title>
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
                    <h1 class="page-header">物件お問合せ一覧</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callSearchBuildingContact" modelAttribute="buildingContactForm" name="searchBuildingContactForm">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left"> 検索条件</span>
	                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-body">
                           		<div class="input-group">
                               		<label style="margin-right:5px">処理ステータス</label>
                               		<form:select path="searchProcessStatus" items="${processStatusList}" itemLabel="name" itemValue="id" onChange="document.searchBuildingContactForm.submit();return false;"/>
                               	</div>
							</div>
	                    </div>
	                    <!-- /.panel -->
                	</div>

                	<div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">物件一覧</span>
	                            <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                        	<form:form method="post" action="${pageContext.request.contextPath}/back/callDetailBuildingContact" modelAttribute="buildingContactForm">
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
										<%--
											<div class="input-group pull-right" style="margin-bottom:5px">
												<form:select path="processStatus" items="${processStatusList}" itemLabel="name" itemValue="id" style="margin-right:5px"></form:select>
												<input id="updateProcessStatus" type="submit" class="btn btn-primary btn-xs" value="処理ステータス一括更新" />
											</div>
										 --%>
										<table class="table table-striped table-bordered table-hover table-condensed">
											<thead>
												<tr>
													<th>
														No
													</th>
													<th>
														日時
													</th>
													<th>
														ステータス
													</th>
													<th>
														物件名
													</th>
													<th>
														氏名
													</th>
													<th style="width: 36px;">
													</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="buildingContact" items="${buildingContactList}">
													<form:hidden path="buildingId" value="${buildingContact.buildingId}"/>
													<form:hidden path="roomId" value="${buildingContact.roomId}"/>
													<tr id="listBuildingContact_${buildingContact.buildingContactId}">
														<td>
															${buildingContact.buildingContactId}
														</td>
														<td>
															${buildingContact.created}
														</td>
														<td>
															<c:forEach  var="processStatus" items="${processStatusList}">
																<c:if test="${buildingContact.processStatus == processStatus.id}">
																	${processStatus.name}
																</c:if>
															</c:forEach>
		                                    			</td>
														<td>
															${buildingContact.buildingName}
															<c:if test="${buildingContact.roomNumber != null && buildingContact.roomNumber != ''}">
																${buildingContact.roomNumber}号室
															</c:if>
														</td>
														<td>
															${buildingContact.lastName}
															${buildingContact.firstName}
														</td>
											 			<td>
											 				<input id="newsEdit"type="button" class="btn btn-info btn-xs" value="詳細"
											 					onclick="location.href = '${pageContext.request.contextPath}/back/detailBuildingContact?buildingContactId=${buildingContact.buildingContactId}'"/>
														</td>
		                                    		</tr>
		                                    	</c:forEach>
		                                   </tbody>
		                               </table>
                                       <%@ include file="parts/pager.jsp" %>
		                            </div>
	                            </form:form>
	                        </div>
			            </div>
					</div>
					<div class="btnBox">
						<a href="${pageContext.request.contextPath}/back/manageTop" class="btn btn-warning btn-md">戻る</a>
					</div>
               	</form:form>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>