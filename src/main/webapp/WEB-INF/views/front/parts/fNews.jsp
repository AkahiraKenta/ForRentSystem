<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- 最新ニュース --%>
<link rel="stylesheet" href="resources/css/front/part/news.css">
<h2 class="midashi_horn">最新ニュース</h2>
<div class="top_news">
	<dl>
		<c:forEach var="news" items="${newsList}" varStatus="status">
			<dt>
				${news.postedDate}
			</dt>
			<dd>
				<c:if test="${news.linkUrl != '' }">
					<c:if test="${news.linkClass == 1}">
						<a href="${news.linkUrl}" target="_blank">
					</c:if>
					<c:if test="${news.linkClass != 1}">
						<a href="${news.linkUrl}">
					</c:if>
							${news.newsTitle}
						</a>
				</c:if>
				<c:if test="${news.linkUrl == ''}">
					${news.newsTitle}
				</c:if>
			</dd>
		</c:forEach>
	</dl>
</div>
