<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<title>バナー登録画面</title>
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
                    <h1 class="page-header">バナー登録</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
            	<div class="col-lg-12">
            		<form:form method="post" action="${pageContext.request.contextPath}/back/callRegistConfirmBanner" modelAttribute="bannerForm" enctype="multipart/form-data">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            <span class="pull-left">バナー登録</span>
	                            <div class="clearfix"></div>
	                        </div>
		                    <div class="panel-body">
								<div class="table-responsive">
									<div class="form-inline" style="padding-bottom:20px;">
										<p id='message' class='text-left text-danger' style='margin-bottom:0px'></p>
	                            		<div class="form-group imgInput">
	                            			<img alt="" class="imgView img-responsive" style="width:230px; height:200px;">
								    		<input id="uploadFile" type="file" name="fileupload" class="form-controll">
								    	</div>
								    </div>
								   	<table class="table table-striped table-hover editTable table-bordered table-condensed" id="edit-mainDataList">
                                    	<tbody>
											<tr>
												<th>
													遷移先URL
												</th>
												<td>
													<form:input class="input-xlarge form-control " path="transitionUrl" maxlength="100"/>
												</td>
											</tr>
											<tr>
												<th>
													遷移先方法フラグ
												</th>
												<td>
													<form:select path="transitionFlag" items="${linkClassList}" itemLabel="name" itemValue="id">
													</form:select>
												</td>
											</tr>
											<tr>
												<th>
													公開フラグ
												</th>
												<td>
													<form:select path="publicationFlag" items="${publicationFlagList}" itemLabel="name" itemValue="id">
													</form:select>
												</td>
											</tr>
										</tbody>
									</table>
								</div>

								<div class="btnBox">
									<a href="${pageContext.request.contextPath}/back/listBanner" class="btn btn-warning btn-lg">戻る</a>
									<button type="button" id="registBannerBtn" class="btn btn-primary btn-lg">登録</button>
								</div>

							</div>
						</div>
					</form:form>
					<script>
		                $(function(){
		                    var setFileInput = $('.imgInput');

		                    setFileInput.each(function(){
		                        var selfFile = $(this),
		                        selfInput = $(this).find('input[type=file]');

		                        selfInput.change(function(){
		                            var file = $(this).prop('files')[0],
		                            fileRdr = new FileReader(),
		                            selfImg = selfFile.find('.imgView');

		                            if(!this.files.length){
		                                if(0 < selfImg.size()){
		                                    selfImg.remove();
		                                    return;
		                                }
		                            } else {
		                                if(file.type.match('image.*')){
		                                    var prevElm = $('.imgView');
		                                    fileRdr.onload = function() {
		                                        prevElm.attr('src', fileRdr.result);
		                                    }
		                                    fileRdr.readAsDataURL(file);
		                                } else {
		                                    if(0 < selfImg.size()){
		                                        selfImg.remove();
		                                        return;
		                                    }
		                                }
		                            }
		                        });
		                    });
		                });
					</script>
                </div>
        	</div>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
   	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/part/registBanner.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/drugSort/drugSort.js"></script>
    <%@ include file="./parts/footer.jsp" %>
	</body>
</html>
