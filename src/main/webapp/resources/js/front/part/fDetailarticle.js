$(function(){
	// すでにonloadがある場合でも気にせずgoogle mapを追加できます。
	google.maps.event.addDomListener(window, 'load', mapCreate($("#latitude").val(), $("#longitude").val()));

	var buildingId = $("#buildingId").val();
	var roomId = $("#roomId").val();
	var roomImageList = $("[name=currentImg_roomImagePhoto");

	// 画像初期処理
	if($("#buildingFileName_photo").val() != "") {
		// 建物画像が存在した場合、建物画像表示状態にする
		$("#imageViewBuildingPhoto_" + buildingId).css("display", "");
		$("#buildingCaption").css("display", "");
	} else {
		// 部屋画像が存在するか確認
		if (roomImageList != null) {
			for (var i=0; i < roomImageList.size(); i++) {
				if ($(this).next("input").val() != "") {
					$("#imageView_" + buildingId + "_" + roomId).css("display", "");
					$("#roomCaption_" + roomId).css("display", "");
					break;
				}
			}
		} else {
			// 建物画像も部屋画像も存在しない場合は、建物画像(空)を表示させる
			$("#imageViewBuildingPhoto_" + buildingId).css("display", "");
			$("#buildingCaption").css("display", "");
		}

	}

	// 建物画像クリック処理
	$("#imageViewBuildingSlider_" + buildingId).click(function() {
		$("#mainPhoto").children("pre").css("display", "none");
		$("#mainPhoto").children("p").css("display", "none");
		$("#imageViewBuildingPhoto_" + buildingId).css("display", "");
		$("#buildingCaption").css("display", "");
	});

	// 部屋画像クリック処理
	$("[name=currentImg_roomImageSlider]").click(function() {
		var fileName = $(this).next("input").val();
		var index = $(this).next("input").attr("id").split("_")[3];
		$("#mainPhoto").children("pre").css("display", "none");
		$("#mainPhoto").children("p").css("display", "none");
		$("#imageViewRoomPhoto_" + buildingId + "_" + roomId + "_" + index).css("display", "");
		$("#roomCaption_" + roomId + "_" + index).css("display", "");
	});
});
