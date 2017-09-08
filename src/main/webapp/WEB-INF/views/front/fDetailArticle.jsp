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
		<link rel="stylesheet" href="resources/css/front/part/detailArticle.css">
		<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
		<script src="resources/js/googleMap/googleMapFunction.js" type="text/javascript"></script>
		<script src="resources/js/front/part/fDetailarticle.js" type="text/javascript"></script>
		<title>物件詳細画面</title>
	</head>
	<body>
		<%-- ヘッダー --%>
		<%@ include file="./parts/fHeader.jsp" %>
		<%-- contents --%>
		<div id="contents">
			<%-- 左コンテンツ --%>
			<div id="contents_box">
				<%-- contents_box --%>
				<form:form method="post" action="${pageContext.request.contextPath}/callDetailArticle" modelAttribute="fDetailArticleForm">
					<%-- 物件写真 --%>
					<section class="room">
						<%-- 物件写真（写真・大） --%>
						<div class="room_photo">
							<div class="slider-for">
								<div id="mainPhoto">
									 <c:if test="${article.buildingFileName != null}">
										<pre id="imageViewBuildingPhoto_${article.buildingId}" name="currentImg_buildingImagePhoto"
											style="background-image: url('${filePath}${article.buildingId}/${article.buildingFileName}')">
										</pre>
									</c:if>
									<c:if test="${article.buildingFileName == null}">
										<pre id="imageViewBuildingPhoto_${article.buildingId}" name="currentImg_buildingImagePhoto"
											style="background-image: url('${filePath}common/NoImage.jpg')">
										</pre>
									</c:if>
									<p id="buildingCaption">${article.buildingImageCaption}&nbsp;</p>
									<input id="buildingFileName_photo" type="hidden" value="${article.buildingFileName}"/>
									<c:forEach var="roomsImage" items="${roomsImageList}" varStatus="status">
										<pre id="imageViewRoomPhoto_${article.buildingId}_${article.roomId}_${status.index}" name="currentImg_roomImagePhoto"
											style="background-image: url('${filePath}${article.buildingId}/${article.roomId}/${roomsImage.fileName}'); display:none;">
										</pre>
										<p id="roomCaption_${article.roomId}_${status.index}" style="display:none">${roomsImage.imageCaption}&nbsp;</p>
										<input id="roomFileName_photo_${article.roomId}_${status.index}" type="hidden" value="${roomsImage.fileName}"/>
									</c:forEach>
								</div>
							</div>
							<div class="room_photo_slide slider slider-nav">
								<div id="roomSlider" class="room_photo_slide_in">
									<c:if test="${article.buildingFileName != null}">
										<pre id="imageViewBuildingSlider_${article.buildingId}" name="currentImg"
											style="background-image: url('${filePath}${article.buildingId}/${article.buildingFileName}')" width="11" height="45">
										</pre>
									</c:if>
									<c:if test="${article.buildingFileName == null}">
										<pre id="imageViewBuildingSlider_${article.buildingId}" name="currentImg"
											style="background-image: url('${filePath}common/NoImage.jpg')" width="11" height="45">
										</pre>
									</c:if>
									<input id="buildingFileName_slider" type="hidden" value="${article.buildingFileName}"/>
									<c:forEach var="roomsImage" items="${roomsImageList}" varStatus="status">
										<pre id="imageViewRoomSlider_${article.buildingId}_${article.roomId}_${status.index}" name="currentImg_roomImageSlider"
											style="background-image: url('${filePath}${article.buildingId}/${article.roomId}/${roomsImage.fileName}')"  width="11" height="45">
										</pre>
										<input id="roomFileName_slider_${article.roomId}_${status.index}" type="hidden" value="${article.buildingFileName}"/>
									</c:forEach>
								</div>
							</div>
						</div>
				 		<%-- 物件詳細 --%>
						<div class="room_name_box">
				 			<%-- 物件名・部屋番号 --%>
							<div class="room_name">
								<h4>${article.buildingName}</h4>
								<p class="room_num">${article.roomNumber}</p>
							</div>
				 			<%-- キャッチコピー --%>
							<p class="room_copy">
								${article.roomPrTitle}
							</p>
				 			<%-- 間取り・家賃・最寄り駅 --%>
							<div class="room_madori_box">
				 				<p>${article.floorPlanName}</p>
					 			<div class="room_price">
					 				<c:if test="${article.rent != null}">
										<div class="room_price_yen">
											<p><fmt:formatNumber value="${article.rent}" pattern="###,###円" /></p>
										</div>
										<div class="room_price_kanri">
											<c:if test="${article.commonServiceFee != null || article.administrativeCost != null}">
												<p>(
												<c:if test="${article.commonServiceFee != null}">
											 		<fmt:formatNumber value="${article.commonServiceFee}" pattern=" 共益費：###,###円 " />
										 		</c:if>
												<c:if test="${article.administrativeCost != null}">
											 		<fmt:formatNumber value="${article.administrativeCost}" pattern=" 管理費：###,###円 " />
										 		</c:if>
										 		)</p>
										 	</c:if>
										</div>
									</c:if>
								</div>
								<c:if test="${article.routeId1 != ''}">
					 				<p class="fl">
					 					${article.routeName1}
					 				</p>
					 				<p class="cf">
					 					${article.stationName1}
					 					<c:if test="${article.minutesWalk1 != null}">
					 						${article.minutesWalk1}分
					 					</c:if>
					 				</p>
				 				</c:if>
				 				<c:if test="${article.routeId2 != ''}">
					 				<p class="fl">
					 					${article.routeName2}
					 				</p>
					 				<p class="cf">
					 					${article.stationName2}
					 					<c:if test="${article.minutesWalk2 != null}">
					 						${article.minutesWalk2}分
					 					</c:if>
					 				</p>
				 				</c:if>
				 				<c:if test="${article.routeId3 != ''}">
					 				<p class="fl">
					 					${article.routeName3}
					 				</p>
					 				<p class="cf">
					 					${article.stationName3}
					 					<c:if test="${article.minutesWalk3 != null}">
					 						${article.minutesWalk3}分
					 					</c:if>
					 				</p>
					 			</c:if>
							</div>
							<%-- スタッフコメント --%>
							<p class="room_madori_comment">
								${article.roomPrDetail}
							</p>
						</div>
					</section>
					<%-- 物件概要 --%>
				 	<section class="room_gaiyou">
				 		<h6>物件概要</h6>
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="15%" class="room_gaiyou_td_gray">
									物件タイプ
								</td>
								<td width="35%">
									<c:forEach var="buildingType" items="${buildingTypeList}">
							 			<c:if test="${article.buildingType == buildingType.id}">
								 			${buildingType.name}
								 			<form:hidden path="buildingType"/>
								 		</c:if>
							 		</c:forEach>
								</td>
								<td width="15%" class="room_gaiyou_td_gray">
									構造
								</td>
								<td width="35%">
									<c:forEach var="structure" items="${structureList}">
							 			<c:if test="${article.structureId == structure.structureId}">
								 			${structure.structureName}
								 			<form:hidden path="structureId"/>
								 		</c:if>
							 		</c:forEach>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									最寄り駅
								</td>
								<td>
									${article.routeName1} ${article.stationName1}
									<c:if test="${article.minutesWalk1 != null}">
										${article.minutesWalk1}分
									</c:if>
									<%--
									${article.routeName2} ${article.stationName2} ${article.minutesWalk2}分
									${article.routeName3} ${article.stationName3} ${article.minutesWalk3}分
									--%>
								</td>
								<td class="room_gaiyou_td_gray">
									階建
								</td>
								<td>
									<c:if test="${article.numberOfStoreys != null}">
									${article.numberOfStoreys}階建
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									築年数
								</td>
								<td>
									<c:if test="${article.builtYear != null}">
										${article.builtYear}年${article.builtMonth}月
									</c:if>
								</td>
								<td class="room_gaiyou_td_gray">
									階
								</td>
								<td>
									${article.floorName}
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									間取り
								</td>
								<td>${article.floorPlanName}</td>
								<td class="room_gaiyou_td_gray">
									面積
								</td>
								<td>
									<c:if test="${article.space != null}">
										${article.space}m<sup>2</sup>
									</c:if>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									賃料
								</td>
								<td>
									<fmt:formatNumber value="${article.rent}" pattern="###,###円" />
								</td>
								<td class="room_gaiyou_td_gray">
									共益費・管理費
								</td>
								<td>
									<c:if test="${article.commonServiceFee != null}">
								 		<fmt:formatNumber value="${article.commonServiceFee}" pattern="共益費：###,###円" />
								 		<c:if test="${article.administrativeCost != null}">
							 				<br>
						 				</c:if>
							 		</c:if>

									<c:if test="${article.administrativeCost != null}">
								 		<fmt:formatNumber value="${article.administrativeCost}" pattern="管理費：###,###円" />
							 		</c:if>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									保険料
								</td>
								<td>
									<c:if test="${article.premium != null}">
							 			<fmt:formatNumber value="${article.premium}" pattern="###,###円" />
							 		</c:if>
								</td>
								<td class="room_gaiyou_td_gray">
									更新料
								</td>
								<td>
									<c:if test="${article.renewalFee != null}">
					 					<fmt:formatNumber value="${article.renewalFee}" pattern="###,###円" />
					 				</c:if>
					 				<c:if test="${article.renewalFee == null && article.renewalFeeClass != 0}">
					 					<c:forEach var ="renewalFeeClass" items="${renewalFeeClassList}">
					 						<c:if test="${renewalFeeClass.id == article.renewalFeeClass}">
							 					${renewalFeeClass.name}
							 				</c:if>
							 			</c:forEach>
							 		</c:if>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									敷金・保証金
								</td>
								<td>
									<c:if test="${article.securityDeposit != null}">
				 						<fmt:formatNumber value="${article.securityDeposit}" pattern="敷金：###,###円" />
				 						<c:if test="${article.securityMoney != null || article.securityMoneyClass != null}">
							 				<br>
							 			</c:if>
					 				</c:if>
					 				<c:if test="${article.securityDeposit == null && article.securityDepositClass != 0}">
					 					<c:forEach var ="securityDepositClass" items="${securityDepositClassList}">
					 						<c:if test="${securityDepositClass.id == article.securityDepositClass}">
							 					敷金：${securityDepositClass.name}
							 				</c:if>
							 			</c:forEach>
							 			<c:if test="${article.securityMoney != null || article.securityMoneyClass != null}">
							 				<br>
							 			</c:if>
						 			</c:if>
						 			<%-- 保証金も取得する！ --%>
									<c:if test="${article.securityMoney != null}">
				 						<fmt:formatNumber value="${article.securityMoney}" pattern="保証金：###,###円" />
					 				</c:if>
					 				<c:if test="${article.securityMoney == null && article.securityMoneyClass != 0}">
					 					<c:forEach var ="securityMoneyClass" items="${securityMoneyClassList}">
					 						<c:if test="${securityMoneyClass.id == article.securityMoneyClass}">
							 					保証金：${securityMoneyClass.name}
							 				</c:if>
							 			</c:forEach>
						 			</c:if>
								</td>
								<td class="room_gaiyou_td_gray">
									礼金
								</td>
								<td>

									<c:if test="${article.keyMoney != null}">
							 			<fmt:formatNumber value="${article.keyMoney}" pattern="###,###円" />
							 		</c:if>
							 		<c:if test="${article.keyMoney == null && article.keyMoneyClass != 0}">
					 					<c:forEach var ="keyMoneyClass" items="${keyMoneyClassList}">
					 						<c:if test="${keyMoneyClass.id == article.keyMoneyClass}">
							 					礼金：${keyMoneyClass.name}
							 				</c:if>
							 			</c:forEach>
							 		</c:if>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									入居可能日
								</td>
								<td>
									${article.deliveryTime}
								</td>
								<td class="room_gaiyou_td_gray">
									契約期間
								</td>
								<td>
									${article.contractPeriod}
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									設備
								</td>
								<td>
									<c:forEach var ="equipment" items="${equipmentList}">
						 				<c:forEach var ="roomEquipment" items="${roomEquipmentList}">
						 					<c:if test="${equipment.id == roomEquipment}">
						 						・${equipment.name}
						 					</c:if>
						 				</c:forEach>
						 			</c:forEach>
								</td>
								<td class="room_gaiyou_td_gray">
									こだわり条件
								</td>
								<td>
									<c:forEach var ="goodForCondition" items="${goodForConditionList}">
						 				<c:forEach var ="roomGoodForCondition" items="${roomGoodForConditionList}">
						 					<c:if test="${goodForCondition.id == roomGoodForCondition}">
						 						・${goodForCondition.name}
						 					</c:if>
						 				</c:forEach>
						 			</c:forEach>
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">
									注意事項
								</td>
								<td colspan="3">
									${article.importantPoints}
								</td>
							</tr>
							<tr>
								<td class="room_gaiyou_td_gray">所在地</td>
								<td colspan="3">
									<p>${article.province}${article.city}${article.townArea}${article.townAreaBelow}</p>
									<input id="latitude" type="hidden" value="${article.latitude}"/>
						 			<input id="longitude" type="hidden" value="${article.longitude}"/>
									<div class="room_gaiyou_map">
										<div id="gmap"></div>
										<div id="url"></div>
										<div id="geobtn"></div>
									</div>
									<div class="room_gaiyou_map">
										<div id="stv"></div>
										<div id="staticstv"></div>
									</div>
									<input id="buildingId" name="buildingId" type="hidden" value="${article.buildingId}" />
				 					<input id="roomId" name="roomId" type="hidden" value="${article.roomId}" />
				 					<div style="text-align:right;">
										<a  href="https://maps.google.co.jp/maps?ll=${article.latitude},${article.longitude}&q=loc:${article.latitude},${article.longitude}" target="_blank">
											大きな地図で見る
										</a>
									</div>
								</td>
							</tr>
						</table>
					</section>
				</form:form>

				<%-- この物件について問い合わせる --%>
				<section class="room_toiawase">
					<p class="room_toiawase_midashi">
						この物件の情報・周辺環境・契約手続きなど、お気軽にお問合せください
					</p>
					<form:form method="post" action="${pageContext.request.contextPath}/registContactArticle" modelAttribute="fContactArticleForm" name="fContactArticleForm">
						<input id="buildingId" name="buildingId" type="hidden" value="${article.buildingId}" />
			 			<input id="roomId" name="roomId" type="hidden" value="${article.roomId}" />
			 			<input id="buildingName" name="buildingName" type="hidden" value="${article.buildingName}" />
						<input id="roomNumber" name="roomNumber" type="hidden" value="${article.roomNumber}" />
						<input id="floorPlanId" name="floorPlanId" type="hidden" value="${article.floorPlanId}" />
						<input id="floorPlanName" name="floorPlanName" type="hidden" value="${article.floorPlanName}" />
						<input id="rent" name="rent" type="hidden" value="${article.rent}" />
						<input id="administrativeCost" name="administrativeCost" type="hidden" value="${article.administrativeCost}" />
						<input id="province" name="province" type="hidden" value="${article.province}" />
						<input id="city" name="city" type="hidden" value="${article.city}" />
						<input id="townArea" name="townArea" type="hidden" value="${article.townArea}" />
						<input id="townAreaBelow" name="townAreaBelow" type="hidden" value="${article.townAreaBelow}" />
						<input id="commonServiceFee" name="commonServiceFee" type="hidden" value="${article.commonServiceFee}" />
						<input id="administrativeCost" name="administrativeCost" type="hidden" value="${article.administrativeCost}" />
						<img src="resources/images/room/room_tel.png" width="372" height="25" class="fl">
						<p class="btn_room_toiawase">
							<a href="#" id="contactArticle" onclick="onSubmit('fContactArticleForm',this); return false;">
								お問合せフォーム
							</a>
						</p>
					</form:form>
				</section>
				<%-- この物件の空室一覧 --%>
				<section>
					<form:form id="fEmptyRoomForm" method="post" action="${pageContext.request.contextPath}/callBackSearchCondition" modelAttribute="fDetailArticleForm" name="fDetailArticleForm">
						<c:if test="${roomsList.size() > 0}">
							<div class="room_aki">
								<p>
									この物件の空室一覧
								</p>
							</div>
							<table border="0" cellspacing="0" cellpadding="0" class="room_aki_table">
								<tr class="room_aki_tr">
									<td width="100">部屋番号</td>
									<td width="100">間取り</td>
									<td width="100">面積</td>
									<td width="100">敷金・礼金</td>
									<td width="100">賃料</td>
									<td width="100">階</td>
									<td>&nbsp;</td>
								</tr>
								<c:forEach var="rooms" items="${roomsList}">
									<tr>
										<td>
											${rooms.roomNumber}
										</td>
										<td>
											${rooms.floorPlanName}
										</td>
										<td>
											<c:if test="${rooms.space != null}">
												<fmt:formatNumber value="${rooms.space}" pattern="###,###.##" />m<sup>2</sup>
											</c:if>
										</td>
										<td>
											<fmt:formatNumber value="${rooms.securityDeposit}" pattern="###,###円" />
											<br>
											<fmt:formatNumber value="${rooms.keyMoney}" pattern="###,###円" />
										</td>
										<td>
											<fmt:formatNumber value="${rooms.rent}" pattern="###,###円" />
										</td>
										<td>
											${rooms.floorName}
										</td>
										<td>
											<input id="buildingId" name="buildingId" type="hidden" value="${rooms.buildingId}" />
								 			<input id="roomId" name="roomId" type="hidden" value="${rooms.roomId}" />
											<p class="btn_room_aki">
												<a id="detailArticle" href="./callNewArticle?buildingId=${rooms.buildingId}&roomId=${rooms.roomId}">
													詳細
												</a>
											</p>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
					<!--“検索結果一覧に戻る”ボタン-->
					<p class="btn_green"><a href="#" onclick="onSubmit('fEmptyRoomForm',this);return false;">検索結果一覧に戻る</a></p>
					</form:form>

				</section>
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
				<img src="resources/images/common/gototop.jpg" width="89" height="70" alt="ページ上部へ">
			</a>
		</div>
		<%-- フッター --%>
		<%@ include file="./parts/fFooter.jsp" %>
	</body>
</html>
