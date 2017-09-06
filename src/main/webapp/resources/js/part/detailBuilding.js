$(function(){
	$("#deleteBuilding").click(function() {
		var result = confirm("建物情報を削除します。よろしいですか。※建物情報に紐付く部屋情報も含めて削除されます。");
		if (result == true) {
			location.href = "/ForRentSystem/back/deleteBuilding?buildingId="+$("#buildingId").val();
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