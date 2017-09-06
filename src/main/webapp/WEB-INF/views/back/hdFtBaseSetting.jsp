<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="resources/js/part/hdFt.js"></script>
		<title>ヘッダー・フッター基本設定画面</title>
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
                    <h1 class="page-header">ヘッダー・フッター管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div id="resultMessage" style="padding-top:10px">
				<p id='message' class='text-center lead text-success' style='margin-bottom:0px'></p>
			</div>
            <div class="row">
            	<form id="hdFtForm" method="post" action="${pageContext.request.contextPath}/back/hdFtBaseSetting" enctype="multipart/form-data">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">ヘッダー・フッター編集</span>
	                            	<div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="col-lg-12" style="margin-bottom:20px">
	                           		<div class="form-inline">
	                            		<div>
	                            			<label>
	                            				ヘッダー画像
	                            			</label>
	                            			<img id="headerImage" alt="" class="headerImage img-responsive"
	                            				src="${hdFt.headerFilePath}${hdFt.headerFileName}" style="width:350px; height:50px;">
	                            		</div>
	                            	</div>
									<div class="form-inline" style="padding-top:5px;">
	                            		<div>
	                            			<label>
	                            				ヘッダーファイル名称
	                            			</label>
	                            			<input id="headerFileName" type="file" name="headerUpload" class="form-controll" value="${hdFt.headerFileName}">
	                            		</div>
	                            	</div>
									<div class="form-inline" style="padding-top:15px;">
	                            		<div id="footer">
	                            			<label>
	                            				フッター画像
	                            			</label>
	                            			<img id="footerImage" alt="" class="footerImage img-responsive"
	                            				src="${hdFt.footerFilePath}${hdFt.footerFileName}" style="width:350px; height:50px;">
	                            		</div>
	                            	</div>
									<div class="form-inline" style="padding-top:5px;">
	                            		<div>
	                            			<label>
	                            				フッターファイル名称
	                            			</label>
	                            			<input id="footerFileName" type="file" name="footerUpload" class="form-controll" value="${hdFt.footerFileName}">
	                            		</div>
	                            	</div>
	                            </div>

                            	<div class="table-responsive" style="padding-top:20px;">
	                            	<table class="table table-striped table-bordered table-hover">
	                                	<tbody>
	                                		<tr>
	                                			<th class="item_font_size">
	                                				会社名称
	                                			</th>
	                                			<td>
	                                				<input type="hidden" name="id" value="${hdFt.id}"/>
	                                				<input type="text" class="input-xlarge form-control" name="companyName" value="${hdFt.companyName}"/>
	                            				</td>
	                            			</tr>
	                            			<tr>
	                            				<th class="item_font_size">
	                            					電話番号
	                            				</th>
	                            				<td>
	                            					<input type="text" class="input-xlarge form-control" name="tel" value="${hdFt.tel}"/>
	                            				</td>
	                            			</tr>
	                            			<tr>
	                            				<th class="item_font_size">
	                            					FAX
	                            				</th>
	                            				<td>
	                            					<input type="text" class="input-xlarge form-control" name="fax" value="${hdFt.fax}"/>
	                            				</td>
	                            			</tr>
	                            			<tr>
	                            				<th class="item_font_size">
	                            					メールアドレス
	                            				</th>
	                            				<td>
	                            					<input type="text" class="input-xlarge form-control" name="mailAddress" value="${hdFt.mailAddress}"/>
	                            				</td>
	                            			</tr>
	                            			<tr>
	                            				<th class="item_font_size">
	                            					遷移先URL
	                            				</th>
	                            				<td>
	                            					<input type="text" class="input-xlarge form-control" name="transitionUrl" value="${hdFt.transitionUrl}"/>
	                            				</td>
	                            			</tr>
	                            			<tr>
	                            				<th class="item_font_size">
	                            					遷移先方法
	                            				</th>
	                            				<td>
	                            					<select  name="transitionFlag" class="input-xlarge form-control">
	                            						<c:forEach var="linkClass" items="${linkClassList}">
			                            					<option value="${linkClass.id}">
			                            						${linkClass.name}
			                            					</option>
	                            						</c:forEach>
													</select>
													<input type="hidden" id="transisitonFlag"/>
	                            				</td>
	                            			</tr>
	                            		</tbody>
	                            	</table>
	                            </div>
	                            <div class="btnBox">
	                            	<button type="button" id="updateHdFt" name="updateHdFt" class="btn btn-primary btn-lg">更新</button>
	                            </div>
	                        </div>
			            </div>
					</div>
				</form>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
