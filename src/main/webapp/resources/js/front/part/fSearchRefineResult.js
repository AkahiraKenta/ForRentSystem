$(function(){
	// ページングURLを設定
	setHref("/ForRentSystem/pagerForSearchResultArticle");

	// 建物種別チェックON処理
	var buildingTypeValue = $("#selectedBuildingTypeHidden").val();
	var buildingTypeList = $("#buildingTypeList").children("input");
	checkedExe(buildingTypeValue, buildingTypeList);

	// 設備チェックON処理
	var equipmentValue = $("#selectedEquipmentHidden").val();
	var equipmentList = $("#equipmentList").children("input");
	checkedExe(equipmentValue, equipmentList);

	// 間取りチェックON処理
	var floorPlanValue = $("#selectedFloorPlanHidden").val();
	var floorPlanList = $("#floorPlanList").children("input");
	checkedExe(floorPlanValue, floorPlanList);

	// こだわり条件チェックON処理
	var goodForConditionValue = $("#selectedGoodForConditionHidden").val();
	var goodForConditionList = $("#goodForConditionList").children("input");
	checkedExe(goodForConditionValue, goodForConditionList);

	function checkedExe(elementValueList, checkBoxElementList) {
		var splitValue = elementValueList.replace('[',"").replace(']',"").split(",");

		for (var i=0; i < splitValue.length; i++) {
			var trimSplitValue = splitValue[i].trim();
			for(var j=0; j < checkBoxElementList.length; j++) {
				if (trimSplitValue == checkBoxElementList[j].value) {
					checkBoxElementList[j].checked=true;
				}

			}
		}
	}

	// 絞り込み条件の開閉処理
	$('.acordion').click(function () {
		if($(".result_jyouken").css("display")=="none"){
			// 表示処理
			$(this).addClass("active");
			$(this).removeClass("none");
			$(".midashi_jyouken_block").removeClass("midashi_jyouken_block").addClass("midashi_jyouken");
			$(".result_jyouken").slideDown(200);
		}else{
			// 非表示処理
			$(this).removeClass("active");
			$(this).addClass("none");
			$(".midashi_jyouken").removeClass("midashi_jyouken").addClass("midashi_jyouken_block");
			$(".result_jyouken").slideUp(200);

		}
	});
});