<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script src="resources/js/front/part/fCompany.js" type="text/javascript"></script>
		<title>会社情報・アクセス｜KURASHI｜不動産サイト</title>
	</head>
	<body>
	<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<%-- 会社情報 --%>
				<section class="company">
					<h4>会社情報</h4>
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="company_td">会社名</td>
							<td>株式会社 KURASHI</td>
						</tr>
						<tr>
							<td class="company_td">所在地</td>
							<td>〒103-0022  東京都中央区日本橋室町一丁目10番10号</td>
						</tr>
						<tr>
							<td class="company_td">代表者</td>
							<td>春藤 康仁</td>
						</tr>
						<tr>
							<td class="company_td">設立</td>
							<td>2009年 12月2日</td>
						</tr>
						<tr>
							<td class="company_td">資本金</td>
							<td>1,000万円</td>
						</tr>
						<tr>
							<td class="company_td">事業内容</td>
							<td>□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□</td>
						</tr>
						<tr>
							<td class="company_td">認可</td>
							<td>□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□</td>
						</tr>
						<tr>
							<td class="company_td">連絡先</td>
							<td>TEL:03-3527-9674（代表）／Fax:03-3527-9604／E-mail:kurashi@kurashi.co.jp</td>
						</tr>
					</table>
				</section>
				<%-- アクセス --%>
				<section id="accessSection">
					<h4>アクセス</h4>
					<%-- GoogleMap --%>
					<div class="access_map">
						<input id="latitude" type="hidden" value="35.6847794"/>
			 			<input id="longitude" type="hidden" value="139.7752288"/>
						会社住所のGoogleMap
						<div id="gmap"></div>
					</div>
					<%-- アクセス情報 --%>
					<div class="access">
						<p>東京都中央区日本橋室町一丁目10番10号</p>
						<p>東京メト半蔵門線線三越前駅より徒歩○分</p>
					</div>
				</section>
				<%-- /contents_box --%>
			</div>
			<!--/左コンテンツ-->
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
