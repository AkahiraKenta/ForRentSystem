<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- おすすめ物件 --%>
<link rel="stylesheet" href="resources/css/front/part/recommendedRoom.css">
<h3>おすすめ物件</h3>
<ul>
	<c:forEach var="recommendedRoomImage" items="${recommendedRoomImageList}" varStatus="status">
		<li>
			<a href="#" onclick="onHref('./callNewArticle?buildingId=${recommendedRoomImage.buildingId}&roomId=${recommendedRoomImage.roomId}',this);">
				<%--
				<c:if test="${recommendedRoomImage.fileName == null}">
					<img id="imageView_${recommendedRoomImage.id}" class="imgView img-responsive"
							src="${filePath}common/NoImage.jpg">
				</c:if>
				<c:if test="${recommendedRoomImage.fileName != null}">
					<img id="imageView_${recommendedRoomImage.id}" class="imgView img-responsive"
							src="${filePath}${recommendedRoomImage.buildingId}/${recommendedRoomImage.fileName}">
				</c:if>
				 --%>
				<c:if test="${recommendedRoomImage.fileName == null}">
					<p id="imageView_${recommendedRoomImage.id}" class="imgView img-responsive"
							style="background-image: url('${filePath}common/NoImage.jpg')">
					</p>
				</c:if>
				<c:if test="${recommendedRoomImage.fileName != null}">
					<p id="imageView_${recommendedRoomImage.id}" class="imgView img-responsive"
							style="background-image: url('${filePath}${recommendedRoomImage.buildingId}/${recommendedRoomImage.fileName}')">
					</p>
				</c:if>
			    <p class="aside_title textOverflow1">
			    	${recommendedRoomImage.roomPrTitle}
			    </p>
			    <p class="aside_name textOverflow1">
			    	${recommendedRoomImage.buildingName}
			    </p>
			    <p class="aside_name textOverflow1">
			    	${recommendedRoomImage.roomNumber}号室
			    </p>
			    <p class="aside_price">
			    	<fmt:formatNumber value="${recommendedRoomImage.rent}" pattern="###,###円" />
			    </p>
		    </a>
		</li>
	</c:forEach>
	<input type="hidden" id="recommendedRoomImageList" value="${recommendedRoomImageList}"/>
</ul>

