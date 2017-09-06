$(function() {
	// DATE項目への処理
	// 2日本語を有効化
	$.datepicker.setDefaults($.datepicker.regional['ja']);
	// 3日付選択ボックスを生成
	$('#date').datepicker({ dateFormat: 'yy/mm/dd' });
	$( ".datepicker" ).datepicker({
		inline: false
	});

	// 初期表示処理
	// リンク有無フラグ名称に値を設定
	$("#linkUmuFlagName").val($("#linkUmuFlag")[0].options[$("#linkUmuFlag")[0].options.selectedIndex].text);
	// リンク区分名称に値を設定
	$("#linkClassName").val($("#linkClass")[0].options[$("#linkClass")[0].options.selectedIndex].text);

	function addDisabled() {
		// リンク区分名称の値を空に設定
		$("#linkClassName").val("");

		// リンク区分変更不可
		$("#linkClass").attr("disabled", "disabled");
		$("#linkClass").css( "background", "#eee" );
		// リンクURL変更不可
		$("#linkUrl").val("");
		$("#linkUrl").attr('readonly',true);
	}

	// リンク有無フラグの値分岐
	if ($("#linkUmuFlag").val() == 0) {
		// 無効の場合
		addDisabled();
	} else {
		// リンク区分名称の値を設定
		$("#linkClassName").val($("#linkClass")[0].options[$("#linkClass")[0].options.selectedIndex].text);
	}

	// リンク区分の値変更処理
	$("#linkClass").change(function() {
		// リンク区分名称の値を設定
		$("#linkClassName").val($("#linkClass")[0].options[$("#linkClass")[0].options.selectedIndex].text);
	});

	// リンク有無フラグ変更処理
	$("#linkUmuFlag").change(function(){
		// リンク有無フラグ名称の値を設定
		$("#linkUmuFlagName").val($("#linkUmuFlag")[0].options[$("#linkUmuFlag")[0].options.selectedIndex].text);
		if ($(this).val() == 0) {
			// 無効の場合
			addDisabled();
		} else {
			// リンク区分変更可
			$("#linkClass").removeAttr('disabled')
			$("#linkClass").css( "background", "#fff" );
			// リンクURL変更可
			$("#linkUrl").removeAttr('readonly')
			$("#linkClassName").val($("#linkClass")[0].options[$("#linkClass")[0].options.selectedIndex].text);
		}
	});
});
