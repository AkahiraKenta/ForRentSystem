$(document).ready(function() {

	function readonlyChange(classElementValue, targetElement) {
		if  (classElementValue == 1) {
			$(targetElement).prop("readonly", false);
		} else {
			$(targetElement).val("");
			$(targetElement).prop("readonly", true);
		}
	}

	function setOptionName(nemeElement, optionElement) {
		$(nemeElement).val($(optionElement)[0].options[$(optionElement)[0].options.selectedIndex].text);
	}

	// 階数有無
	setOptionName($("#numberOfStoreysName"),$("#numberOfStoreysId"));
	$("#numberOfStoreysId").change(function() {
		setOptionName($("#numberOfStoreysName"),$("#numberOfStoreysId"));
	});

	// 募集ステータス
	setOptionName($("#recruitmentStatusName"),$("#recruitmentStatus"));
	$("#recruitmentStatus").change(function() {
		setOptionName($("#recruitmentStatusName"),$("#recruitmentStatus"));
	});

	// 間取り有無
	setOptionName($("#floorPlanName"),$("#floorPlanId"));
	$("#floorPlanId").change(function() {
		setOptionName($("#floorPlanName"),$("#floorPlanId"));
	});

	// 敷金有無
	if ($("#securityDepositClass").val() != '1') {
		$("#securityDeposit").prop("readonly", true);
	}
	setOptionName($("#securityDepositClassName"),$("#securityDepositClass"));
	$("#securityDepositClass").change(function() {
		readonlyChange($("#securityDepositClass").val(),$("#securityDeposit"));
		setOptionName($("#securityDepositClassName"),$("#securityDepositClass"));
	});

	// 礼金有無
	if ($("#keyMoneyClass").val() != '1') {
		$("#keyMoney").prop("readonly", true);
	}
	setOptionName($("#keyMoneyClassName"),$("#keyMoneyClass"));
	$("#keyMoneyClass").change(function() {
		readonlyChange($("#keyMoneyClass").val(),$("#keyMoney"));
		setOptionName($("#keyMoneyClassName"),$("#keyMoneyClass"));
	});

	// 共益費有無
	if ($("#commonServiceFeeClass").val() != '1') {
		$("#commonServiceFee").prop("readonly", true);
	}
	setOptionName($("#commonServiceFeeClassName"),$("#commonServiceFeeClass"));
	$("#commonServiceFeeClass").change(function() {
		readonlyChange($("#commonServiceFeeClass").val(),$("#commonServiceFee"));
		setOptionName($("#commonServiceFeeClassName"),$("#commonServiceFeeClass"));
	});

	// 管理費区分
	if ($("#administrativeCostClass").val() != '1') {
		$("#administrativeCost").prop("readonly", true);
	}
	setOptionName($("#administrativeCostClassName"),$("#administrativeCostClass"));
	$("#administrativeCostClass").change(function() {
		readonlyChange($("#administrativeCostClass").val(),$("#administrativeCost"));
		setOptionName($("#administrativeCostClassName"),$("#administrativeCostClass"));
	});

	// 保険料区分
	if ($("#premiumClass").val() != '1') {
		$("#premium").prop("readonly", true);
	}
	setOptionName($("#premiumClassName"),$("#premiumClass"));
	$("#premiumClass").change(function() {
		readonlyChange($("#premiumClass").val(),$("#premium"));
		setOptionName($("#premiumClassName"),$("#premiumClass"));
	});

	// 更新料区分
	if ($("#renewalFeeClass").val() != '1') {
		$("#renewalFee").prop("readonly", true);
	}
	setOptionName($("#renewalFeeClassName"),$("#renewalFeeClass"));
	$("#renewalFeeClass").change(function() {
		readonlyChange($("#renewalFeeClass").val(),$("#renewalFee"));
		setOptionName($("#renewalFeeClassName"),$("#renewalFeeClass"));
	});

	// 保証金区分
	if ($("#securityMoneyClass").val() != '1') {
		$("#securityMoney").prop("readonly", true);
	}
	setOptionName($("#securityMoneyClassName"),$("#securityMoneyClass"));
	$("#securityMoneyClass").change(function() {
		readonlyChange($("#securityMoneyClass").val(),$("#securityMoney"));
		setOptionName($("#securityMoneyClassName"),$("#securityMoneyClass"));
	});

	// 保証会社必須フラグ
	setOptionName($("#guarantyCompanyName"),$("#guarantyCompanyFlag"));
	$("#guarantyCompanyFlag").change(function() {
		setOptionName($("#guarantyCompanyName"),$("#guarantyCompanyFlag"));
	});

	// 公開フラグ
	setOptionName($("#publicationName"),$("#publicationFlag"));
	$("#publicationFlag").change(function() {
		setOptionName($("#publicationName"),$("#publicationFlag"));
	});

	// 契約形態
	setOptionName($("#contractFormName"),$("#contractForm"));
	$("#contractForm").change(function() {
		setOptionName($("#contractFormName"),$("#contractForm"));
	});


	// 引渡方法
	setOptionName($("#deliveryMethodName"),$("#deliveryMethod"));
	$("#deliveryMethod").change(function() {
		setOptionName($("#deliveryMethodName"),$("#deliveryMethod"));
	});
});