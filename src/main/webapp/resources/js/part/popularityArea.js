$(function(){

	// ダイアログ表示
	$('.selectModalBtn').click(function(){
		$('#selectModal').modal();
	});

	// 成功時関数
	function successGetCallBack(cdata) {
		$("#areaList").children().remove();
		// 住所データ一覧項目作成
		for (var i = 0; i < cdata.length; i++) {
			$("#areaList").append(
					"<tr id='address_"+ i + "'>"
					+ "<td>" + cdata[i].province
					+ "</td>"
					+ "<td>" + cdata[i].city
					+ "</td>"
					+ "<td class='searchTownArea'>" + cdata[i].town
					+ "</td>"
					+ "<td><button type='button' id='registPopularityStation' class='btn btn-primary btn-sm'>追加</button></td>"
					+ "</tr>"
			);
		}
		return false;
	}

	// 都道府県が変更
	$("#provinceSelect").change(function() {
		$.ajaxSetup({scriptCharset:'utf-8'});
		$("#searchProvince").val($("#provinceSelect")[0].options[$("#provinceSelect")[0].options.selectedIndex].text);
		$("#searchForm").ajaxSubmit({
			type: 'post',
			dataType: 'json',
			url: '/ForRentSystem/back/searchPopularityArea',
			success: successGetCallBack,
			error: errorCallBack
		});
	});

	// 都道府県に紐付く住所情報を取得
	$("#addPopularityArea").click(function() {
		if($("#provinceSelect").val() != 0) {
			$("#searchForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/searchPopularityArea',
				success: successGetCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successAddCallBack(cdata) {
		if (cdata.rank == null) {
			alert("人気エリア設定が上限に達しました。削除してから追加を行ってください。")
			return false;
		}
		// 人気エリアデータ一覧項目作成
		$("#sortable").append(
			"<tr id='popularityArea_"+ cdata.popularityAreaId + "'>"
			+ "<td class='rank'>" + cdata.rank + "</td>"
			+ "<td>" + cdata.province + "</td>"
			+ "<td>" + cdata.city + "</td>"
			+ "<td>" + cdata.townArea + "</td>"
			+ "<td>"
			+ "<input type='hidden' id='popularityAreaId_" + cdata.popularityAreaId + "' name='popularityAreaId' value='" + cdata.popularityAreaId + "'/>"
			+ "<button type='button' id='deletePopularityArea' class='btn btn-danger btn-xs'>削除</button>"
			+ "</td>"
			+ "</tr>"
		);

		var i = 0;
		var element;
		var areaList = $("#areaList").children("tr");
		while (element = areaList[i++]) {
			if($(element).children("td.searchTownArea").text() == cdata.townArea) {
				$(element).remove();
			}
		}

		// ダイアログを閉じて、メッセージを親画面に表示させるようにする
		$('#selectModal').modal('hide');
		$("#message").text("人気エリアを追加しました。");

		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 追加ボタンクリック
	$("#areaList").on('click','button',function(){
		var result = confirm("人気順を追加します。よろしいですか");
		if (result == true) {
			$("#province").val($(this).parents("tr").children("td")[0].innerText);
			$("#city").val($(this).parents("tr").children("td")[1].innerText);
			$("#townArea").val($(this).parents("tr").children("td")[2].innerText);

			$("#areaForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/registPopularityArea',
				success: successAddCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successDeleteCallBack(cdata) {
		// 人気エリアデータ一覧項目削除
		$("#popularityArea_" + cdata.popularityAreaId).remove();
		numberingSortNo()
		$("#message").text("人気エリアを削除しました。");
		return false;
	}

	// 削除ボタンクリック
	$("#sortable").on('click','button',function(){
		var result = confirm("削除します。よろしいですか");
		if (result == true) {
			$("#popularityArea").ajaxSubmit({
				type: 'get',
				dataType: 'json',
				url: '/ForRentSystem/back/deletePopularityArea?popularityAreaId=' + $(this).parents("tr").attr("id").split("_")[1],
				success: successDeleteCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successUpdateCallBack() {
		$("#message").text("人気駅の順位を更新しました。");
		return false;
	}
	// 保存ボタンクリック
	$("#updatePopularityArea").click(function(){
		var result = confirm("人気順を更新します。よろしいですか");
		if (result == true) {
			$("#popularityArea").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/updatePopularityArea',
				success: successUpdateCallBack,
				error: errorCallBack
			});
		}
	});
});
