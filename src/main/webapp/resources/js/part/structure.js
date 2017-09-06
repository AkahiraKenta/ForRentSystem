$(function(){

	// 成功時関数
	function successRegistCallBack(cdata) {
		$("#message").text("構造を追加しました。");
		$("#sortable").append("<tr id='listStructure_" + cdata.structureId + "'>"
								+ "<td>"
								+ "<input type='text' class='form-control' id='structureName_" + cdata.structureId + "' value='" + cdata.structureName + "'/>"
								+ "</td>"
								+ "<td>"
								+ "<button type='button' id='updateStructure_"+  cdata.structureId + "' name='updateStructure' class='btn btn-primary btn-sm'>更新</button>\n"
								+ "<button type='button' id='deleteStructure_"+  cdata.structureId + "' name='deleteStructure' class='btn btn-danger btn-sm'>削除</button>"
								+ "</tr>"
							)
		return false;
	}

	$("#addStructure").click(function() {
		var result = confirm("構造を追加します。よろしいですか");
		if (result == true) {
			$("#structureForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/registStructure',
				success: successRegistCallBack,
				error: errorCallBack
			});
		}
	});



	// 成功時関数
	function successUpdateCallBack(cdata) {
		$("#message").text("構造名称を更新しました。");
		return false;
	}

	// 更新処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/updateStructure/)) {
			var result = confirm("構造を更新します。よろしいですか");
			if (result == true) {
				$("#structureForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/updateStructure?structureId=' + $(this).attr("id").split("_")[1] + '&structureName=' + $(this).parents("tr").find("input")[0].value,
					success: successUpdateCallBack,
					error: errorCallBack
				});
			}
		}
	});


	// 成功時関数
	function successDeleteCallBack(cdata) {
		$("#message").text("構造を削除しました。");
		// 構造一覧から削除
		$("#listStructure_" + cdata).remove();
		return false;
	}


	// 削除処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/deleteStructure/)) {
			var result = confirm("構造を削除します。よろしいですか");
			if (result == true) {
				$("#structureForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/deleteStructure?structureId=' + $(this).attr("id").split("_")[1],
					success: successDeleteCallBack,
					error: errorCallBack
				});
			}
		}
	});

	// 失敗時関数
	function errorCallBack() {
		alert("失敗しました。再度、実行してください。");
		return false;
	}
});
