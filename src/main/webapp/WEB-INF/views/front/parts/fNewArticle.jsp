<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<%-- 新着物件情報 --%>
<link rel="stylesheet" href="resources/css/front/part/newArticle.css">
<script src="resources/js/front/part/fNewArticle.js" type="text/javascript"></script>

<h2 class="midashi_tower">新着物件情報</h2>
<div class="top_newarrival">
	<div id="carouselWrap">
		<p id="carouselPrev"><img src="/images/common/icon_arrow_left.png" width="18" height="28" class="top_newarrival_arrow"></p>
	    <p id="carouselNext"><img src="/images/common/icon_arrow_right.png" width="18" height="28" class="top_newarrival_arrow"></p>
		<div id="carouse">
			<div id="carouselInner">
				<ul class="column">
				<c:forEach var="newArticle" items="${newArticleList}" varStatus="status">
					<li>
						<ul>
							<a href="#" onclick="onHref('./callNewArticle?buildingId=${newArticle.buildingId}&roomId=${newArticle.roomId}',this);">
								<%--
								<c:if test="${newArticle.fileName == null}">
									<img id="imageView_${newArticle.buildingId}" class="imgView img-responsive"
									src="${filePath}common/NoImage.jpg">
								</c:if>
								<c:if test="${newArticle.fileName != null}">
									<img id="imageView_${newArticle.buildingId}" class="imgView img-responsive"
									src="${filePath}${newArticle.buildingId}/${newArticle.fileName}">
								</c:if>
								 --%>
								<c:if test="${newArticle.fileName == null}">
									<span id="imageView_${newArticle.buildingId}" class="imgView img-responsive"
									style="background-image: url('${filePath}common/NoImage.jpg');">
									</span>
								</c:if>
								<c:if test="${newArticle.fileName != null}">
									<span id="imageView_${newArticle.buildingId}" class="imgView img-responsive"
									style="background-image: url('${filePath}${newArticle.buildingId}/${newArticle.fileName}');">
									</span>
								</c:if>
							</a>
						</ul>
						<ul style="width:130px;">
							 <a href="./callNewArticle?buildingId=${newArticle.buildingId}&roomId=${newArticle.roomId}">
								<p class="top_newarrival_title textOverflow1">
									${newArticle.roomPrTitle}
								</p>
								<p class="top_newarrival_name textOverflow1">
									${newArticle.buildingName}
								</p>
								<p class="top_newarrival_name textOverflow1">
									${newArticle.roomNumber}号室
								</p>
								<p class="top_newarrival_price">
									<fmt:formatNumber value="${newArticle.rent}" pattern="###,###円" />
								</p>
							</a>
						</ul>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
