<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<script src="http://malsup.github.com/jquery.form.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/part/searchBuilding.js"></script>
		<title>建物検索画面</title>
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
                        <li><a href="./back/">トップ</a></li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">建物情報検索</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<form:form method="post" action="${pageContext.request.contextPath}/back/callBildingList" modelAttribute="searchBuildingForm">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                                <span class="pull-left"> 検索条件</span>
	                                <div class="clearfix"></div>
	                        </div>
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-striped table-hover" id="edit-mainDataList" style="border-bottom: 1px solid #ddd;">
	                                    <tbody>
	                                        <tr>
	                                            <th class="item_font_size">
                                            		建物番号
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-w-7 form-control" path="buildingCode" maxlength="20"/>
	                                            </td>
	                                            <th class="item_font_size">
                                            		建物名称
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="buildingName" maxlength="20"/>
	                                            </td>
	                                            <th class="item_font_size">
                                            		建物種別
	                                            </th>
	                                            <td>
													<form:select path="buildingType"  items="${buildingTypeList}" itemLabel="name" itemValue="id">
													</form:select>
													<form:hidden path="buildingTypeName"/>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
                                            		沿線
	                                            </th>
	                                            <td>
					                                <form:select path="route" items="${routeList}" itemLabel="routeName" itemValue="routeId" class="nearestRoute">
													</form:select>
			                                        <form:hidden path="routeName"/>
	                                        	</td>
	                                            <th class="item_font_size">
                                            		駅
	                                            </th>
	                                            <td>
					                                <form:select path="station"  items="${stationList}" itemLabel="stationName" itemValue="stationId">
													</form:select>
													<form:hidden path="stationName"/>
	                                        	</td>
	                                            <th class="item_font_size">
	                                            </th>
	                                            <td>
	                                        	</td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
                                            		〒
	                                            </th>
	                                            <td>
					                                <form:input class="input-w-3 form-control  btn-group" path="zipCode" maxlength="8"/>
                                              		<button name="addressImport" id="addressImport" type="button" class="btn btn-info btn-sm">取込</button>
                                              		<button name="addressClear" id="addressClear" type="button" class="btn btn-warning btn-sm">クリア</button>
	                                        	</td>
	                                            <th class="item_font_size">
                                            		都道府県
	                                            </th>
	                                            <td>
	                                            	<form:input class="input-xlarge form-control" path="province" readOnly="true"/>
	                                        	</td>
	                                            <th class="item_font_size">
                                            		市区町村
	                                            </th>
	                                            <td>
				                                	<form:select path="city">
			                                        </form:select>
			                                        <form:hidden path="cityName"/>
	                                        	</td>
	                                        </tr>
	                                        <tr>
	                                            <th class="item_font_size">
                                            		築年数
	                                            </th>
	                                            <td>
					                                <form:input class="input-xlarge form-control" path="builtYear" maxlength="4"/>
	                                        	</td>
	                                            <th class="item_font_size">
	                                            </th>
	                                            <td>
	                                        	</td>
	                                            <th class="item_font_size">
	                                            </th>
	                                            <td>
	                                        	</td>
	                                        </tr>
	                                   </tbody>
	                               </table>

	                                <div class="btnBox">
	                                	<a href="${pageContext.request.contextPath}/back/backSearchBuilding" class="btn btn-warning btn-lg">戻る</a>
										<input id="search" type="submit" class="btn btn-primary btn-lg" value="検索" />
									</div>

								</div>
							</div>
	                    </div>
	                    <!-- /.panel -->
                	</div>
               	</form:form>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>