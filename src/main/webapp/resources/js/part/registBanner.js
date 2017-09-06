$(function(){

	// 成功時関数
	function successCallBack(cdata) {
		if (!cdata.emptyFileCheckFlag) {
			alert("空ファイルが指定されました。ファイルを確認し、再度アップロードを行ってください。");
		} else if (!cdata.fileSizeCheckFlag){
			alert("アップロードする画像が500KBを超えています。画像サイズを調整して再度アップロードを行ってください。");
		} else {
			location.href = "/ForRentSystem/back/callRegistCompleteBanner";
		}
		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 登録ボタンクリック
	$("#registBannerBtn").click(function() {
		if($('#uploadFile').val() == ""){
			 $("#message").text("画像ファイルを指定してください。");
			 return;
		 }
		 $("#message").text("");
		 var result = confirm("バナー情報を登録します。よろしいですか");
		 if (result == true) {
			 $("#bannerForm").ajaxSubmit({
				 type: 'post',
				 dataType: 'json',
				 url: '/ForRentSystem/back/callRegistBanner',
				 success: successCallBack,
				 error: errorCallBack
			 });
		 }
	});
});
