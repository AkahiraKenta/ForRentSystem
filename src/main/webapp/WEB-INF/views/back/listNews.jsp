<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/listNews.js"></script>
		<title>ニュース管理画面</title>
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
                    <h1 class="page-header">ニュース管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">ニュース一覧</span>
                            <span class="pull-right">
                                <a href="${pageContext.request.contextPath}/back/registNews" id="addNews" class="selectModalBtn">
                                	ニュース追加
                                	<i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </span>
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
	                                               	ニュースタイトル
	                                            </th>
	                                            <!--
		                                            <th >
		                                                ニュース内容
		                                            </th>
	                                             -->
	                                            <th>
													投稿日
	                                            </th>
	                                            <th>
													リンク区分
	                                            </th>
	                                            <th>
													リンクURL
	                                            </th>
	                                             <th style="width: 87px;"></th>
	                                            </th>
	                                		</tr>
	                                	</thead>
	                                    <tbody id="sortable">
	                                    	<c:forEach var="news" items="${newsList}">
	                                    		<tr id="listNews_${news.newsId}">
	                                    			<td>
														${news.newsTitle}
													</td>
													<!--
	                                    			 	<td>
		                                    				${news.newsContent}
		                                    			</td>
		                                    		-->
	                                    			<td>
	                                    				${news.postedDate}
	                                    			</td>
	                                    			<td>
	                                    				<c:forEach  var="linkClass" items="${linkClassList}">
	                                    					<c:if test="${news.linkClass == linkClass.id}">
	                                    						${linkClass.name}
	                                    					</c:if>
	                                    				</c:forEach>

	                                    			</td>
	                                    			<td>
	                                    				${news.linkUrl}
	                                    			</td>
	                                    			<td>
	                                    				<input id="newsEdit"type="button" class="btn btn-success btn-xs" value="編集"  onclick="location.href = '${pageContext.request.contextPath}/back/callEditNews?newsId=${news.newsId}'"/>
	                                    				<button type="button" id="deleteNews_${news.newsId}" name="deleteNews" class="btn btn-danger btn-xs">削除</button>
													</td>
	                                    		</tr>
	                                    	</c:forEach>
	                                   </tbody>
	                               </table>
	                            </div>
                            </form>
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
