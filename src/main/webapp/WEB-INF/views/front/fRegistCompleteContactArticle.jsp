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
		<title>物件のお問合せ・完了｜KURASHI｜不動産サイト</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<%-- 物件のお問合せ --%>
				<section>
					<h2 class="midashi_mail">物件のお問合せ・完了</h2>
					<p class="contact_thanks_p">物件へのお問合せありがとうございます。</p>
					<p class="contact_thanks_p margin_b70">後ほど、担当者よりご連絡をさせていただきます。</p>
					<!--“確認画面へ”ボタン-->
					<p class="btn_vio"><a href="./frontTop">トップページへ</a></p>
				</section>
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