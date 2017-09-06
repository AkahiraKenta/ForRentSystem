<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<%@ include file="./parts/include.jsp" %>
		<title>バナー登録完了画面</title>
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
                    <h1 class="page-header">バナー登録完了</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-7">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                <span class="pull-left"> 登録完了</span>
                                <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <a href="${pageContext.request.contextPath}/back/manageTop">管理画面TOPへ</a>
                        </div>
                        <div class="panel-body">
                            <a href="${pageContext.request.contextPath}/back/listBanner">バナー設定一覧画面へ</a>
                        </div>
                    </div>
                    <!-- /.panel -->
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        <%@ include file="./parts/footer.jsp" %>
    </div>
    <!-- /#wrapper -->
    </body>
</html>
