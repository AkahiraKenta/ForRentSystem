$(function(){

	// 成功時関数
	function successCallBack(cdata) {
		location.href = "/ForRentSystem/back/listBanner";
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 削除ボタンクリック
	$("#deleteBannerBtn").click(function() {
		 var result = confirm("バナー情報を削除します。よろしいですか");
		 if (result == true) {
			 $("#bannerForm").ajaxSubmit({
				 type: 'get',
				 dataType: 'json',
				 url: '/ForRentSystem/back/deleteBanner?bannerId=' + $("#bannerId").val(),
				 success: successCallBack,
				 error: errorCallBack
			 });
		 }
	});
});
