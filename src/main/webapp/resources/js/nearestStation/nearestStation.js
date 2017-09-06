$(document).ready(function() {
	// 最寄駅1項目へ沿線、駅リストを追加
	var nearestRoute1CallBack = function(cdata) {
		setStation($("#nearestStation1"), $("#minutesWalk1"), cdata, "nearestRoute1");
		// 沿線1
		$("#nearestRouteName1").val($("#nearestRoute1")[0].options[$("#nearestRoute1")[0].options.selectedIndex].text);
		// 駅1
		$("#nearestStationName1").val($("#nearestStation1")[0].options[$("#nearestStation1")[0].options.selectedIndex].text);

		if ($("#nearestRoute1").val() == 999) {
			// 駅選択項目をdisabled
			$("#nearestStation1").prop("disabled", "disabled");
			// 徒歩分項目をdisabled
			$("#minutesWalk1").prop("disabled", "disabled");
		} else {
			// 駅選択項目をdisabled解除
			$("#nearestStation1").prop("disabled", "");
			// 徒歩分項目をdisabled解除
			$("#minutesWalk1").prop("disabled", "");
		}
		return false;
	};

	// 最寄駅2項目へ沿線、駅リストを追加
	var nearestRoute2CallBack = function(cdata) {
		setStation($("#nearestStation2"), $("#minutesWalk2"), cdata , "nearestRoute2");
		// 沿線2
		$("#nearestRouteName2").val($("#nearestRoute2")[0].options[$("#nearestRoute2")[0].options.selectedIndex].text);
		// 駅2
		$("#nearestStationName2").val($("#nearestStation2")[0].options[$("#nearestStation2")[0].options.selectedIndex].text);
		if ($("#nearestRoute2").val() == 999) {
			// 駅選択項目をdisabled
			$("#nearestStation2").prop("disabled", "disabled");
			// 徒歩分項目をdisabled
			$("#minutesWalk2").prop("disabled", "disabled");
		} else {
			// 駅選択項目をdisabled解除
			$("#nearestStation2").prop("disabled", "");
			// 徒歩分項目をdisabled解除
			$("#minutesWalk2").prop("disabled", "");
		}

		return false;
	};

	// 最寄駅3項目へ沿線、駅リストを追加
	var nearestRoute3CallBack = function(cdata) {
		setStation($("#nearestStation3"), $("#minutesWalk3"), cdata, "nearestRoute3");
		// 沿線3
		$("#nearestRouteName3").val($("#nearestRoute3")[0].options[$("#nearestRoute3")[0].options.selectedIndex].text);
		// 駅3
		$("#nearestStationName3").val($("#nearestStation3")[0].options[$("#nearestStation3")[0].options.selectedIndex].text);
		if ($("#nearestRoute3").val() == 999) {
			// 駅選択項目をdisabled
			$("#nearestStation3").prop("disabled", "disabled");
			// 徒歩分項目をdisabled
			$("#minutesWalk3").prop("disabled", "disabled");
		} else {
			// 駅選択項目をdisabled解除
			$("#nearestStation3").prop("disabled", "");
			// 徒歩分項目をdisabled解除
			$("#minutesWalk3").prop("disabled", "");
		}
		return false;
	};

	var errorProcess = function() {
		alert("");
		return false;
	};

	// 駅リスト追加共通処理
	function setStation(stationElement, minutesWalk, cdata, myNearestRoute) {
		// 各沿線IDを取得
		var routeList = [$("#nearestRoute1").val(),$("#nearestRoute2").val(), $("#nearestRoute3").val()];
		// 自身の沿線IDを取得
		var routeId = $("#"+ myNearestRoute).val();
		// 自身の最寄駅NO
		var nearestNumber = myNearestRoute.substr( (myNearestRoute.length-1) );
		// 駅名称格納変数
		var stationList = new Array();
		var stationListCount = 0;

		// 他の最寄駅で選択した駅名称を取得（自身の沿線情報と異なる場合は、駅名称取得しない）
		for (var count = 0; count < routeList.length; count++) {
			if (routeList[count] == routeId && count+1 != nearestNumber) {
				// 他の沿線IDと同じだった場合、駅名称を取得
				var stationNameStr = "nearestStationName"+(count+1);
				var stationName = $("#" + stationNameStr).val();
				if (stationName != "" && stationName != undefined) {
					for (var countStation = 0; countStation < cdata.length; countStation++) {
						if (stationName == cdata[countStation].stationName) {
							stationList[stationListCount] = stationName;
							stationListCount++;
						}
					}
				}
			}
		}

		var station = "";
		var optionBegin = "<option value='";
		var optionEnd = "</option>";
		station += optionBegin + "999'> " + optionEnd;

		L:for (var countStation = 0; countStation < cdata.length; countStation++) {
			if (cdata[countStation].stationName == "") {
				continue;
			}
			if(stationList != null) {
				for (var count = 0; count < stationList.length; count++) {
					if (stationList[count] == cdata[countStation].stationName) {
						// 他の駅名称と同じ場合は処理しない
						continue L;
					}
				}
			}
			station += optionBegin +  cdata[countStation].stationId + "'>" + cdata[countStation].stationName + optionEnd;
		}

		// 駅選択項目を初期化
		$(stationElement).empty();
		// 駅選択項目を追加
		$(stationElement).append(station);
		// 徒歩分項目を空にする
		$(minutesWalk).val("");
	};

	// 最寄駅1値変更時処理
	$("#nearestRoute1").change(function() {
		var url = '/ForRentSystem/getStationList?routeId='+ $(this).val();
		$(this).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $(this).val(),
			url: url,
			success: nearestRoute1CallBack,
			error: errorProcess
		});
		return false;
	});

	// 最寄駅2値変更時処理
	$("#nearestRoute2").change(function() {
		var url = '/ForRentSystem/getStationList?routeId='+ $(this).val();
		var option = $(this).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $(this).val(),
			url: url,
			success: nearestRoute2CallBack,
			error: errorProcess
		});
		return false;
	});

	// 最寄駅3値変更時処理
	$("#nearestRoute3").change(function() {
		var url = '/ForRentSystem/getStationList?routeId='+ $(this).val();
		var option = $(this).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $(this).val(),
			url: url,
			success: nearestRoute3CallBack,
			error: errorProcess
		});
		return false;
	});

	if ($('#minutesWalk1').val() == "") {
		// 路線1初期設定と名称取得
		setInitValue($("#nearestRoute1"));
		setOptionValue($("#nearestRouteName1"), $("#nearestRoute1"));
		// 駅1初期設定と名称取得
		setInitValue($("#nearestStation1"));
		setOptionValue($("#nearestStationName1"), $("#nearestStation1"));
		$("#nearestStation1").change(function() {
			setOptionValue($("#nearestStationName1"), $("#nearestStation1"));
		});
	}
	if ($('#minutesWalk2').val() == "") {
		// 路線2初期設定と名称取得
		setInitValue($("#nearestRoute2"))
		setOptionValue($("#nearestRouteName2"), $("#nearestRoute2"));
		// 駅2初期設定と名称取得
		setInitValue($("#nearestStation2"))
		setOptionValue($("#nearestStationName2"), $("#nearestStation2"));
		$("#nearestStation2").change(function() {
			setOptionValue($("#nearestStationName2"), $("#nearestStation2"));
		});
	}
	if ($('#minutesWalk3').val() == "") {
		// 路線3初期設定と名称取得
		setInitValue($("#nearestRoute3"))
		setOptionValue($("#nearestRouteName3"), $("#nearestRoute3"));
		// 駅3初期設定と名称取得
		setInitValue($("#nearestStation3"))
		setOptionValue($("#nearestStationName3"), $("#nearestStation3"));
		$("#nearestStation3").change(function() {
			setOptionValue($("#nearestStationName3"), $("#nearestStation3"));
		});
	}

	// 沿線項目が""の場合
	if ($("#nearestRoute1").val() == 999) {
		// 駅選択項目をdisabled
		$("#nearestStation1").prop("disabled", "disabled");
		// 徒歩分項目をdisabled
		$("#minutesWalk1").prop("disabled", "disabled");
	}
	// 沿線項目が""の場合
	if ($("#nearestRoute2").val() == 999) {
		// 駅選択項目をdisabled
		$("#nearestStation2").prop("disabled", "disabled");
		// 徒歩分項目をdisabled
		$("#minutesWalk2").prop("disabled", "disabled");
	}
	// 沿線項目が""の場合
	if ($("#nearestRoute3").val() == 999) {
		// 駅選択項目をdisabled
		$("#nearestStation3").prop("disabled", "disabled");
		// 徒歩分項目をdisabled
		$("#minutesWalk3").prop("disabled", "disabled");
	}

	function setOptionValue(nameElement, valueElement) {
		if ($(valueElement)[0].options[$(valueElement)[0].options.selectedIndex] != undefined) {
			// 名称要素に値をセットする
			$(nameElement).val($(valueElement)[0].options[$(valueElement)[0].options.selectedIndex].text);
		}
	}

	function setInitValue(element) {
		// 初期値「空」を設定する
		var optinElement = $(element)[0].options[0];
		$(optinElement).before($("<option>").val("999").text(""));
		if ($(element)[0].options[0] != undefined) {
			// 初期値「空」を選択状態とする
			$(element).val($(element)[0].options[0].value);
		}
	}


	// 最寄駅１（駅）選択変更された場合
	$("#nearestStation1").change(function() {
		$("#nearestStationName1").val($("#nearestStation1")[0].options[$("#nearestStation1")[0].options.selectedIndex].text);
	});

	// 最寄駅２（駅）選択変更された場合
	$("#nearestStation2").change(function() {
		$("#nearestStationName2").val($("#nearestStation2")[0].options[$("#nearestStation2")[0].options.selectedIndex].text);
	});

	// 最寄駅３（駅）選択変更された場合
	$("#nearestStation3").change(function() {
		$("#nearestStationName3").val($("#nearestStation3")[0].options[$("#nearestStation3")[0].options.selectedIndex].text);
	});
});