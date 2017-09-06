<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<title>KURASHI｜不動産サイト</title>
		<meta name="keywords" content=",">
		<meta name="description" content="">
	</head>
	<body>
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<section>
					<%-- メイン画像 --%>
					<%@ include file="./parts/fMainImage.jsp" %>
				</section>

				<section>
					<%-- 新着物件情報 --%>
					<%@ include file="./parts/fNewArticle.jsp" %>
				</section>

				<section>
					<%-- 人気駅から探す --%>
					<%@ include file="./parts/fPopularityStation.jsp" %>

					<%-- 人気エリアから探す --%>
					<%@ include file="./parts/fPopularityArea.jsp" %>
				</section>

				<section>
					<%-- 最新ニュース --%>
					<%@ include file="./parts/fNews.jsp" %>
				</section>
				<%-- /contents_box --%>
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