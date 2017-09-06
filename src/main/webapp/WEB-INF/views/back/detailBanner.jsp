<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>バナー詳細画面</title>
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
                    <h1 class="page-header">バナー詳細</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<form:form method="post" action="${pageContext.request.contextPath}/back/callEditBanner" modelAttribute="bannerForm" enctype="multipart/form-data">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">バナー詳細</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
									<div class="form-inline" style="padding-bottom:20px;">
	                            		<div class="form-group imgInput">
	                            			<img alt="" class="imgView img-responsive" src="${banner.filePath}/${banner.fileName}" style="width:230px; height:200px;">
								    		<label>ファイル名：</label>
								    		${banner.fileName}
								    	</div>
								    </div>
								   	<table class="table table-hover editTable" id="edit-mainDataList">
                                    	<tbody>
											<tr>
												<th>
													遷移先URL
												</th>
												<td>
													${banner.transitionUrl}
												</td>
											</tr>
											<tr>
												<th>
													遷移先方法フラグ
												</th>
												<td>
													<c:forEach var="linkClass" items="${linkClassList}">
                                    					<c:if test="${linkClass.id == banner.transitionFlag}">
                                   							${linkClass.name}
                                   						</c:if>
                                   					</c:forEach>
												</td>
											</tr>
											<tr>
												<th>
													公開フラグ
												</th>
												<td>
													<c:forEach var="publicationFlag" items="${publicationFlagList}">
                                    					<c:if test="${publicationFlag.id == banner.publicationFlag}">
                                   							${publicationFlag.name}
                                   						</c:if>
                                   					</c:forEach>
												</td>
											</tr>
											<tr>
												<th>
												</th>
												<td>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="btnBox">
										<form:hidden path="bannerId" />
										<a href="${pageContext.request.contextPath}/back/backListBannerToDetailBanner" class="btn btn-warning btn-sm">戻る</a>
										<input id="editBanner" type="submit" class="btn btn-primary btn-sm" value="編集" />
										<button type="button" id="deleteBannerBtn" class="btn btn-primary btn-sm">削除</button>
									</div>
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
   	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/part/detailBanner.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
