$(function(){

	// 成功時関数
	function successCallBack(cdata) {
		if (!cdata.emptyFileCheckFlag) {
			alert("空ファイルが指定されました。ファイルを確認し、再度アップロードを行ってください。");
		} else if (!cdata.fileSizeCheckFlag){
			alert("アップロードする画像が500KBを超えています。画像サイズを調整して再度アップロードを行ってください。");
		} else {
			location.href = "/ForRentSystem/back/editCompleteBanner";
		}

		return false;
	}

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}

	// 編集ボタンクリック
	$("#editBannerBtn").click(function() {
		 var result = confirm("バナー情報を更新します。よろしいですか");
		 if (result == true) {
			 if($('#uploadFile').val() == "") {
				 $("#bannerForm").ajaxSubmit({
					 type: 'post',
					 dataType: 'json',
					 url: '/ForRentSystem/back/editBannerExecute',
					 success: successCallBack,
					 error: errorCallBack
				 });
			 } else {
				 $("#bannerForm").ajaxSubmit({
					 type: 'post',
					 dataType: 'json',
					 url: '/ForRentSystem/back/editBannerAndImageExecute',
					 success: successCallBack,
					 error: errorCallBack
				 });
			 }
		 }
	});
});
