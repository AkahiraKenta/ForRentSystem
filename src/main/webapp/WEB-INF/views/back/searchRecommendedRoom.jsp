<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		 <script src="${pageContext.request.contextPath}/resources/js/part/pager.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/searchRecommendedRoom.js"></script>
		<title>物件検索画面</title>
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
                    <h1 class="page-header">物件情報検索</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callSearchRecommendedRoom" modelAttribute="searchRecommendedRoomForm">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left"> 検索条件</span>
	                                <div class="clearfix"></div>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover" id="edit-mainDataList" style="border-bottom: 1px solid #ddd;">
                                        <tbody>
                                            <tr>
                                                <th class="item_font_size">建物番号</th>
                                                <td>
                                                    <form:input class="input-xlarge form-control" path="buildingCode" maxlength="20"/>
                                                </td>
                                                <th class="item_font_size">建物名称</th>
                                                <td>
                                                	<form:input class="input-xlarge form-control" path="buildingName" maxlength="150"/>
                                                </td>
                                                <th class="item_font_size">建物種別</th>
                                                <td>
													<form:select path="buildingType"  items="${buildingTypeList}" itemLabel="name" itemValue="id">
													</form:select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th class="item_font_size">階層</th>
                                                <td>
													<form:select path="numberOfStoreysId"  items="${floorList}" itemLabel="floorName" itemValue="floorClassId">
													</form:select>
                                                </td>
                                                <th class="item_font_size">部屋番号</th>
                                                <td>
                                                	<form:input class="input-xlarge form-control" path="roomCode" maxlength="20"/>
                                                </td>
                                                <th class="item_font_size">部屋名称</th>
                                                <td>
                                                	<form:input class="input-xlarge form-control" path="roomNumber" maxlength="150"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th class="item_font_size">面積</th>
                                                <td colspan="5">
													<form:input class="input-w-3 form-control btn-group" path="spaceFrom" maxlength="150"/>
													～
													<form:input class="input-w-3 form-control btn-group" path="spaceTo" maxlength="150"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th class="item_font_size">賃料</th>
                                                <td colspan="5">
													<form:input class="input-w-3 form-control btn-group" path="rentFrom" maxlength="150"/>
													～
													<form:input class="input-w-3 form-control btn-group" path="rentTo" maxlength="150"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>

	                                <div class="btnBox">
	                                	<a href="${pageContext.request.contextPath}/back/listRecommendedRoom" class="btn btn-warning btn-lg">戻る</a>
										<input id="search" type="submit" class="btn btn-primary btn-lg" value="検索" />
									</div>
								</div>
							</div>
	                    </div>
	                    <!-- /.panel -->
                	</div>

                	<div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">物件一覧</span>
	                            <div class="clearfix"></div>
	                        </div>
							<div id="resultMessage" style="padding-top:10px">
								<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
							</div>
	                        <div class="panel-body">
	                        	<form id="deleteNewsForm" method="post" action="${pageContext.request.contextPath}/back/listNews">
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
		                                               	建物番号
		                                            </th>
		                                            <th >
		                                                建物名称
		                                            </th>
		                                            <th>
														部屋番号
		                                            </th>
		                                            <th>
														部屋名称
		                                            </th>
		                                            <th>
														建物種別
		                                            </th>
		                                            <th>
														階層
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
		                                    <tbody>
		                                    	<c:forEach var="article" items="${articleList}">
		                                    		<tr id="listNews_${article.buildingId}">
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
                                    						<c:forEach  var="buildingType" items="${buildingTypeList}">
		                                    					<c:if test="${article.buildingType == buildingType.id}">
		                                    						${buildingType.name}
		                                    					</c:if>
	                                    					</c:forEach>
		                                    			</td>
		                                    			<td>
		                                    				<c:forEach  var="floor" items="${floorList}">
		                                    					<c:if test="${article.numberOfStoreysId == floor.floorClassId}">
		                                    						${floor.floorName}
		                                    					</c:if>
	                                    					</c:forEach>
		                                    			</td>
		                                    			<td>
		                                    				${article.space}
		                                    			</td>
		                                    			<td>
		                                    				${article.rent}
		                                    			</td>
		                                    			<td>
		                                    				<input id="newsEdit"type="button" class="btn btn-primary btn-xs" value="追加"
		                                    					onclick="location.href = '${pageContext.request.contextPath}/back/registRecommendedRoom?buildingId=${article.buildingId}&roomId=${article.roomId}'"/>
														</td>
		                                    		</tr>
		                                    	</c:forEach>
		                                   </tbody>
		                               </table>
                                       <%@ include file="parts/pager.jsp" %>
		                            </div>
	                            </form>
	                        </div>
			            </div>
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