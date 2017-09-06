$(document).ready(function() {

	// 建物種別名称取得
	setOptionValue($("#buildingTypeName"), $("#buildingType"));
	$("#buildingType").change(function() {
		setOptionValue($("#buildingTypeName"), $("#buildingType"));
	});

	// 建物構成名称取得
	setOptionValue($("#structureName"), $("#structureId"));
	$("#structureId").change(function() {
		structureIdsetOptionValue($("#structureName"), $("#structureId"));
	});

	function setOptionValue(nameElement, valueElement) {
		$(nameElement).val($(valueElement)[0].options[$(valueElement)[0].options.selectedIndex].text);
	}

	// 入力制御
	// 郵便番号【数字のみ】
	$("#zipCode").numericInput({
	    allowNegative: true
	});
	// 最寄駅1(徒歩分)
	$("#minutesWalk1").numericInput({
	    allowNegative: true
	});
	// 最寄駅2(徒歩分)
	$("#minutesWalk2").numericInput({
	    allowNegative: true
	});
	// 最寄駅3(徒歩分)
	$("#minutesWalk3").numericInput({
	    allowNegative: true
	});
	// 築年数（年）【数字のみ】
	$("#builtYear").numericInput({
	    allowNegative: true
	});
	// 築年数（月）【数字のみ】
	$("#builtMonth").numericInput({
	    allowNegative: true
	});
	// 階建【数字のみ】
	$("#numberOfStoreys").numericInput({
	    allowNegative: true
	});

//	// 築年数(年)
//	$("#builtYear").blur(function() {
//		// 現在日取得
//		var date = new Date();
//		// 年を取得
//		var year = date.getFullYear();
//
//		if (year < $(this).val()) {
//			// 現在年以上を指定した場合空にする。
//			$(this).val("");
//		}
//	});
//	// 築年数(月)
//	$("#builtMonth").blur(function() {
//		if (12 < $(this).val()) {
//			// 12月以上を指定した場合空にする。
//			$(this).val("");
//		}
//	});
});

/**
 * ロード後実施し、GoogleMapを作成する。
 */
function googleMapSetUp() {
	draggableFlag = true;
	initialize();
}