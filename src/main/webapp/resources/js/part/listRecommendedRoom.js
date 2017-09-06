$(function(){

	// 成功時関数
	function successDeleteCallBack(cdata) {
		// 人気エリアデータ一覧項目削除
		$("#recommendRoom_" + cdata).remove();
		numberingSortNo()
		$("#message").text("おすすめ物件を削除しました。");
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 削除ボタンクリック
	$("#sortable").on('click','button',function(){
		var result = confirm("削除します。よろしいですか");
		if (result == true) {
			$("#recommendRoomForm").ajaxSubmit({
				type: 'get',
				dataType: 'json',
				url: '/ForRentSystem/back/deleteRecommendRoom?id=' + $(this).parents("tr").attr("id").split("_")[1],
				success: successDeleteCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successUpdateCallBack() {
		$("#message").text("おすすめ順の順位を更新しました。");
		return false;
	}

	// 保存ボタンクリック
	$("#updateRecommendRank").click(function(){
		var result = confirm("おすすめ順を更新します。よろしいですか");
		if (result == true) {
			$("#recommendRoomForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/updateRecommendRoom',
				success: successUpdateCallBack,
				error: errorCallBack
			});
		}
	});
});
