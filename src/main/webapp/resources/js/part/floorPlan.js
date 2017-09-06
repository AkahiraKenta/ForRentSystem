$(function(){

	// 成功時関数
	function successRegistCallBack(cdata) {
		$("#message").text("間取りを追加しました。");
		$("#sortable").append("<tr id='listFloorPlan_" + cdata.floorPlanId + "'>"
								+ "<td>"
								+ "<input type='text' class='form-control' id='floorPlanName_" + cdata.floorPlanId + "' value='" + cdata.floorPlanName + "'/>"
								+ "</td>"
								+ "<td>"
								+ "<button type='button' id='updateFloorPlan_"+  cdata.floorPlanId + "' name='updateFloorPlan' class='btn btn-primary btn-sm'>更新</button>\n"
								+ "<button type='button' id='deleteFloorPlan_"+  cdata.floorPlanId + "' name='deleteFloorPlan' class='btn btn-danger btn-sm'>削除</button>"
								+ "</tr>"
							)
		return false;
	}

	$("#addFloorPlan").click(function() {
		var result = confirm("間取りを追加します。よろしいですか");
		if (result == true) {
			$("#floorPlanForm").ajaxSubmit({
				type: 'post',
				dataType: 'json',
				url: '/ForRentSystem/back/registFloorPlan',
				success: successRegistCallBack,
				error: errorCallBack
			});
		}
	});



	// 成功時関数
	function successUpdateCallBack(cdata) {
		$("#message").text("間取り名称を更新しました。");
		return false;
	}

	// 更新処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/updateFloorPlan/)) {
			var result = confirm("間取りを更新します。よろしいですか");
			if (result == true) {
				$("#floorPlanForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/updateFloorPlan?floorPlanId=' + $(this).attr("id").split("_")[1] + '&floorPlanName=' + $(this).parents("tr").find("input")[0].value,
					success: successUpdateCallBack,
					error: errorCallBack
				});
			}
		}
	});


	// 成功時関数
	function successDeleteCallBack(cdata) {
		$("#message").text("間取りを削除しました。");
		// 間取り一覧から削除
		$("#listFloorPlan_" + cdata).remove();
		return false;
	}


	// 削除処理
	$("#sortable").on('click', 'button', function() {
		// 更新と削除が同列にあるため、ID比較を行い、どちらのボタンが押されたか判別してから処理を行う。
		if ($(this).attr("id").match(/deleteFloorPlan/)) {
			var result = confirm("間取りを削除します。よろしいですか");
			if (result == true) {
				$("#floorPlanForm").ajaxSubmit({
					type: 'get',
					dataType: 'json',
					url: '/ForRentSystem/back/deleteFloorPlan?floorPlanId=' + $(this).attr("id").split("_")[1],
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
