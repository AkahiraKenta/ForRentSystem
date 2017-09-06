$(function(){
	// すべての駅を選択押下時に、対象エリアに対して、check入れる/外す処理
	$("[name=checkAllStation]").click(function() {
		var targetElement = $(this).parents(".search_area_name").next(".search_area_name2").children("[name=selectedStationId]");
		if($(this).prop("checked")) {
			$(targetElement).prop("checked", true);
		} else {
			$(targetElement).prop("checked", false);
		}
	})
});
