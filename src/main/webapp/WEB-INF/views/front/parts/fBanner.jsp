<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- バナー --%>
<link rel="stylesheet" href="resources/css/front/part/banner.css">

<div class="aside_bnr">
	<c:forEach var="banner" items="${bannerList}" varStatus="status">
		<c:if test="${banner.transitionFlag == 1}">
			<a href="${banner.transitionUrl}" target="_blank">
		</c:if>
		<c:if test="${banner.transitionFlag == 2}">
			<a href="${banner.transitionUrl}">
		</c:if>
			<%--
			<img id="imageView_${banner.bannerId}" class="imgView img-responsive"
			src="${banner.filePath}/${banner.fileName}" width="155" height="50">
			 --%>
			 <pre id="imageView_${banner.bannerId}" class="imgView img-responsive"
			style="background-image: url('${banner.filePath}/${banner.fileName}');">
			</pre>
		<c:if test="${banner.transitionFlag == 1 || banner.transitionFlag == 2}">
			</a>
		</c:if>
	</c:forEach>
</div>
