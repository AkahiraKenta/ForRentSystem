<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script src="resources/js/googleMap/googleMapFunction.js" type="text/javascript"></script>
		<title>一般のお問合せ｜KURASHI｜不動産サイト</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<hr>
				<form:form method="post" action="${pageContext.request.contextPath}/registCompleteContact" modelAttribute="fContactForm" name="fContactForm">
					<%-- 一般のお問合せ --%>
					<section>
						<h2 class="midashi_mail_gr">一般のお問合せ・確認</h2>
					</section>
					<%-- お問合せ内容 --%>
					<section>
				 		<div class="contact">
				 			<h6 class="contact_h6">お問合せ内容</h6>
							<table width="712" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="contact_td" width="200">
										<p>お名前</p>
										<p class="contact_must">必須</p>
									</td>
									<td style="vertical-align: middle;">
										<c:out value="${fContactForm.lastName}"></c:out>
										<c:out value="${fContactForm.firstName}"></c:out>
										<form:hidden path="lastName"/>
										<form:hidden path="firstName"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td" width="200">
										<p>会社名</p>
									</td>
									<td style="vertical-align: middle;">
										<c:out value="${fContactForm.companyName}"></c:out>
				 						<form:hidden path="companyName"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td" width="200">
										<p>メールアドレス</p>
										<p class="contact_must">必須</p>
									</td>
									<td style="vertical-align: middle;">
										<c:out value="${fContactForm.mailAddress}"></c:out>
				 						<form:hidden path="mailAddress"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td" width="200">
										<p>電話番号</p>
									</td>
									<td style="vertical-align: middle;">
										<c:out value="${fContactForm.tel}"></c:out>
				 						<form:hidden path="tel"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td" width="200">
										<p>お問合せ内容</p>
										<p class="contact_must">必須</p>
									</td>
									<td style="vertical-align: middle;">
										<c:out value="${fContactForm.contactContent}"></c:out>
				 						<form:hidden path="contactContent"/>
									</td>
								</tr>
							</table>
				 		</div>
						<p class="btn_gray fl">
							<a href="#" id="backRegistContact"  onclick="location.href='${pageContext.request.contextPath}/backRegistContact'">
								入力画面に戻る
							</a>
						</p>
						<p class="btn_green fl">
							<a href="#" id="sendContact" onclick="onSubmit('fContactForm',this); return false;">送信する</a>
						</p>
					</section>
				</form:form>
			</div>
			<%-- /左コンテンツ --%>

			<%-- 右カラム --%>
			<aside>
				<%-- おすすめ物件 --%>
				<%@ include file="./parts/fRecommendedRoom.jsp" %>
				<hr>
				<%-- 当サイトについて --%>
				<%@ include file="./parts/fExplainedSite.jsp" %>
				<hr>
				<%-- バナー --%>
				<%@ include file="./parts/fBanner.jsp" %>
			</aside>
			<%--/右カラム--%>
		</div>
		<%--/contents--%>
		<%-- ページ上部へ戻る --%>
		<div id="gototop">
			<a href="#">
				<img src="resources/images/common/gototop.jpg" width="89" height="70" alt="ページ上部へ">
			</a>
		</div>
		<%-- フッター --%>
		<%@ include file="./parts/fFooter.jsp" %>
	</body>
</html>