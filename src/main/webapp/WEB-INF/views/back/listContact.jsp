<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/listContact.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/pager.js"></script>
		<title>お問合せ一覧画面</title>
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
                    <h1 class="page-header">お問合せ一覧</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callSearchContact" modelAttribute="contactForm" name="searchContactForm">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left"> 検索条件</span>
	                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-body">
                           		<div class="input-group">
                               		<label style="margin-right:5px">処理ステータス</label>
                               		<form:select path="searchProcessStatus" items="${processStatusList}" itemLabel="name" itemValue="id" onChange="document.searchContactForm.submit(); return false;"/>
                               	</div>
							</div>
	                    </div>
	                    <!-- /.panel -->
                	</div>

                	<div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">お問合せ一覧</span>
	                            <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                        	<form:form method="post" action="${pageContext.request.contextPath}/back/callDetailContact" modelAttribute="contactForm">
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
														No
													</th>
													<th>
														日時
													</th>
													<th>
														ステータス
													</th>
													<th>
														会社名
													</th>
													<th>
														氏名
													</th>
													<th style="width: 36px;">
													</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="contact" items="${contactList}">
													<tr id="listcontact_${contact.contactId}">
														<td>
															${contact.contactId}
														</td>
														<td>
															${contact.created}
														</td>
														<td>
															<c:forEach  var="processStatus" items="${processStatusList}">
																<c:if test="${contact.processStatus == processStatus.id}">
																	${processStatus.name}
																</c:if>
															</c:forEach>
		                                    			</td>
														<td>
															${contact.companyName}
														</td>
														<td>
															${contact.lastName}
															${contact.firstName}
														</td>
											 			<td>
											 				<input id="newsEdit"type="button" class="btn btn-info btn-xs" value="詳細"
											 					onclick="location.href = '${pageContext.request.contextPath}/back/detailContact?contactId=${contact.contactId}'"/>
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
						<a href="${pageContext.request.contextPath}/back/manageTop" class="btn btn-warning btn-lg">戻る</a>
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