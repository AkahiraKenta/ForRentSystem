<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script src="resources/js/googleMap/googleMapFunction.js" type="text/javascript"></script>
		<title>物件のお問合せ・確認｜KURASHI｜不動産サイト</title>
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
				<form:form method="post" action="${pageContext.request.contextPath}/registCompleteContactArticle" modelAttribute="fContactArticleForm" name="fContactArticleForm">
					<%-- 物件のお問合せ --%>
					<section>
						<h2 class="midashi_mail">物件のお問合せ・確認</h2>
						<%-- お問合せ物件の情報 --%>
				 		<div class="contact_bukken_name">
				 			<h6>お問合せ物件</h6>
				 			<dl>
								<dt>物件名：</dt>
								<dd>${fContactArticleForm.buildingName}${fContactArticleForm.roomNumber}</dd>
								<dt>所在地：</dt>
								<dd>${fContactArticleForm.province}${fContactArticleForm.city}${fContactArticleForm.townArea}${fContactArticleForm.townAreaBelow}</dd>
								<dt>間取り：</dt>
								<dd>${fContactArticleForm.floorPlanName}</dd>
								<dt>賃料&nbsp;&nbsp;&nbsp;：</dt>
								<dd>
									<fmt:formatNumber value="${fContactArticleForm.rent}" pattern="###,###円" />
								</dd>
								<c:if test="${fContactArticleForm.commonServiceFee != null}">
									<dt>共益費：</dt>
									<dd>
										<fmt:formatNumber value="${fContactArticleForm.commonServiceFee}" pattern="###,###円" />
									</dd>
								</c:if>
								<c:if test="${fContactArticleForm.administrativeCost != null}">
									<dt>管理費：</dt>
									<dd>
										<fmt:formatNumber value="${fContactArticleForm.administrativeCost}" pattern="###,###円" />
									</dd>
								</c:if>
								<form:hidden path="buildingName"></form:hidden>
				 				<form:hidden path="roomNumber"></form:hidden>
				 				<form:hidden path="buildingId"></form:hidden>
				 				<form:hidden path="roomId"></form:hidden>
				 				<form:hidden path="province"></form:hidden>
				 				<form:hidden path="city"></form:hidden>
				 				<form:hidden path="townArea"></form:hidden>
				 				<form:hidden path="townAreaBelow"></form:hidden>
				 				<form:hidden path="floorPlanName"></form:hidden>
				 				<form:hidden path="rent"></form:hidden>
				 				<form:hidden path="administrativeCost"></form:hidden>
							</dl>
						</div>
					</section>
					<%-- お問合せ内容 --%>
					<section>
						<div class="result_jyouken">
							<h6 class="contact_bukken_h6">お問合せ内容</h6>
							<table width="712" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="25%" class="contact_bukkenn_td">
										<p>お問合せの種類</p>
										<p class="contact_must">必須</p>
									</td>
									<td width="75%">
										<c:out value="${fContactArticleForm.process}"></c:out>
				 						<form:hidden path="processClass"/>
									</td>
								</tr>
								<tr>
									<td class="contact_bukkenn_td">
										<p>お名前</p>
										<p class="contact_must">必須</p></td>
									<td>
										<c:out value="${fContactArticleForm.lastName}"></c:out>
							 			<form:hidden path="lastName"/>
							 			<c:out value="${fContactArticleForm.firstName}"></c:out>
							 			<form:hidden path="firstName"/>
									</td>
								</tr>
								<tr>
									<td class="contact_bukkenn_td">
										<p>メールアドレス</p>
										<p class="contact_must">必須</p>
									</td>
									<td>
										<c:out value="${fContactArticleForm.mailAddress}"></c:out>
				 						<form:hidden path="mailAddress"/>
									</td>
								</tr>
								<tr>
									<td class="contact_bukkenn_td">
										<p>電話番号</p>
									</td>
									<td>
										<c:out value="${fContactArticleForm.tel}"></c:out>
				 						<form:hidden path="tel"/>
									</td>
								</tr>
								<tr>
									<td class="contact_bukkenn_td">
										<p>入居希望時期</p>
									</td>
									<td>
										<c:out value="${fContactArticleForm.residentsHopeTimeName}"></c:out>
				 						<form:hidden path="residentsHopeTime"/>
									</td>
								</tr>
								<tr>
									<td class="contact_bukkenn_td">
										<p>その他・ご希望など</p>
									</td>
									<td>
										<pre><c:out value="${fContactArticleForm.contactContent}"></c:out></pre>
				 						<form:hidden path="contactContent"/>
									</td>
								</tr>
							</table>
						 	<%-- "送信する"ボタン --%>
							<p class="btn_gray fl">
								<a href="#" id="backRegistContactArticle" onclick="location.href='${pageContext.request.contextPath}/backRegistContactArticle'">入力画面に戻る</a>
							</p>
							<p class="btn_vio fl">
								<a href="#" id="sendContactArticle" onclick="onSubmit('fContactArticleForm',this);">送信する</a>
							</p>
						</div>
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