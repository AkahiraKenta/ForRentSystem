<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/searchZip.js"></script>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>郵便番号検索</title>
	</head>
	<body>
	    <div id="wrapper" style="width:500px;">
	        <div>
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">郵便番号検索</h1>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	            <div class="row">
	            	<div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">郵便番号検索</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
									<form id="searchZipForm" method="get" action="${pageContext.request.contextPath}/back/searchZip">
										<table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
											<tbody>
												<tr>
													<th class="item_font_size" style="color:#ff0000">
														郵便番号<br>
	                                            		<p style="color: #cc0000;font-size: smaller;">ハイフンなしで入力</p>
													</th>
													<th>
														<p id="zipCode" style="color:#ff0000; font-size:20px;margin:0px;"></p>
													</th>
												</tr>
												<tr>
													<th class="item_font_size">
														都道府県
													</th>
													<td>
														<input type="text" class="input-w-7 form-control" id="province" maxlength="20"/>
													</td>
												</tr>
												<tr>
													<th class="item_font_size">
														市区町村
													</th>
													<td>
														<input type="text" class="form-control" id="city" maxlength="150"/>
													</td>
												</tr>
												<tr>
													<th class="item_font_size">
														町域
													</th>
													<td>
														<input type="text" class="form-control" id="town" maxlength="150"/>
													</td>
												</tr>
												<tr>
												</tr>
											</tbody>
										</table>
										<div class="btnBox">
											<a href="#" id="searchZip" class="btn btn-primary btn-sm">検索</a>
										</div>
									</form>
								</div>
							</div>
						</div>
	                </div>
	        	</div>
	        </div>
	    </div>
      	<%@ include file="./parts/footer.jsp" %>
	</body>
</html>
