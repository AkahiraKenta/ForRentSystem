<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/detailContact.js"></script>
		<title>お問合せ詳細画面</title>
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
	                    <h1 class="page-header">お問合せ情報詳細</h1>
	                </div>
	            </div>
	            <div class="row">
		            <form:form method="get" action="${pageContext.request.contextPath}/back/callUpdateContact" modelAttribute="contactForm">
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
		                                    	<c:forEach var="contact" items="${contactList}" varStatus="status">
			                                    	<c:if test="${status.index == 0}">
				                                        <form:hidden path="contactId" value="${contact.contactId}"/>
				                                        <tr>
				                                            <th>
				                                            	<span title="code" class="item_font_size">
				                                            		お問合せNo
				                                            	</span>
				                                            </th>
				                                            <td>
				                                            	<c:out value="${contact.contactId}" />
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
 																	<form:hidden path="processStatus" value="${contact.processStatus}" />
 																</select>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	会社名
				                                            </th>
				                                            <td>
																<c:out value="${contact.companyName}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	氏名
				                                            </th>
				                                            <td>
																<c:out value="${contact.lastName}${contact.firstName}" />
			                                            	</td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	メールアドレス
				                                            </th>
				                                            <td>
																<c:out value="${contact.mailAddress}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	電話番号
				                                            </th>
				                                            <td>
																<c:out value="${contact.tel}" />
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	お問合せ内容
				                                            </th>
				                                            <td>
																<pre><c:out value="${contact.contactContent}" /></pre>
				                                            </td>
				                                        </tr>
				                                        <tr>
				                                            <th class="item_font_size">
				                                            	登録日
				                                            </th>
				                                            <td>
																<c:out value="${contact.created}" />
				                                            </td>
				                                        </tr>
			                                        </c:if>
		                                        </c:forEach>
		                                   </tbody>
		                               </table>
		                            </div>
			                        <div class="btnBox">
										<a href="${pageContext.request.contextPath}/back/listContact" class="btn btn-warning btn-lg">戻る</a>
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