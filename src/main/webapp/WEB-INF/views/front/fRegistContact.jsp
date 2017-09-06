<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<link rel="stylesheet" href="resources/css/inputCheck/validationEngine.jquery.css" type="text/css"/>
		<script src="//maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script src="resources/js/googleMap/googleMapFunction.js" type="text/javascript"></script>
		<script src="resources/js/inputCheck/languages/jquery.validationEngine-ja.js" type="text/javascript" charset="utf-8"></script>
		<script src="resources/js/inputCheck/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
		<script src="resources/js/front/part/fContact.js" type="text/javascript" charset="utf-8"></script>

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
				<form:form method="post" action="${pageContext.request.contextPath}/registConfirmContact" modelAttribute="fContactForm" name="fContactForm">
					<%-- 一般のお問合せ --%>
					<section>
			 			<h2 class="midashi_mail_gr">一般のお問合せ</h2>
				 		<p class="contact_bukken_attention">下記のフォームに必要事項を入力のうえ、お問合せください。</p>
						<p class="contact_bukken_attention">お電話（TEL：03-0000-0000）でのお問合せも受け付けております。</p>
				 	</section>
				 	<%-- お問合せ内容 --%>
					<section>
				 		<div class="contact">
					 		<h6 class="contact_h6">お問合せ内容</h6>
					 		<table width="712" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td class="contact_td">
										<p>お名前</p>
										<p class="contact_must">必須</p>
									</td>
									<td>
										<form:input path="lastName" class="validate[required]" size="20"/>
					 					<form:input path="firstName" size="20"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td">
										<p>会社名</p>
									</td>
									<td>
										<form:input path="companyName" size="44"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td">
										<p>メールアドレス</p>
										<p class="contact_must">必須</p>
										<p>再確認用メールアドレス</p>
										<p class="contact_must">必須</p>
									</td>
									<td>
										<form:input path="mailAddress" class="validate[required,custom[email]]" size="44"/>
										<input type="text" id="reconfirmation" class="validate[required,custom[email]]" size="44" style="margin-top:20px;"/>
										<p id="errorMailAddress" style="color:#FF0000;"></p>
									</td>
								</tr>
								<tr>
									<td class="contact_td">
										<p>電話番号</p>
									</td>
									<td>
										<form:input path="tel" size="44"/>
									</td>
								</tr>
								<tr>
									<td class="contact_td">
										<p>お問合せ内容</p>
										<p class="contact_must">必須</p>
									</td>
									<td>
										<form:textarea path="contactContent" class="validate[required]"  cols="44" rows="5"/>
									</td>
								</tr>
							</table>
					 	</div>
				 		<%-- "確認画面へ"ボタン --%>
						<p class="btn_green">
							<a href="#" id="registConfirmContactLink" >確認画面へ</a>
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
				<img src="/images/common/gototop.jpg" width="89" height="70" alt="ページ上部へ">
			</a>
		</div>

		<%-- フッター --%>
		<%@ include file="./parts/fFooter.jsp" %>
	</body>
</html>