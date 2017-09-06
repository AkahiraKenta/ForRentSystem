<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%-- include --%>
		<%@ include file="./parts/fInclude.jsp" %>
		<script src="resources/js/front/part/fSearchRefineResult.js"></script>
		<script src="resources/js/front/part/fPager.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<%--
				<div>
					<input id="backAreaSearch" type="submit" class="btn btn-primary btn-sm"
						onclick="location.href='${pageContext.request.contextPath}/callBackStationSearch'" value="最寄駅検索へ" />
					<input id="backStationSearch" type="submit" class="btn btn-primary btn-sm"
						onclick="location.href='${pageContext.request.contextPath}/callBackAreaSearch'" value="エリア検索へ" />
				</div>
				--%>
				<%-- 検索結果一覧 --%>
				<section>
					<%@ include file="./parts/fSearchResult.jsp" %>
				</section>

				<%-- 条件で絞り込む --%>
				<section>
					<%@ include file="./parts/fSearchCondition.jsp" %>
				</section>
				<%-- 検索結果 --%>
				<section>
					<form:form method="post" action="${pageContext.request.contextPath}/callSearchResultArticleSort" modelAttribute="fSearchConditionForm" name="searchResultArticleSort">
						<%-- ○○件の物件が検索されました --%>
						<div class="search_kensuu">
							<p class="search_kensuu_num">${viewCount}</p>
							<p class="search_kensuu_p">件の物件が検索されました</p>
							<div class="search_narabi">
								<label for="">並び替え</label>
								<form:select path="sortArticleId" items="${sortArticleList}" itemLabel="name" itemValue="id" onChange="document.searchResultArticleSort.submit(); return false;"/>
							</div>
						</div>
					</form:form>
					<form:form method="post" action="${pageContext.request.contextPath}/pagerForSearchResultArticle" modelAttribute="fSearchConditionForm" name="searchResultArticlePager">
						<%-- ページ送り --%>
						<%@ include file="./parts/fPager.jsp" %>
					</form:form>
					<form:form method="post" action="${pageContext.request.contextPath}/callDetailArticle" modelAttribute="fDetailArticleForm" name="fDetailArticleForm">
						<%-- 物件情報 --%>
						<c:forEach var="article" items="${articleList}" varStatus="listStatus">
							<div class="result_bukken">
								<h5>${article.buildingName} ${article.roomNumber}</h5>
								<%--
								<c:if test="${article.fileName != null}">
									<img id="imageView_${article.buildingId}"  class="imgView img-responsive"
											src="${filePath}${article.buildingId}/${article.fileName}">
								</c:if>
								<c:if test="${article.fileName == null}">
									<img id="imageView_${article.buildingId}" class="imgView img-responsive"
											src="${filePath}common/NoImage.jpg"">
								</c:if>
								 --%>
								 <c:if test="${article.fileName != null}">
									<pre id="imageView_${article.buildingId}" class="imgView img-responsive"
											style="background-image: url('${filePath}${article.buildingId}/${article.fileName}');">
									</pre>
								</c:if>
								<c:if test="${article.fileName == null}">
									<pre id="imageView_${article.buildingId}" class="imgView img-responsive"
											style="background-image: url('${filePath}common/NoImage.jpg');">
									</pre>
								</c:if>
								<table width="70%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td colspan="6" class="result_bukken_copy result_pr_title">${article.roomPrTitle}</td>
									</tr>
									<tr>
										<td width="18%" class="result_bukken_copy">最寄り駅：</td>
										<td colspan="5" class="result_bukken_copy">
											${article.routeName1} ${article.stationName1}
											<c:if test="${article.minutesWalk1 != null}">
												${article.minutesWalk1}分
											</c:if>
										</td>
									</tr>
									<tr>
										<td class="result_bukken_copy">賃料：</td>
										<td colspan="5" class="result_bukken_copy">
											<c:if test="${article.rent != null}">
												<p><fmt:formatNumber value="${article.rent}" pattern="###,###円" /></p>
											</c:if>
											<%--存在する場合のみ、共益費と管理費を表示 --%>
											<c:if test="${article.commonServiceFee != null || article.administrativeCost != null}">
												<p>
													(
													<c:if test="${article.commonServiceFee != null}">
														<fmt:formatNumber value="${article.commonServiceFee}" pattern=" 共益費：###,###円 " />
													</c:if>
													<c:if test="${article.administrativeCost != null}">
														<fmt:formatNumber value="${article.administrativeCost}" pattern=" 管理費：###,###円 " />
													</c:if>
													)
												</p>
											</c:if>
										</td>
									</tr>
									<tr>
										<td class="result_bukken_madori" >間取り</td>
										<td class="result_bukken_madori" >面積</td>
										<td class="result_bukken_madori" >階</td>
										<td class="result_bukken_madori" >築年月</td>
										<td class="result_bukken_madori" >敷金</td>
										<td class="result_bukken_madori" >礼金</td>
									</tr>
									<tr>
										<td class="result_bukken_madori2">
											${article.floorPlanName}
										</td>
										<td class="result_bukken_madori2">
											<c:if test="${article.space != null}">
												${article.space}m<sup>2</sup>
											</c:if>
										</td>
										<td class="result_bukken_madori2">
											${article.floorName}
										</td>
										<td class="result_bukken_madori2">
											<c:if test="${article.builtYear != null}">
												${article.builtYear}年${article.builtMonth}月
											</c:if>
										</td>
										<td class="result_bukken_madori2">
											<c:if test="${article.securityDeposit != null}">
						 						<fmt:formatNumber value="${article.securityDeposit}" pattern="###,###円" />
							 				</c:if>
							 				<c:if test="${article.securityDeposit == null}">
							 					<c:if test="${article.securityDepositClass != null}">
							 						<c:forEach var ="securityDepositClass" items="${securityDepositClassList}">
								 						<c:if test="${securityDepositClass.id == article.securityDepositClass && securityDepositClass.id != 0}">
										 					${securityDepositClass.name}
										 				</c:if>
										 			</c:forEach>
										 		</c:if>
						 					</c:if>
										</td>
										<td class="result_bukken_madori2">
											<c:if test="${article.keyMoney != null}">
									 			<fmt:formatNumber value="${article.keyMoney}" pattern="###,###円" />
									 		</c:if>
									 		<c:if test="${article.keyMoney == null}">
						 						<c:forEach var ="keyMoneyClass" items="${keyMoneyClassList}">
							 						<c:if test="${keyMoneyClass.id == article.keyMoneyClass && keyMoneyClass.id != 0}">
									 					${keyMoneyClass.name}
									 				</c:if>
									 			</c:forEach>
						 					</c:if>
										</td>
									</tr>
								</table>
								<%--“この条件で絞り込む”ボタン --%>
								<p class="btn_green">
									<input id="buildingId" name="buildingId" type="hidden" value="${article.buildingId}" />
									<input id="roomId" name="roomId" type="hidden" value="${article.roomId}" />
									<a id="detailArticle" href="#" onclick="onHref('./callNewArticle?buildingId=${article.buildingId}&roomId=${article.roomId}', this)">詳細をみる</a>
								</p>
							</div>
						</c:forEach>
					</form:form>
					<form:form method="post" action="${pageContext.request.contextPath}/pagerForSearchResultArticle" modelAttribute="fSearchConditionForm" name="searchResultArticlePager">
						<%-- ページ送り --%>
						<form:hidden path="totalNumber"/>
						<form:hidden path="currentPage"/>
						<form:hidden path="viewNumber"/>
						<form:hidden path="pageTotalNumber"/>
						<%@ include file="./parts/fPager.jsp" %>
					</form:form>
				</section>
				<!--/contents_box-->
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