$(function(){
	$('[name=deleteNews]').click(function() {
		var result = confirm("ニュースを削除します。よろしいですか");
		if (result == true) {
			$("#deleteNewsForm").ajaxSubmit({
				type: 'get',
				dataType: 'json',
				url: '/ForRentSystem/back/deleteNews?newsId=' + $(this).attr("id").split("_")[1],
				success: successCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successCallBack(cdata) {
		// ニュース一覧から削除
		$("#listNews_" + cdata).remove();
		// メッセージ
		$("#message").text("ニュース情報を削除しました。");
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}
});
