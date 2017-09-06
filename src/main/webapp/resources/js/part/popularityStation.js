$(function(){

	// ダイアログ表示
	$('.selectModalBtn').click(function(){
		$('#selectModal').modal();
	});


	// 成功時関数
	function successGetCallBack(cdata) {
		$("#stationList").children().remove();
		// 人気駅データ一覧項目作成
		for (var i = 0; i < cdata.length; i++) {
			$("#stationList").append(
					"<tr id='station_"+ cdata[i].stationId + "'>"
//					+ "<td>" + cdata[i].stationId + "</td>"
					+ "<td>" + cdata[i].stationName + "</td>"
					+ "<td><button type='button' id='registPopularityStation' class='btn btn-primary btn-sm'>追加</button></td>"
					+ "</tr>"
			);
		}
		return false;
	}

	// 沿線が変更時
	$("#routeList").change(function() {
		$("#stationForm").ajaxSubmit({
			type: 'get',
			dataType: 'json',
			url: '/ForRentSystem/back/getStationListForPopularityStation?routeId=' + $(this).val(),
			success: successGetCallBack,
			error: errorCallBack
		});
	});

	//
	$("#addPopularityStation").click(function() {
		if($("#routeList").val() != 0) {
			$("#stationForm").ajaxSubmit({
				type: 'get',
				dataType: 'json',
				url: '/ForRentSystem/back/getStationListForPopularityStation?routeId=' + $("#routeList").val(),
				success: successGetCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successAddCallBack(cdata) {
		if (cdata.stationId == null) {
			alert("人気駅設定が上限に達しました。削除してから追加を行ってください。")
			return false;
		}
		// 人気駅データ一覧項目作成
		$("#sortable").append(
			"<tr id='popularityStation_"+ cdata.stationId + "'>"
			+ "<td class='rank'>" + cdata.rank + "</td>"
//			+ "<td>" + cdata.stationId + "</td>"
			+ "<td>" + cdata.stationName
			+ "<input type='hidden' id='popularityStationId_" +  cdata.stationId + "' name='popularityStationId' value='" + cdata.stationId + "'>"
			+ "</td>"
			+ "<td><button type='button' id='deletePopularityStation' class='btn btn-danger btn-xs'>削除</button></td>"
			+ "</tr>"
		);

		// 駅リストから削除
		$("#station_" + cdata.stationId).remove();

		// ダイアログを閉じて、メッセージを親画面に表示させるようにする
		$('#selectModal').modal('hide');
		$("#message").text("人気駅を追加しました。");
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 追加ボタンクリック
	$("#stationList").on('click','button',function(){
		var result = confirm("人気順を追加します。よろしいですか");
		if (result == true) {
			$("#stationForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/registPopularityStation?stationId=' + $(this).parents("tr").attr("id").split("_")[1],
				success: successAddCallBack,
				error: errorCallBack
			});
		}
	});


	// 成功時関数
	function successDeleteCallBack(cdata) {
		// 人気駅データ一覧項目削除
		$("#popularityStation_" + cdata.stationId).remove();
		numberingSortNo();
		// ダイアログを閉じて、メッセージを親画面に表示させるようにする
		$('#selectModal').modal('hide');
		$("#message").text("人気駅を削除しました。");
		return false;
	}

	// 削除ボタンクリック
	$("#sortable").on('click','button',function(){
		var result = confirm("削除します。よろしいですか");
		if (result == true) {
			$("#popularityStationForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/deletePopularityStation?stationId=' + $(this).parents("tr").attr("id").split("_")[1],
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
	$("#updatePopularityStation").click(function(){
		var result = confirm("人気順を更新します。よろしいですか");
		if (result == true) {
			$("#popularityStationForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/updatePopularityStation',
				success: successUpdateCallBack,
				error: errorCallBack
			});
		}
	});
});
