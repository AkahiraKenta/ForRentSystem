$(function(){

	// 成功時関数
	function successCallBack(cdata) {
		$("#message").text("バナーの表示順を更新しました。");
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 保存ボタンクリック
	$("#updateBannerDisplayNumber").click(function() {
		 var result = confirm("バナー情報の表示順を更新します。よろしいですか");
		 if (result == true) {
			 $("#bannerForm").ajaxSubmit({
				 type: 'get',
				 dataType: 'json',
				 url: '/ForRentSystem/back/callBannerDisplayNumber',
				 success: successCallBack,
				 error: errorCallBack
			 });
		 }
	});
});
