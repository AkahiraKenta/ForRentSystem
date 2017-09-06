<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/detailBuildingContact.js"></script>
		<title>物件お問合せ詳細画面</title>
	</head>
    <body>
	    <div id="wrapper">
	        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	            <%@ include file="./parts/header.jsp" %>
	            <%@ include file="./parts/menu.jsp" %>
	        </nav>
	        <div id="page-wrapper">
	            <div class="row disnon">
	                <div class="col-lg-12">
	                    <ol class="breadcrumb">
	                        <li><a href="./back/">トップ</a></li>
	                    </ol>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">物件お問合せ情報詳細</h1>
	                </div>
	            </div>
	            <div class="row">
		            <form:form method="get" action="${pageContext.request.contextPath}/back/callUpdateBuildingContact" modelAttribute="buildingContactForm">
		                <div class="col-lg-8">
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
	                                <span class="pull-left"> 詳細確認</span>
	                                <div class="clearfix"></div>
		                        </div>
		                        <div class="panel-body">
		                            <div class="table-responsive">
		                                <table class="table table-striped table-bordered table-hover editTable" id="edit-mainDataList">
		                                    <tbody>
		                                    	<c:forEach var="buildingContact" items="${buildingContactList}" varStatus="status">
			                                    	<c:if test="${status.index == 0}">
				                                        <form:hidden path="buildingId" value="${buildingContact.buildingId}"/>
				                                        <form:hidden path="roomId" value="${buildingContact.roomId}"/>
				                                        <form:hidden path="buildingContactId" value="${buildingContact.buildingContactId}"/>
				                                        <tr>
				                                            <th>
				                                            	<span title="code" class="item_font_size">
				                                            		お問合せNo
				                                            	</span>
				                                            </th>
				                                            <td>
				                                            	<c:out value="${buildingContact.buildingContactId}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	建物名称
				                                            </th>
				                                            <td>
																<c:out value="${buildingContact.buildingName}" />
				                                            </td>

				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	部屋番号
				                                            </th>
				                                            <td>
																<c:out value="${buildingContact.roomNumber}" />
																<input id="detailRoom"type="button" class="btn btn-info btn-xs" value="部屋詳細へ" style="margin-left:10px"
	                                    								onclick="location.href = '${pageContext.request.contextPath}/back/callDetailRoomFromBuildingContact?buildingContactId=${buildingContact.buildingContactId}&buildingId=${buildingContact.buildingId}&roomId=${buildingContact.roomId}'"/>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	処理ステータス
				                                            </th>
				                                            <td>
 																<select id="selectProcessStatus" name="processStatus">
 																	<c:forEach var="processStatus" items="${processStatusList}">
 																		<option value="${processStatus.id}">
 																			${processStatus.name}
 																		</option>
 																	</c:forEach>
 																	<form:hidden path="processStatus" value="${buildingContact.processStatus}" />
 																</select>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	お問合せ種類
				                                            </th>
				                                            <td>
																<c:forEach var="processClass" items="${processClassList}" >
																	<c:if test="${processClass.id == buildingContact.processClass}">
																		<c:out value="${processClass.name}" />
																	</c:if>
																</c:forEach>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	氏名
				                                            </th>
				                                            <td>
																<c:out value="${buildingContact.lastName}${buildingContact.firstName}" />
			                                            	</td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	メールアドレス
				                                            </th>
				                                            <td>
																<c:out value="${buildingContact.mailAddress}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	電話番号
				                                            </th>
				                                            <td>
																<c:out value="${buildingContact.tel}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	入居希望時期
				                                            </th>
				                                            <td>
				                                            	<c:forEach var="residentsHopeTimeClass" items="${residentsHopeTimeClassList}" >
																	<c:if test="${residentsHopeTimeClass.id == buildingContact.residentsHopeTime}">
																		<c:out value="${residentsHopeTimeClass.name}" />
																	</c:if>
																</c:forEach>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	お問合せ内容
				                                            </th>
				                                            <td>
																<pre><c:out value="${buildingContact.contactContent}" /></pre>
				                                            </td>
				                                        </tr>
			                                        </c:if>
		                                        </c:forEach>
		                                   </tbody>
		                               </table>
		                            </div>
			                        <div class="btnBox">
										<a href="${pageContext.request.contextPath}/back/listBuildingContact" class="btn btn-warning btn-lg">戻る</a>
										 <input id="updateProcessStatus" type="submit" class="btn btn-primary btn-lg" value="処理ステータス更新" />
									</div>
		                        </div>
		                    </div>
		                </div>
		            </form:form>
			    </div>
	        </div>
            <!-- /#page-wrapper -->
        	<%@ include file="./parts/footer.jsp" %>
	    </div>
    </body>
</html>