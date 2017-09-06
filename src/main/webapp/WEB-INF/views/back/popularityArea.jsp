<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>人気エリア設定画面</title>
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
                    <h1 class="page-header">人気エリア設定</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">人気エリア情報一覧</span>
                            <span class="pull-right">
                                <a href="#" id="addPopularityArea" class="selectModalBtn">
                                	人気エリア追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </span>
                            <div class="clearfix"></div>
                        </div>
						<div id="resultMessage" style="padding-top:10px">
							<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
						</div>
                        <div class="panel-body">
                        	<form id="popularityArea" method="get" action="${pageContext.request.contextPath}/back/deletePopularityArea">
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
	                                                順位
	                                            </th>
	                                			<!--
	                                			<th>
	                                                駅ID
	                                            </th>
	                                             -->
	                                            <th >
	                                                都道府県
	                                            </th>
	                                            <th >
	                                                市区町村
	                                            </th>
	                                            <th >
	                                                町域
	                                            </th>
	                                            <th style="width: 36px;"></th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="popularityArea" items="${popularityAreaDtoList}">
	                                    		<tr id="popularityArea_${popularityArea.popularityAreaId}">
	                                    			<td class="rank">
														${popularityArea.rank}
													</td>
	                                    			<td>
	                                    				${popularityArea.province}
	                                    			</td>
	                                    			<td>
	                                    				${popularityArea.city}
	                                    			</td>
	                                    			<td>
	                                    				${popularityArea.townArea}
	                                    			</td>
	                                    			<td>
	                                    				<input type="hidden" id="popularityAreaId_${popularityArea.popularityAreaId}" name="popularityAreaId" value="${popularityArea.popularityAreaId}"/>
	                                    				<button type="button" id="deletePopularityArea" class="btn btn-danger btn-xs">削除</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                                <button type="button" id="updatePopularityArea" class="btn btn-primary btn-md">保存</button>
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
                                    <h4 class="modal-title" id="UploadModalLabel">人気エリア選択</h4>
		            			</div>
		            			<div class="modal-body">
		            				<div>
		            					<p>
		            						都道府県を選択後に、物件情報に紐付くエリア情報が表示されます。
		            						<br>
		            						人気エリア設定されたエリア情報は表示されません。
		            					</p>
		            				</div>
		            				<form:form id="searchForm" method="post" action="${pageContext.request.contextPath}/back/searchPopularityArea" modelAttribute="popularityAreaForm">
			            				<div class="panel-heading">
			            					都道府県
			            					<select id="provinceSelect">
		            							<option value="0"></option>
			            						<c:forEach  var="provinceList" items="${addressDtoList}" varStatus="status">
			            							<option value="${status.index}">${provinceList.province}</option>
			            						</c:forEach>
			            					</select>
											<form:hidden path="searchProvince"/>
			            				</div>
			            			</form:form>
		            				<form:form id="areaForm" method="get" action="${pageContext.request.contextPath}/back/registPopularityArea" modelAttribute="popularityAreaForm">
			            				<table id="areaTable" class="table table-striped table-bordered table-hover table-condensed">
		                                	<thead>
		                                		<tr>
		                                            <th >
		                                                都道府県
		                                            </th>
		                                            <th >
		                                                市区町村
		                                            </th>
		                                            <th >
		                                                町域
		                                            </th>
		                                            <th>

		                                            </th>
		                                		</tr>
		                                	</thead>
		                                    <tbody id="areaList">

		                                   </tbody>
		                               </table>
		                               <form:hidden path="province"/>
		                               <form:hidden path="city"/>
		                               <form:hidden path="townArea"/>
									</form:form>
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
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/part/popularityArea.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
