<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- ヘッダー --%>
<link rel="stylesheet" href="resources/css/front/part/header.css">
<header>
	<div class="cf">
		<h1>h1テキスト。賃貸マンション、賃貸アパート、賃貸一戸建て、賃貸物件の総合サイトです。</h1>
		<div id="logo">
			<a href="./frontTop">
				<img src="resources/images/common/logo.jpg" width="271" height="73" alt="KURASHI">
			</a>
		</div>
		<div id="tel_bnr">
			<img src="resources/images/common/header_tel.jpg" width="224" height="68" alt="お電話でのお問合せは">
		</div>
	</div>

	<%-- ナビゲーションメニュー --%>
	<nav>
		<ul>
		<li><a href="./frontTop">HOME</a></li>
		<li><a href="./searchStation">駅から探す</a></li>
		<li><a href="./searchArea">エリアから探す</a></li>
	    <li><a href="./companyInfo">会社情報</a></li>
		<li name="accessMenu"><a href="#">アクセス</a></li>
		<li><a href="./registContact">お問合せ</a></li>
		</ul>
	</nav>
	<%-- /ナビゲーションメニュー --%>
</header>
<%-- /ヘッダー --%>
