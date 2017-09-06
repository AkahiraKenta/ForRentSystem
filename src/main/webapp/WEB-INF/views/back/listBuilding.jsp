<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="${pageContext.request.contextPath}/resources/js/part/pager.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/listBuilding.js"></script>
		<title>建物一覧</title>
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
                    <h1 class="page-header">建物情報一覧</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="pull-left">一覧</span>
							<div class="clearfix"></div>
						</div>
						<div class="panel-body">
							<div>
								<h3  class="text-center text-success">
									<strong>
										<c:out value="${message}"></c:out>
									</strong>
								</h3>
							</div>
							<form:form method="post" action="${pageContext.request.contextPath}/back/callDetailBuilding" modelAttribute="listBuildingForm">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="edit-mainDataList">
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
													<td class="span2">${building.buildingId}</td>
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
														<input id="buildingDetail" type="button" class="btn btn-info btn-xs" value="詳細"  onclick="location.href = '${pageContext.request.contextPath}/back/callDetailBuildingByBuildingId?buildingId=${building.buildingId}'"/>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<%@ include file="parts/pager.jsp" %>
									<form:hidden path="buildingListFlag" id="buildingListFlag"/>
	                            </div>

								<c:if test="${listBuildingForm.buildingListFlag == 1}">
									<div class="btnBox">
										<a href="${pageContext.request.contextPath}/back/backListBuilding" class="btn btn-warning btn-lg">戻る</a>
									</div>
								</c:if>
							</form:form>
						</div><!-- /.panel-body -->
					</div><!-- /.panel -->
				</div><!-- /.col-lg-12 -->
           	</div><!-- /.row -->

        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
	</body>
</html>
