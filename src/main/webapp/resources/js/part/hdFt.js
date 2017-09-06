$(function(){
	// 成功時関数
	function successCallBack(cdata) {
		$("#headerImage").prop("src", cdata.headerFilePath+cdata.headerFileName);
		$("#footerImage").prop("src", cdata.footerFilePath+cdata.footerFileName);
		$("#message").text("ヘッダーフッター情報を更新しました。");
		window.scroll(0,0);
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 更新ボタンクリック
	$("#updateHdFt").click(function() {
		var result = confirm("ヘッダーフッター情報を更新します。よろしいですか");
		if (result == true) {
			$("#hdFtForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/editHdFt',
				success: successCallBack,
				error: errorCallBack
			});
		}
	});
});