<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>バナー設定画面</title>
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
                    <h1 class="page-header">バナー設定</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">バナー情報一覧</span>
                            <span class="pull-right">
                                <a href="${pageContext.request.contextPath}/back/callRegistBanner" id="addPopularityArea" class="selectModalBtn">
                                	バナー追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </span>
                            <div class="clearfix"></div>
                        </div>
						<div id="resultMessage" style="padding-top:10px">
							<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
						</div>
                        <div class="panel-body">
                        	<form:form modelAttribute="bannerForm" method="post" action="${pageContext.request.contextPath}/back/listBanner">
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
	                                                表示順
	                                            </th>
	                                            <th>
	                                                ファイル名
	                                            </th>
	                                            <th >
	                                                遷移先URL
	                                            </th>
	                                            <th>
	                                                遷移先方法
	                                            </th>
	                                            <th>
	                                                公開フラグ
	                                            </th>
	                                            <th style="width: 36px;">
	                                            </th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="banner" items="${bannerList}">
	                                    		<tr id="banner_${banner.bannerId}">
	                                    			<td class="rank">
														${banner.displayNumber}
													</td>
	                                    			<td>
	                                    				${banner.fileName}
	                                    			</td>
	                                    			<td>
	                                    				${banner.transitionUrl}
	                                    			</td>
	                                    			<td>
	                                    				<c:forEach var="linkClass" items="${linkClassList}">
	                                    					<c:if test="${linkClass.id == banner.transitionFlag}">
                                    							${linkClass.name}
                                    						</c:if>
                                    					</c:forEach>
	                                    			</td>
	                                    			<td>
	                                    				<c:forEach var="publicationFlag" items="${publicationFlagList}">
	                                    					<c:if test="${publicationFlag.id == banner.publicationFlag}">
                                    							${publicationFlag.name}
                                    						</c:if>
                                    					</c:forEach>
	                                    			</td>
	                                    			<td>
	                                    				<input type="hidden" id="bannerId_${banner.bannerId}" name="bannerId" value="${banner.bannerId}"/>
	                                    				<input id="bannerDetail"type="button" class="btn btn-info btn-xs" value="詳細"
	                                    					onclick="location.href = '${pageContext.request.contextPath}/back/callDetailBannerByBannerId?bannerId=${banner.bannerId}'"/>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
	                            <div class="btnBox">
	                                <button type="button" id="updateBannerDisplayNumber" class="btn btn-primary btn-md">保存</button>
	                            </div>
                            </form:form>
                        </div>
		            </div>
				</div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/part/listBanner.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
