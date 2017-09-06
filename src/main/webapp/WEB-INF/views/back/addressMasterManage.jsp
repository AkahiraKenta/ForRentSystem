<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<title>住所マスタ管理</title>
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
	                        <li>
	                        	<a href="./back/">トップ</a>
	                        </li>
	                    </ol>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
				 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="pull-left">住所マスタ管理</span>
                            <div class="clearfix"></div>
                      	</div>
						<div class="panel-body">
				            <div class="row">
				                <div class="col-lg-12">
				                    <div class="panel panel-default">
				                        <div class="panel-heading">
											<span class="pull-left">住所マスタを最新へ更新します。</span>
			                                <div class="clearfix"></div>
			                        	</div>
			                        </div>
			                    </div>
			                 </div>
			            </div>

						<form:form method="post" action="${pageContext.request.contextPath}/back/updateAddressManage" modelAttribute="addressManageForm">
							<div>
								<input id="updateAddressManage" type="submit" value="更新" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<%@ include file="./parts/footer.jsp" %>
		</div>
	</body>
</html>
