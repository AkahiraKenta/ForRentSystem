$(function(){
	// 人気エリアをクリック際に、画面遷移する処理
	$("[name=townArea]").click(function() {
		$("#selectedTownArea").val($(this).text().split("(")[0]);
		onSubmit('fSearchConditionForm', this);
		return false;
	})
});
