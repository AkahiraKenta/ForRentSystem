<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/editConfirmSystemUser.js"></script>
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
            	<div class="col-lg-12">
            		<form:form method="post" action="${pageContext.request.contextPath}/back/callEditCompleteSystemUser" modelAttribute="systemUserForm">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">システムユーザー登録・編集確認</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<tr>
	                                         	<th class="item_font_size">
	                                           		ユーザー名
	                                            </th>
	                                            <td>
	                                            	<c:out value="${systemUserForm.systemUserName}" />
													<form:hidden path="systemUserName" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		ログインID
	                                            </th>
	                                            <td>
	                                            	<c:out value="${systemUserForm.systemUserLoginId}" />
													<form:hidden path="systemUserLoginId" />
	                                            </td>
	                                        </tr>
	                                        <c:if test="${systemUserForm.systemUserId == -1}">
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		パスワード
	                                            </th>
	                                            <td>
													※非表示
													<form:hidden path="systemUserPassword" />
	                                            </td>
	                                        </tr>
	                                        </c:if>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		ユーザー区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${systemUserForm.systemUserClassName}" />
	                                            	<form:hidden path="systemUserClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		メールアドレス
	                                            </th>
	                                            <td>
	                                            	<c:out value="${systemUserForm.systemUserAddress}" />
	                                            	<form:hidden path="systemUserAddress" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		有効・無効
	                                            </th>
	                                            <td>
	                                            	<c:out value="${systemUserForm.availableFlag}" />
	                                            	<form:hidden path="availableFlag" />
	                                            </td>
	                                        </tr>
                                    	</tbody>
                                	</table>
                            	</div>
                            	<div class="btnBox">
                            		<input id="backRegistAndEditSystemUser" name="back" type="submit" class="btn btn-warning btn-lg" value="戻る" />
									<input id="editCompleteSystemUser" name="save" type="submit" class="btn btn-primary btn-lg" value="保存" />
								</div>
								<form:hidden path="systemUserId" />
							</div>
						</div>
					</form:form>
                </div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
