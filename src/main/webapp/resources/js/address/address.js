$(document).ready(function() {
	// 住所項目へ住所リストを追加
	var addressCallBack = function(cdata) {
		var city = "";
		var town = "";
		var optionBegin = "<option value='";
		var optionEnd = "</option>";
		for (var count = 0; count < cdata.length; count++) {
			city += optionBegin + count + "'>" + cdata[count].city + optionEnd;
			town += optionBegin + count + "'>" + cdata[count].town + optionEnd;
		}

		// 要素追加前に空状態にする
		$("#city option").remove();
		$("#townArea option").remove();
		$("#cityName").val();
		$("#townAreaName").val();

		// 都道府県に選択項目を追加
		$("#province").val(cdata[0].province);
		// 市区町村に選択項目を追加
		$("#city").append(city);
		// 町域に選択項目を追加
		$("#townArea").append(town);
		// 市区町村名称設定
		$("#cityName").val($("#city")[0].options[$("#city").val()].text);
		// 町域名称設定
		$("#townAreaName").val($("#townArea")[0].options[$("#townArea").val()].text);
		return false;
	};

	var errorProcess = function() {
		alert("");
		return false;
	};

	if ($("#zipCode").val() !="") {
		var url = '/ForRentSystem/getAddressList?zipCode='+ $("#zipCode").val();
		 addressAjax(url, $("#zipCode").val(), $("#addressImport"));
	}

	// 取込ボタン押下処理
	$("#addressImport").click(function() {
		if($("#zipCode").val() == "") {
			alert("郵便番号を入力してください。")
			return false;
		}
		var url = '/ForRentSystem/getAddressList?zipCode='+ $("#zipCode").val();
		addressAjax(url, $("#zipCode").val(), $(this));


		return false;
	});

	// 住所取得処理
	function addressAjax(url, val, element) {
		$(element).ajaxSubmit({
			type: 'get',
			dataType: 'json',
			data: $("#zipCode").val(),
			url: url,
			success: addressCallBack,
			error: errorProcess
		});
	}


	// 市区町村名称取得
	$("#city").change(function() {
		setOptionValue($("#cityName"), $("#city"));
	});
	// 町域名称取得
	$("#townArea").change(function() {
		setOptionValue($("#townAreaName"), $("#townArea"));
	});

	function setOptionValue(nameElement, valueElement) {
		$(nameElement).val($(valueElement)[0].options[$(valueElement)[0].options.selectedIndex].text);
	}
});