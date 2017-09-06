$(function(){
	// 「画像追加」リンク押下
	$('.imageFileUploadBtn').click(function(){
		if($("#detailBuildingForm") != undefined && $("[name=imageDelete]").val() != undefined) {
			// 建物詳細画面かつ、建物画像が登録されている場合
			alert("既に建物画像が登録されています。削除を行ってから、再度、建物画像を登録してください。")
			return false;
		} else {
			$('#imageFileUploadModal').modal();
		}
	});

	// 成功時関数
	function successCallBack(cdata) {
		if (!cdata.emptyFileCheckFlag) {
			alert("空ファイルが指定されました。ファイルを確認し、再度アップロードを行ってください。");
		} else if (!cdata.fileSizeCheckFlag){
			alert("アップロードする画像が500KBを超えています。画像サイズを調整して再度アップロードを行ってください。");
		} else if (!cdata.sameFileNameCheckFlag) {
			alert("アップロード済みの画像です。別の画像ファイルを指定してください。");
		} else {
			var imgId = "imageView_" + cdata.imageId;
			var btnId = "imageDelete_" + cdata.buildingId + "_" + cdata.imageId;
			$(".imgInput").append("<div id='imageDiv_" + cdata.imageId + "'>"
					+ cdata.imageCaption
					+ "<img id=\"" + imgId  +"\" class=\"imgView img-responsive\" style=\"width:130px; height:100px;\" src=\"" + cdata.filePath + cdata.buildingId + "/" + cdata.fileName + "\" >"
					+ "<button id=\"" + btnId + "\" name=\"imageDelete\" type=\"button\" style=\"margin-bottom:15px\" class=\"btn btn-danger btn-sm\">削除</button>"
					+ "</div>");
			// 入力値を削除
			$("#uploadFile").val("");
			$("#imageCaption").val("");
			// ダイアログを閉じて、メッセージを親画面に表示させるようにする
			$('#imageFileUploadModal').modal('hide');

			$("#message").prop("class","");
			$("#message").prop("class","text-center text-success");
			$("#message").text("建物画像追加しました。");
		}
		return false;
	}


	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		// 入力値を削除
		$("#uploadFile").val("");
		$("#imageCaption").val("");
		return false;
	}

	// アップロードボタンクリック
	$("#uploadButton").click(function() {
		$("#uploadForm").ajaxSubmit({
			type: 'post',
			dataType: 'json',
			url: '/ForRentSystem/back/uploadImageFile',
			success: successCallBack,
			error: errorCallBack
		});
	});

	function successImageDeleteCallBack(cdata) {
		$("#imageDiv_" + cdata.imageId).remove();

		$("#messageH3").prop("class","");
		$("#messageH3").prop("class","text-center text-danger");
		$("#message").text("建物画像削除しました。");

		return false;
	}

	// 画像削除
	$(".imgInput").on('click','button',function(){
		var result = confirm("削除します。よろしいですか");
		if (result == true) {
			// 要素IDを"_"で分割
			var splitId = $(this)[0].id.split('_');
			// 建物ID取得
			var buildingId = splitId[1];
			// 画像ID取得
			var imageId = splitId[2];
			// 対象画像SRCを"/"で分割
			var splitSrc = $(this)[0].previousElementSibling.src.split("/");
			// 画像ファイル名取得
			var fileName = splitSrc[splitSrc.length-1];
			var parameter = "buildingId=" + buildingId + "&imageId=" + imageId + "&fileName=" + fileName;
			$("#imageDeleteForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/deleteImageFile?' + parameter,
				success: successImageDeleteCallBack,
				error: errorCallBack
			});
		}
	});

	// 成功時関数
	function successRoomCallBack(cdata) {
		if (!cdata.emptyFileCheckFlag) {
			alert("空ファイルが指定されました。ファイルを確認し、再度アップロードを行ってください。");
		} else if (!cdata.fileSizeCheckFlag){
			alert("アップロードする画像が500KBを超えています。画像サイズを調整して再度アップロードを行ってください。");
		} else if (!cdata.sameFileNameCheckFlag) {
			alert("アップロード済みの画像です。別の画像ファイルを指定してください。");
		} else {
//			$("#imageView").prop("src", cdata.filePath + cdata.fileName);
			var imgId = "imageView_" + cdata.imageId;
			var btnId = "imageDelete_" + cdata.buildingId + "_" + cdata.roomId + "_" + cdata.imageId;

			$(".imgRoomInput").append("<div id='imageDiv_" + cdata.imageId + "'>"
					+ cdata.imageCaption
					+ "<img id=\"" + imgId  +"\" class=\"imgView img-responsive\" style=\"width:130px; height:100px;\" src=\"" + cdata.filePath + cdata.buildingId + "/" + cdata.roomId + "/" + cdata.fileName + "\" >"
					+ "<button id=\"" + btnId + "\" name=\"roomImageDelete\" type=\"button\" style=\"margin-bottom:15px\" class=\"btn btn-danger btn-sm\">削除</button>"
					+ "</div>");

			// 入力値を削除
			$("option").attr("selected",false);
			$("#uploadFile").val("");
			$("#imageCaption").val("");
			// ダイアログを閉じて、メッセージを親画面に表示させるようにする
			$('#imageFileUploadModal').modal('hide');

			$("#messageH3").prop("class","");
			$("#messageH3").prop("class","text-center text-success");
			$("#message").text("部屋画像追加しました。");
		}

		return false;
	}

	// 失敗時関数
	function errorRoomCallBack() {
		alert("失敗しました。再度、実行してください。");
		// 入力値を削除
		$("#uploadFile").val("");
		$("#imageCaption").val("");
		return false;
	}

	// アップロードボタンクリック
	$("#roomUploadButton").click(function() {
		$("#roomUploadForm").ajaxSubmit({
			type: 'post',
			dataType: 'json',
			url: '/ForRentSystem/back/uploadRoomsImageFile',
			success: successRoomCallBack,
			error: errorRoomCallBack
		});
	});
	// 画像削除
	$(".imgRoomInput").on('click','button',function(){
		var result = confirm("削除します。よろしいですか");
		if (result == true) {
			// 要素IDを"_"で分割
			var splitId = $(this)[0].id.split('_');
			// 建物ID取得
			var buildingId = splitId[1];
			// 部屋ID取得
			var roomId = splitId[2]
			// 画像ID取得
			var imageId = splitId[3];
			// 対象画像SRCを"/"で分割
			var splitSrc = $(this)[0].previousElementSibling.src.split("/");
			// 画像ファイル名取得
			var fileName = splitSrc[splitSrc.length-1];
			var parameter = "buildingId=" + buildingId + "&roomId=" + roomId + "&imageId=" + imageId + "&fileName=" + fileName;
			$("#imageRoomDeleteForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/deleteRoomImageFile?' + parameter,
				success: successRoomImageDeleteCallBack,
				error: errorCallBack
			});
		}
	});

	function successRoomImageDeleteCallBack(cdata) {
		$("#imageDiv_" + cdata.imageId).remove();

		$("#messageH3").prop("class","");
		$("#messageH3").prop("class","text-center text-danger");
		$("#message").text("部屋画像削除しました。");
		return false;
	}
});