<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- /.navbar-top-links -->
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search hide">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                    <button class="btn btn-default" type="button">
                        <i class="fa fa-search"></i>
                    </button>
                </span>
                </div>
                <!-- /input-group -->
            </li>
            <li id="menu-index">
                <a href="${pageContext.request.contextPath}/back/manageTop"><i class="fa fa-home fa-fw"></i> 管理画面トップ</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-list-alt fa-fw"></i> 物件管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/menuRegistBuilding">建物情報登録</a>
                    </li>
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/menuSearchBuilding">建物情報検索</a>
                    </li>
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/listBuilding">建物情報一覧</a>
                    </li>
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/listRecommendedRoom">おすすめ物件一覧</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-list-alt fa-fw"></i> お問い合わせ管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/listContact">お問い合わせ情報照会</a>
                    </li>
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/listBuildingContact">物件お問い合わせ情報照会</a>
                    </li>
                    <!--  未実装
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/">お問い合わせ先設定</a>
                    </li>
                    -->
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-list-alt fa-fw"></i> サイト管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/listNews">ニュース管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-list-alt fa-fw"></i> エリア・駅管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/settingPopularityArea">人気エリア設定</a>
                    </li>
                    <li id="menu-maindata">
                    	<a href="${pageContext.request.contextPath}/back/settingPopularityStation">人気駅設定</a>
                    </li>
                </ul>
            </li>
            <c:if test="${systemUserClass <= 2}">
	            <li>
	                <a href="#"><i class="fa fa-list-alt fa-fw"></i> 各種マスタ管理<span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/listFloorPlan">間取りマスタ管理</a>
	                    </li>
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/listGoodForCondition">こだわり条件マスタ管理</a>
	                    </li>
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/listStructure">構造マスタ管理</a>
	                    </li>
	                    <!--  未実装
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/">沿線マスタ管理</a>
	                    </li>
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/">駅マスタ管理</a>
	                    </li>
	                    <li id="menu-maindata">
	                    	<a href="${pageContext.request.contextPath}/back/">住所マスタ管理</a>
	                    </li>
	                    -->
	                </ul>
	            </li>
	            <li>
	                <a href="#"><i class="fa fa-wrench fa-fw"></i> システム設定<span class="fa arrow"></span></a>
	                <ul class="nav nav-second-level">
	                	<!--  未実装
	                    <li id="menu-options-gaedit">
	                        <a href="${pageContext.request.contextPath}/back/listMainImage">メイン画像設定</a>
	                    </li>
	                    -->
	                    <li id="menu-options-gaedit">
	                        <a href="${pageContext.request.contextPath}/back/listBanner">バナー設定</a>
	                    </li>
	                    <!--  未実装
	                    <li id="menu-options-gaedit">
	                        <a href="${pageContext.request.contextPath}/back/hdFt">ヘッダー・フッター基本設定</a>
	                    </li>
	                    -->
	                    <li id="menu-options-gaedit">
	                        <a href="${pageContext.request.contextPath}/back/displayNumber">表示件数設定</a>
	                    </li>
	                    <li id="menu-options-gaedit">
	                        <a href="${pageContext.request.contextPath}/back/listSystemUser">システムユーザ管理</a>
	                    </li>
	                </ul>
	                <!-- /.nav-second-level -->
	            </li>
			</c:if>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->