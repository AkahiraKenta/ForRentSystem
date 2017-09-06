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
		<script src="${pageContext.request.contextPath}/resources/js/part/registNews.js"></script>
		<title>ニュース登録画面</title>
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
                    <h1 class="page-header">ニュース情報登録</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<form:form method="post" action="${pageContext.request.contextPath}/back/callRegistConfirmNews" modelAttribute="newsForm">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">新規登録</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                    <tbody>
	                                    	<tr>
	                                         	<th class="item_font_size">
	                                           		ニュースタイトル
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="newsTitle" maxlength="20"/>
	                                            	<form:errors path="newsTitle" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <!--
											<tr>
	                                         	<th class="item_font_size">
	                                           		ニュース内容
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="newsContent" rows="10"/>
	                                            </td>
	                                        </tr>
	                                        -->
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		投稿日
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control datepicker" path="postedDate" maxlength="20"/>
	                                            	<form:errors path="postedDate" cssClass="validateErrors" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンク有無フラグ
	                                            </th>
	                                            <td>
	                                            	<form:select path="linkUmuFlag" items="${flagList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="linkUmuFlagName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンク区分
	                                            </th>
	                                            <td>
	                                            	<form:select path="linkClass" items="${linkClassList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="linkClassName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンクURL
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="linkUrl" maxlength="200"/>
	                                            </td>
	                                        </tr>
                                    	</tbody>
                                	</table>
                            	</div>
                            	<div class="btnBox">
									<a href="${pageContext.request.contextPath}/back/backRegistNews" class="btn btn-warning btn-lg">戻る</a>
									<input id="registConfirmNews" type="submit" class="btn btn-primary btn-lg" value="登録確認" />
								</div>
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
