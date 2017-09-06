<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/systemUser.js"></script>
		<title>システムユーザー管理画面</title>
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
	                    <h1 class="page-header">システムユーザー管理</h1>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	            <div class="row">
	                <div class="col-lg-7">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">システムユーザー一覧</span>
	                            <span class="pull-right">
	                                 <a href="${pageContext.request.contextPath}/back/registSystemUser" id="addSystemUser" class="selectModalBtn">
	                                	システムユーザー追加
	                                	<i class="fa fa-arrow-circle-right"></i>
	                                </a>
	                            </span>
	                            <div class="clearfix"></div>
	                        </div>
							<div id="resultMessage" style="padding-top:10px">
								<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
							</div>
							<div>
								<h3 class="text-center text-success">
									<strong>
										<c:out value="${message}"></c:out>
									</strong>
								</h3>
							</div>
	                        <div class="panel-body">
	                        	<form id="structureForm" method="post" action="${pageContext.request.contextPath}/back/systemUser">
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
														ユーザーID
		                                            </th>
		                                            <th>
		                                            	ユーザー名
		                                            </th>
		                                            <th>
		                                            	ユーザー区分
		                                            </th>
		                                            <th>
		                                            	有効・無効
		                                            </th>
													<th style="width: 248px;"></th>
		                                		</tr>
		                                	</thead>
		                                    <tbody id="sortable">
		                                    	<c:forEach var="systemUserDto" items="${systemUserDtoList}">
		                                    		<tr>
		                                    			<td>
		                                    				<c:out value="${systemUserDto.systemUserId}"></c:out>
														</td>
		                                    			<td>
		                                    				<c:out value="${systemUserDto.systemUserName}"></c:out>
														</td>
														<td>
		                                    				<c:out value="${systemUserDto.systemUserClassName}"></c:out>
														</td>
														<td>
															<c:out value="${systemUserDto.availableFlagName}"></c:out>
														</td>
		                                    			<td>
		                                    				<input type="hidden" id="systemUserId${systemUserDto.systemUserId}" value="${systemUserDto.systemUserId}"/>
		                                    				<a id="${systemUserDto.systemUserId}" href="#" class="btn btn-primary btn-sm editSystemUserPassword">パスワード変更</a>
		                                    				<a href="${pageContext.request.contextPath}/back/callEditSystemUser?systemUserId=${systemUserDto.systemUserId}" class="btn btn-primary btn-sm">更新</a>
		                                    				<a href="#" class="btn btn-danger btn-sm deleteSystemUser">削除</a>
														</td>
		                                    		</tr>
		                                    	</c:forEach>
		                                   </tbody>
		                               </table>
		                            </div>
								</form>
							</div>
                            <%-- パスワード変更ダイアログ --%>
							<div class="modal fade" id="selectModal" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">
								<div class="modal-dialog">
				            		<div class="modal-content">
				            			<div class="modal-header bg-primary">
				            				<button type="button" class="close" data-dismiss="modal">
					            				<span aria-hidden="true">&times;</span>
					            				<span class="sr-only">Close</span>
				            				</button>
		                                    <h4 class="modal-title" id="UploadModalLabel">パスワード変更</h4>
				            			</div>
	           							<form:form id="systemUserForm" modelAttribute="systemUserForm" method="post" action="${pageContext.request.contextPath}/back/changePassword" >
	            							<div id="errorArea">
	            								<h5 class="text-center text-error">
													<strong>
														<p id ="errorMessage" style="color:#FF0000"></p>
													</strong>
												</h5>
	            							</div>
	            							<div class="modal-body">
		            							<div class="panel-heading">
		            								<input type="hidden" id="hiddenSystemUserId" value=""/>
													<table>
														<tr>
															<th>現在のパスワード</th>
															<td>
																<form:password path="systemUserPassword"/>
															</td>
														</tr>
														<tr>
															<th>新パスワード</th>
															<td>
																<form:password path="systemUserNewPassword"/>
															</td>
														</tr>
														<tr>
															<th>新パスワード(確認用)</th>
															<td>
																<form:password path="systemUserNewPasswordConfirm"/>
															</td>
														</tr>
													</table>
												</div>
											</div>

											<div class="modal-footer">
					            				 <button id="dialogEditSystemUserPassword" type="button" class="btn btn-default">パスワード変更</button>
					            				 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					            			</div>
				            			</form:form>
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
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
