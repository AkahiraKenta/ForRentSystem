<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <h1>KURASHI管理システム</h1>
</div>
<!-- /.navbar-header -->
<ul class="nav navbar-top-links navbar-right">
    <li>ログイン名 : ${systemUserName}</li>
    <li>
	    <a href="#" id="logout">ログアウト</a>
    </li>
</ul>