<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/part/listRecommendedRoom.css" rel="stylesheet">
		<title>おすすめ物件登録画面</title>
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
                    <h1 class="page-header">おすすめ物件登録</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                <span class="pull-left">おすすめ物件情報一覧</span>
                                <span class="pull-right">
                                    <a href="${pageContext.request.contextPath}/back/searchRecommendedRoom" class="selectModalBtn">
                                    	物件追加
                                    	<i class="fa fa-arrow-circle-right"></i>
                                    </a>
                                </span>
                                <div class="clearfix"></div>
                        </div>
						<div id="resultMessage" style="padding-top:10px">
							<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
						</div>
                        <div class="panel-body">
                        	<form id="recommendRoomForm" method="get" action="${pageContext.request.contextPath}/back/deleteReccomendRoom">
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
	                                                ID
	                                            </th>
	                                            <th >
	                                                建物番号
	                                            </th>
	                                            <th >
	                                                建物名
	                                            </th>
	                                            <th >
	                                                部屋コード
	                                            </th>
	                                            <th>
	                                                部屋番号
	                                            </th>
	                                            <th>
	                                                階数
	                                            </th>
	                                            <th>
	                                                面積
	                                            </th>
	                                            <th>
	                                                賃料
	                                            </th>
	                                            <th style="width: 36px;">
	                                            </th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="article" items="${articleList}">
		                                        <tr id="recommendRoom_${article.id}">
		                                            <td class="rank">
		                                            	${article.rank}
		                                            </td>
		                                            <td>
		                                            	${article.buildingCode}
		                                            </td>
		                                            <td>
		                                            	${article.buildingName}
		                                            </td>
		                                            <td>
		                                            	${article.roomCode}
		                                            </td>
		                                            <td>
		                                            	${article.roomNumber}
		                                            </td>
		                                            <td>
		                                            	${article.numberOfStoreysId}
		                                            </td>
		                                            <td>
		                                            	${article.space}
		                                            </td>
		                                            <td>
		                                            	${article.rent}
		                                            </td>
		                                            <td>
		                                                <button type="button" id="deleteRecommendRoom" class="btn btn-danger btn-xs">削除</button>
		                                                <input type="hidden" name="id" value='${article.id}'/>
		                                            </td>
		                                        </tr>
		                                    </c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                                <button type="button" id="updateRecommendRank" class="btn btn-primary btn-md">保存</button>
	                            </div>
	                        </form>
                        </div>
		            </div>
		            <%-- ダイアログ --%>
		            <div class="modal fade" id="selectModal" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">
		            	<div class="modal-dialog">
		            		<div class="modal-content">
		            			<div class="modal-header bg-primary">
		            				<button type="button" class="close" data-dismiss="modal">
			            				<span aria-hidden="true">&times;</span>
			            				<span class="sr-only">Close</span>
		            				</button>
                                    <h4 class="modal-title" id="UploadModalLabel">物件選択</h4>
		            			</div>
		            			<div class="modal-body">
		            			</div>
		            			<div class="modal-footer">
		            				 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
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
    <script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/part/listRecommendedRoom.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
