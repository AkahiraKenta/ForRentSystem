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

	// 名称取得処理
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

});


// 郵便番号検索ダイアログ表示
function popup_modeless(url){
	var newWin = window.open(
		url,    //移動先
		"pop",  //ターゲット名（aタグのtargetと同様）
		"width=550, height=480"
	);
}

/**
 * ロード後実施し、GoogleMapを作成する。
 */
function googleMapSetUp() {
	draggableFlag = true;
	initialize();
}