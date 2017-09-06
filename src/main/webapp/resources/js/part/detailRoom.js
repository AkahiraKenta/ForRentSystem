$(function(){
	$("#deleteRoom").click(function() {
		var result = confirm("部屋情報を削除します。よろしいですか。");
		if (result == true) {
			location.href = "/ForRentSystem/back/deleteRoom?buildingId="+$("#buildingId").val()+"&roomId="+$("#roomId").val();
		}
		return false;
	});
});

/**
 * ロード後実施し、GoogleMapを作成する。
 */
function googleMapSetUp() {
	draggableFlag = false;
	initialize();
}