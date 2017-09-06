$(function(){

	// 成功時関数
	function successRegistCallBack(cdata) {
		$("#message").text("こだわり条件を追加しました。");
		$("#sortable").append("<tr id='goodForCondition_" + cdata.conditionId + "' class='ui-sortable-handle'>"
								+ "<td class='rank'>"
								+ cdata.displayNumber
								+ "</td>"
								+ "<td>"
								+ "<input type='text' class='form-control' id='conditionName_" + cdata.conditionId + "' value='" + cdata.conditionName + "'/>"
								+ "</td>"
								+ "<td>"
								+ "<input type='hidden' id='conditionId_'" + cdata.conditionId + "' name='conditionId' value='" + cdata.conditionId + "'>"
								+ "<button type='button' id='updateGoodForCondition_"+  cdata.conditionId + "' name='updateGoodForCondition' class='btn btn-primary btn-sm'>更新</button>\n"
								+ "<button type='button' id='deleteGoodForCondition_"+  cdata.conditionId + "' name='deleteGoodForCondition' class='btn btn-danger btn-sm'>削除</button>"
								+ "</tr>"
							)
		return false;
	}

	// 追加処理
	$("#addGoodForCondition").click(function() {
		var result = confirm("こだわり条件を追加します。よろしいですか");
		if (result == true) {
			$("#goodForConditionForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/registGoodForCondition',
				success: successRegistCallBack,
				error: errorCallBack
			});
		}
	});



	// 成功時関数
	function successUpdateCallBack(cdata) {
		$("#message").text("こだわり条件名称を更新しました。");
		return false;
	}

	// 更新処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/updateGoodForCondition/)) {
			var result = confirm("こだわり条件を更新します。よろしいですか");
			if (result == true) {
				$("#goodForConditionForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/updateGoodForCondition?conditionId=' + $(this).attr("id").split("_")[1] + '&conditionName=' + $(this).parents("tr").find("input")[0].value,
					success: successUpdateCallBack,
					error: errorCallBack
				});
			}
		}
	});


	// 成功時関数
	function successDeleteCallBack(cdata) {
		$("#message").text("こだわり条件を削除しました。");
		// こだわり条件一覧から削除
		$("#goodForCondition_" + cdata).remove();
		numberingSortNo()
		return false;
	}


	// 削除処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/deleteGoodForCondition/)) {
			var result = confirm("こだわり条件を削除します。よろしいですか");
			if (result == true) {
				$("#goodForConditionForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/deleteGoodForCondition?conditionId=' + $(this).attr("id").split("_")[1],
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

	// 成功時関数
	function successUpdateDisplayNumberCallBack() {
		$("#message").text("こだわり条件の表示順を更新しました。");
		return false;
	}

	// 保存ボタンクリック
	$("#saveButton").on('click', 'button', function() {
//	$("#updateGoodForConditionDisplayNumber").click(function(){
		var result = confirm("表示順を更新します。よろしいですか");
		if (result == true) {
			$("#goodForConditionForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/updateGoodForConditionDisplayNumber',
				success: successUpdateDisplayNumberCallBack,
				error: errorCallBack
			});
		}
	});
});
