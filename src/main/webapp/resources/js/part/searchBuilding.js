$(document).ready(function() {

	// 住所項目へ住所リストを追加
	var addressCallBack = function(cdata) {
		var city = "";
		var town = "";
		var optionBegin = "<option value='";
		var optionEnd = "</option>";
		for (var count = 0; count < cdata.length; count++) {
			city += optionBegin + count + "'>" + cdata[count].city + optionEnd;
		}
		// 都道府県に選択項目を追加
		$("#province").val(cdata[0].province);
		// 市区町村に選択項目を追加
		$("#city").append(city);
		// 市区町村名称設定
		$("#cityName").val($("#city")[0].options[$("#city").val()].text);
		return false;
	};

	// 項目へ沿線、駅リストを追加
	var routeCallBack = function(cdata) {
		setStation($("#station"), cdata);
		// 沿線1
		$("#routeName").val($("#route")[0].options[$("#route")[0].options.selectedIndex].text);
		// 駅1
		$("#stationName").val($("#station")[0].options[$("#station")[0].options.selectedIndex].text);
		return false;
	};


	// 駅リスト追加共通処理
	function setStation(stationElement, cdata) {
		var station = "";
		var optionBegin = "<option value='";
		var optionEnd = "</option>";
		station += optionBegin + "999'> " + optionEnd;
		for (var count = 0; count < cdata.length; count++) {
			station += optionBegin +  cdata[count].stationId + "'>" + cdata[count].stationName + optionEnd;
		}
		// 駅選択項目を初期化
		$(stationElement).empty();
		// 駅選択項目を追加
		$(stationElement).append(station);
	};

	var errorProcess = function() {
		alert("");
		return false;
	};

	// 取込ボタン押下処理
	$("#addressImport").click(function() {
		if($("#zipCode").val() == "") {
			alert("郵便番号を入力してください。")
			return false;
		}
		var url = '/ForRentSystem/getAddressListForSearchBuilding?zipCode='+ $("#zipCode").val();
		$(this).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $("#zipCode").val(),
			url: url,
			success: addressCallBack,
			error: errorProcess
		});

		return false;
	});

	// 沿線値変更時処理
	$("#route").change(function() {
		var url = '/ForRentSystem/getStationListForSearchBuilding?routeId='+ $(this).val();
		$(this).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $(this).val(),
			url: url,
			success: routeCallBack,
			error: errorProcess
		});
		return false;
	});



	// 建物種別名称取得
	setOptionValue($("#buildingTypeName"), $("#buildingType"));
	$("#buildingType").change(function() {
		setOptionValue($("#buildingTypeName"), $("#buildingType"));
	});
	// 市区町村名称取得
	$("#city").change(function() {
		setOptionValue($("#cityName"), $("#city"));
	});

	// 初期値に路線が選択されていた場合
	if($("#route").val() != null && $("#route").val() != "") {
		// 駅１名称取得
		setOptionValue($("#stationName"), $("#station"));
	}

	$("#station").change(function() {
		setOptionValue($("#stationName"), $("#station"));
	});

	function setOptionValue(nameElement, valueElement) {
		$(nameElement).val($(valueElement)[0].options[$(valueElement)[0].options.selectedIndex].text);
	}

	$("#addressClear").click(function() {
		$("#zipCode").val("");
		$("#province").val("");
		$('select#city option:first-child').remove();
	});

});