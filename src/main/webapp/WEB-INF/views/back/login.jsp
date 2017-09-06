<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>ログイン</title>
	    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/assets/css/sb-admin-2.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
		<!-- <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script> -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
		<!-- <script src="${pageContext.request.contextPath}/resources/assets/js/localization/en.min.js"></script> -->
	</head>
	<body>

		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default" style="margin-top: 25%;" id="main">

						<div class="panel-heading">
							<h3 class="panel-title" id="siteID" style="color: #fff;">ForRentSystem</h3>
						</div>

						<div class="panel-body">
							<section id="contents">

								<div class="lead">
									<h1 style="color: #fff;">Login</h1>
								</div>

								<section class="detailList">
									<form:form method="post" action="${pageContext.request.contextPath}/back/login" modelAttribute="loginForm">
										<form:errors path="*" element="p" cssClass="validateErrors" />

										<fieldset>
											<div class="form-group"  style="color: #fff;">
												ログインID&nbsp;<form:input class="form-control" placeholder="ID" path="systemUserLoginId"/>
											</div>
											<div class="form-group" style="color: #fff;">
												パスワード&nbsp;<form:password class="form-control" placeholder="Password" path="systemUserPassword"/>
											</div>
										</fieldset>

										<div>
											<input class="btn btn-lg btn-primary btn-block" id="login" type="submit" value="ログイン" style="margin-left: 0px;" />
										</div>
									</form:form>
								</section>

							</section>
						</div>

					</div>
				</div>
			</div>
		</div>

	</body>
</html>
