<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<%-- メイン画像  --%>
<figire>
	<img src="resources/images/top/top_main.jpg" width="760" height="200">
</figire>

<%--
<div>
	<hr>
	メイン画像
	<c:forEach var="mainImage" items="${mainImageList}" varStatus="status">
		<div>
			<img id="imageView_${mainImage.mainImageId}" class="imgView img-responsive"
				src="${mainImage.filePath}/${mainImage.fileName}" style="width:130px; height:100px;">
		</div>
	</c:forEach>
</div>
--%>