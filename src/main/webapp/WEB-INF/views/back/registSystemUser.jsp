<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/css/datetimepicker/origenal.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/js/datetimepicker/jquery-ui.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
		<title>システムユーザー登録画面</title>
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
            	<div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">システムユーザー登録</span>
                            <div class="clearfix"></div>
                        </div>
	                    <div class="panel-body">
	                    	<form:form method="post" action="${pageContext.request.contextPath}/back/callRegistConfirmSystemUser" modelAttribute="systemUserForm">
								<div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<tr>
	                                         	<th class="item_font_size">
	                                           		ユーザー名
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="systemUserName" maxlength="50"/>
	                                            	<form:errors path="systemUserName" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		ログインID
	                                           		<c:if test="${systemUserForm.systemUserId == -1}">
	                                           			<span class="label label-danger">必須</span>
	                                           		</c:if>
	                                            </th>
	                                            <td>
	                                            	<c:choose>
														<c:when test="${systemUserForm.systemUserId == -1}">
															<form:input class="input-xlarge form-control" path="systemUserLoginId"  maxlength="50"/>
														</c:when>
														<c:otherwise>
															<c:out value="${systemUserForm.systemUserLoginId}"></c:out>
															<form:hidden path="systemUserLoginId"/>
														</c:otherwise>
													</c:choose>

													<form:errors path="systemUserLoginId" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>

	                                        <c:if test="${systemUserForm.systemUserId == -1}">

	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		パスワード
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
													<form:password class="input-xlarge form-control" path="systemUserPassword"  maxlength="50"/>
													<form:errors path="systemUserPassword" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		パスワード(確認用)
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
													<form:password class="input-xlarge form-control" path="systemUserPasswordConfirm"  maxlength="50"/>
													<form:errors path="systemUserPasswordConfirm" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>

	                                        </c:if>

	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		ユーザー区分
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
													<form:select path="systemUserClass" items="${systemUserClassList}" itemLabel="name" itemValue="id">
													</form:select>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		メールアドレス
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
													<form:input class="input-xlarge form-control" path="systemUserAddress"  maxlength="200"/>
													<form:errors path="systemUserAddress" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		有効・無効
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
													<form:select path="availableFlag" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
	                                            </td>
	                                        </tr>
                                    	</tbody>
                                	</table>
                            	</div>
                            	<div class="btnBox">
									<a href="${pageContext.request.contextPath}/back/backSystemUserList" class="btn btn-warning btn-lg">戻る</a>
									<c:choose>
										<c:when test="${systemUserForm.systemUserId == -1}">
											<input id="registConfirmSystemUser" name="regist" type="submit" class="btn btn-primary btn-lg" value="登録確認" />
										</c:when>
										<c:otherwise>
											<input id="updateConfirmSystemUser" name="update" type="submit" class="btn btn-primary btn-lg" value="更新確認" />
										</c:otherwise>
									</c:choose>
								</div>
								<form:hidden path="systemUserId"/>

							</form:form>
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
