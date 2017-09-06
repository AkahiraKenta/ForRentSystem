$(function(){
	// 成功時関数
	function successCallBack(cdata) {
		$("#message").text("表示件数を更新しました。");
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 保存ボタンクリック
	$("[name=updateDisplayNumber").click(function() {
		var result = confirm("表示件数を更新します。よろしいですか");
		if (result == true) {
			var systemSettingId = $(this).parents("tr").attr("id").split("_")[1];
			var displayNumberId = $(this).parents("tr").find("select").val();
			$("#displayNumberForm").ajaxSubmit({
				type: 'get',
				dataType: 'json',
				url: '/ForRentSystem/back/updateDisplayNumber?systemSettingId=' + systemSettingId + '&displayNumberId=' + displayNumberId,
				success: successCallBack,
				error: errorCallBack
			});
		}
	});
});