<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<title>管理画面TOP</title>
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
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">TOP画面</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
						<div class="panel-heading">
							<span class="pull-left">新着物件一覧</span>
							<div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="top_dataTable-Maindatalist">
                                	<form:form method="post" action="${pageContext.request.contextPath}/back/callDetailBuilding" modelAttribute="listBuildingForm">
	                                    <thead>
	                                        <tr>
	                                        	<th>
	                                                建物ID
	                                            </th>
	                                            <th>
	                                                建物番号
	                                            </th>
	                                            <th>
	                                                建物名称
	                                            </th>
	                                            <th>
	                                                郵便番号
	                                            </th>
	                                            <th>
	                                                住所
	                                            </th>
	                                            <th>
	                                                築年月
	                                            </th>
	                                            <th style="width: 36px;">
	                                            </th>
	                                        </tr>
	                                    </thead>
	                                    <tbody id="target">
		                                    <c:forEach var="building" items="${buildingDtoList}">
												<tr>
													<td>${building.buildingId}</td>
													<td>${building.buildingCode}</td>
													<td>${building.buildingName}</td>
													<td>${building.zipCode}</td>
													<td>${building.province} ${building.city}</td>
													<td>
														<c:if test="${building.builtYear != null}">
															${building.builtYear}年
														</c:if>
														<c:if test="${building.builtMonth != null}">
															${building.builtMonth}月
														</c:if>
													</td>
													<td>
														<input id="buildingDetail" type="button" class="btn btn-info btn-sm" value="詳細"
															onclick="location.href = '${pageContext.request.contextPath}/back/callDetailBuildingByBuildingId?buildingId=${building.buildingId}'"/>
													</td>
												</tr>
											</c:forEach>
	                                   </tbody>
	                               </form:form>
                               </table>
							</div>
		                </div>
		            </div>
				</div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
	                        <span class="pull-left">物件お問い合わせ一覧</span>
	                        <div class="clearfix"></div>
                       	</div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
                                    <thead>
                   						<tr>
                                            <th>
                                                お問い合わせNo
                                            </th>
                                            <th>
                                                氏名（姓）
                                            </th>
                                            <th>
                                                氏名（名）
                                            </th>
                                            <th>
                                                メールアドレス
                                            </th>
                                            <th>
                                                処理ステータス
                                            </th>
                                            <th style="width: 36px;">
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="target">
	                                    <c:forEach var="buildingContact" items="${buildingContactList}">
											<tr>
												<td>${buildingContact.buildingContactId}</td>
												<td>${buildingContact.lastName}</td>
												<td>${buildingContact.firstName}</td>
												<td>${buildingContact.mailAddress}</td>
												<td>
													<c:forEach var="processStatus" items="${processStatusList}">
														<c:if test="${processStatus.id == buildingContact.processStatus}">
															${processStatus.name}
														</c:if>
													</c:forEach>
												</td>
												<td>
													<input id="buildingDetail" type="button" class="btn btn-info btn-sm" value="詳細"
														onclick="location.href = '${pageContext.request.contextPath}/back/menuDetailBuildingContact?buildingContactId=${buildingContact.buildingContactId}'"/>
												</td>
											</tr>
										</c:forEach>
                                   </tbody>
                               </table>
                            </div>
                        </div>
                   	</div>
       		 	<!-- /.panel -->
               	</div>

            </div>
		</div>
   	</div>
    <!-- /#page-wrapper -->
    <%@ include file="./parts/footer.jsp" %>
    <!-- /#wrapper -->
	</body>
</html>
