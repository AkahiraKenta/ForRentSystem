<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<title>ニュース情報編集確認画面</title>
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
                    <h1 class="page-header">ニュース情報編集確認</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<form:form method="post" action="${pageContext.request.contextPath}/back/calleditCompleteNews" modelAttribute="newsForm">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">編集確認</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
	                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
	                                	<form:hidden path="newsId" />
	                                    <tbody>
	                                    	<tr>
	                                         	<th class="item_font_size">
	                                           		ニュースタイトル
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${newsForm.newsTitle}" />
													<form:hidden path="newsTitle" />
	                                            </td>
	                                        </tr>
	                                        <!--
											<tr>
	                                         	<th class="item_font_size">
	                                           		ニュース内容
	                                            </th>
	                                            <td>
	                                            	<form:textarea  class="form-control" path="newsContent" rows="10" readOnly="true" />
	                                            </td>
	                                        </tr>
	                                         -->
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		投稿日
	                                           		<span class="label label-danger">必須</span>
	                                            </th>
	                                            <td>
	                                            	<c:out value="${newsForm.postedDate}" />
													<form:hidden path="postedDate" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンク有無フラグ
	                                            </th>
	                                            <td>
	                                            	<c:out value="${newsForm.linkUmuFlagName}" />
													<form:hidden path="linkUmuFlag" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンク区分
	                                            </th>
	                                            <td>
	                                            	<c:out value="${newsForm.linkClassName}" />
													<form:hidden path="linkClass" />
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                         	<th class="item_font_size">
	                                           		リンクURL
	                                            </th>
	                                            <td>
	                                            	<c:out value="${newsForm.linkUrl}" />
													<form:hidden path="linkUrl" />
	                                            </td>
	                                        </tr>
                                    	</tbody>
                                	</table>
                            	</div>
                            	<div class="btnBox">
                            		<input id="backEditConfirmNews" type="submit" name="back" class="btn btn-warning btn-lg" value="戻る" />
									<input id="editCompleteNews" type="submit" class="btn btn-primary btn-lg" value="編集完了" />
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
