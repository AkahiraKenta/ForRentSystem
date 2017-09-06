<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/mainImage.js"></script>
		<title>メイン画像管理画面</title>
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
	                    <h1 class="page-main">メイン画像管理</h1>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	            <div id="resultMessage" style="padding-top:10px">
					<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
				</div>
	            <div class="row">
	            	<form id="mainImageForm" method="post" action="${pageContext.request.contextPath}/back/mainImage" enctype="multipart/form-data">
		                <div class="col-lg-12">
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
		                            <span class="pull-left">メイン画像一覧</span>
		                            <span class="pull-right">
			                            <a href="#" class="imageFileUploadBtn">
		                                	メイン画像追加
		                                	<i class="fa fa-arrow-circle-right"></i>
		                                </a>
		                            </span>
	                            	<div class="clearfix"></div>
		                        </div>
		                        <div class="panel-body">
		                            <div class="col-lg-12" style="margin-bottom:20px">
		                            	<div class="form-inline" style="padding-top:20px;">
			                            	<table class="table">
			                                	<thead>
			                                		<tr>
			                                			<th>
			                                				メイン画像
			                                			</th>
			                                			<th>
			                                				ファイル名称
			                                			</th>
			                                			<th>
			                                				表示フラグ
			                                			</th>
			                                			<th>
			                                				遷移先URL
			                                			</th>
			                                			<th>
			                                				遷移先方法
			                                			</th>
			                                			<th>
			                                			</th>
			                                		</tr>
			                                		<c:forEach var="mainImage" items="${mainImageList}">
				                                		<tr>
				                                			<td>
				                                				<img id="mainImage" alt="" class="mainImage img-responsive"
			                            							src="${mainImage.mainFilePath}${mainImage.mainFileName}" style="width:50px; height:50px;">
			                            					</td>
			                            					<td>
			                            						${mainImage.mainFileName}
			                            					</td>
			                            					<td>
			                            						<c:forEach var="displayFlag" items="${displayFlagList}">
			                            							<c:if test="${displayFlag.id == mainImage.displayFlag}">
			                            								${displayFlag.name}
			                            							</c:if>
			                            						</c:forEach>
			                            					</td>
			                            					<td>
			                            						${mainImage.transitionUrl}
			                            					</td>
			                            					<td>
			                            						<c:forEach var="linkClass" items="${linkClassList}">
			                            							<c:if test="${linkClass.id == mainImage.transitionFlag}">
			                            								${linkClass.name}
			                            							</c:if>
			                            						</c:forEach>
			                            					</td>
			                            					<td>
			                            						<button type="button" id="updateMainImage" name="updateMainImage" class="btn btn-primary btn-sm">更新</button>
				                            					<button type="button" id="deleteMainImage" name="deleteMainImage" class="btn btn-danger btn-sm">削除</button>
			                            					</td>
			                            				</tr>
			                            			</c:forEach>
		                            			</thead>
		                            		</table>
		                            	</div>
		                            </div>
		                        </div>
				            </div>
						</div>
					</form>
	        	</div>
	        </div>
	        <!-- /#page-wrapper -->

	        <%-- ファイルアップロードダイアログ --%>
	        <script src="${pageContext.request.contextPath}/resources/js/part/imageFileUpload.js"></script>
	        <%@ include file="parts/imageFileUpload.jsp" %>
			<%@ include file="./parts/footer.jsp" %>
	    </div>
    	<!-- /#wrapper -->
    </body>
</html>
