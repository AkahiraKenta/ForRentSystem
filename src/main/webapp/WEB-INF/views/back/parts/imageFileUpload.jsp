<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<%-- ダイアログ --%>
<div class="modal fade" id="imageFileUploadModal" role="dialog" aria-labelledby="selectModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- 建物画像 -->
			<c:if test="${detailRoomForm == null}">
				<form id="uploadForm" method="post" action="${pageContext.request.contextPath}/back/uploadImageFile" enctype="multipart/form-data">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">
			 				<span aria-hidden="true">&times;</span>
			 				<span class="sr-only">Close</span>
						</button>
		                <h4 class="modal-title" id="UploadModalLabel">建物画像アップロード</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
			                <div class="panel-heading">
			                    <h3 class="panel-title">アップロードする画像を選択して下さい</h3>
			                </div>
			                <div class="panel-body">
		                        <div class="form-group uploadFileSelect">
		                            <label class="col-sm-8 control-label">画像ファイルの選択</label>
		                            <div class="col-sm-8">
										<div class="form-group uploadFileSelect">
									    	<input id="uploadFile" type="file" name="fileupload" class="form-controll">
									    </div>
								    	<input type="hidden" name="targetBuildingId" value='${detailBuildingForm.buildingId}'/>
	                            		<div class="form-group uploadFileSelect">
											<label>画像見出し</label>
	                            			<input type="text" id="imageCaption" name="imageCaption" maxlength="50"/>
									    </div>
										<%--
										<div class="form-group uploadFileSelect">
											<label>公開フラグ</label>
									    	<select name="publicationFlag">
		                            			<c:forEach var="publicationFlag" items="${flagList}" varStatus="status">
		                            				<option value="${publicationFlag.id}">${publicationFlag.name}</option>
		                            			</c:forEach>
		                            		</select>
									    </div>
									     --%>
		                            </div>
		                        </div>
			                </div>
			                <!-- /.panel-body -->
			            </div>
			            <div class="btnBox">
	                    	<button type="button" id="uploadButton" class="btn btn-primary uploadImageBtn">アップロード</button>
		                </div>
					</div>
					<div class="modal-footer">
						 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					</div>
				</form>
			</c:if>
			<!-- 部屋画像 -->
			<c:if test="${detailRoomForm != null}">
				<form id="roomUploadForm" method="post" action="${pageContext.request.contextPath}/back/uploadRoomImageFile" enctype="multipart/form-data">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">
			 				<span aria-hidden="true">&times;</span>
			 				<span class="sr-only">Close</span>
						</button>
		                <h4 class="modal-title" id="UploadModalLabel">部屋画像アップロード</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
			                <div class="panel-heading">
			                    <h3 class="panel-title">アップロードする画像を選択して下さい</h3>
			                </div>
			                <div class="panel-body">
		                        <div class="form-group uploadFileSelect">
		                            <label class="col-sm-8 control-label">画像ファイルの選択</label>
		                            <div class="col-sm-8">
	                            		<div class="form-group uploadFileSelect">
		                            		<select name="roomImageClass">
		                            			<c:forEach var="roomImageClass" items="${roomImageClassList}" varStatus="status">
		                            				<option value="${roomImageClass.id}">
		                            					${roomImageClass.name}
		                            				</option>
		                            			</c:forEach>
		                            		</select>
		                            	</div>
										<div class="form-group uploadFileSelect">
									    	<input id="uploadFile" type="file" name="fileupload" class="form-controll">
									    </div>
	                            		<input type="hidden" name="targetBuildingId" value='${detailRoomForm.buildingId}'/>
	                            		<input type="hidden" name="targetRoomId" value='${detailRoomForm.roomId}'/>
	                            		<div class="form-group uploadFileSelect">
											<label>画像見出し</label>
	                            			<input type="text" id="imageCaption" name="imageCaption" maxlength="50"/>
									    </div>
										<%--
										<div class="form-group uploadFileSelect">
											<label>公開フラグ</label>
									    	<select name="publicationFlag">
		                            			<c:forEach var="publicationFlag" items="${flagList}" varStatus="status">
		                            				<option value="${publicationFlag.id}">${publicationFlag.name}</option>
		                            			</c:forEach>
		                            		</select>
									    </div>
 										--%>
		                            </div>
		                        </div>
			                </div>
			                <!-- /.panel-body -->
			            </div>
			            <div class="btnBox">
                  			<button type="button" id="roomUploadButton" class="btn btn-primary uploadImageBtn">アップロード</button>
		                </div>
					</div>
					<div class="modal-footer">
						 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					</div>
				</form>
			</c:if>
			<!-- メイン画像 -->
			<c:if test="${mainImageForm != null}">
				<form id="mainImageUploadForm" method="post" action="${pageContext.request.contextPath}/back/uploadmainImageFile" enctype="multipart/form-data">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">
			 				<span aria-hidden="true">&times;</span>
			 				<span class="sr-only">Close</span>
						</button>
		                <h4 class="modal-title" id="UploadModalLabel">画像アップロード</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
			                <div class="panel-heading">
			                    <h3 class="panel-title">アップロードする画像を選択して下さい</h3>
			                </div>
			                <div class="panel-body">
		                        <div class="form-group uploadFileSelect">
									<div class="form-group uploadFileSelect">
										<input id="uploadFile" type="file" name="fileupload" class="form-controll">
									</div>
		                            <div class="form-group uploadFileSelect">
										<label>表示フラグ</label>
										<select name="displayFlag">
											<c:forEach var="displayFlag" items="${displayFlagList}">
												<option value="${displayFlag.id}">${displayFlag.name}</option>
                       						</c:forEach>
										</select>
								    </div>
									<input type="hidden" name="mainImageId" value='${mainImage.mainImageId}'/>
                            		<div class="form-group uploadFileSelect">
										<label>遷移先URL</label>
                            			<input type="text" name="imageCaption"/>
								    </div>
									<div class="form-group uploadFileSelect">
										<label>遷移先方法</label>
								    	<select name="publicationFlag">
	                            			<c:forEach var="linkClass" items="${linkClassList}" varStatus="status">
	                            				<option value="${linkClass.id}">${linkClass.name}</option>
	                            			</c:forEach>
	                            		</select>
								    </div>
		                        </div>
			                </div>
			                <!-- /.panel-body -->
			            </div>
			            <div class="btnBox">
                  			<button type="button" id="mainImageUploadButton" class="btn btn-primary uploadImageBtn">アップロード</button>
		                </div>
					</div>
					<div class="modal-footer">
						 <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					</div>
				</form>
			</c:if>
		</div>
	</div>

</div>

