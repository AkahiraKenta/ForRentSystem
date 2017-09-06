// *** admin/js/main.js ***

$(function(){

	//menuのactive設定
	//--------------------------------------------------
	$(".sidebar-nav a, .sidebar-nav li").removeClass('active');
	var currentMenuA = $("#menu-" + activeMenuId + " a");
	currentMenuA.addClass('active');
	//console.log('activeMenuId = %o', activeMenuId);
	if(currentMenuA.parent("li").parent("ul").hasClass('nav-second-level')){
		currentMenuA.parent("li").parent("ul").addClass('in');
		//console.log('hasClass! ');
	}else{
		//console.log('not hasclass!');
	}

	//flashMessageの削除
	//--------------------------------------------------
	setTimeout(function(){
		$("#flashMessage").fadeOut("slow");
	},1200);


	//DataTable全体設定
	//--------------------------------------------------
	var languageSetting = {
        "emptyTable":     "データはありません。",
        "info":           "_START_件～_END_件を表示（全_TOTAL_ 件中）",
        "infoEmpty":      " 0 件中 0 から 0 まで表示",
        "infoFiltered":   "（全 _MAX_ 件より抽出）",
        "infoPostFix":    "",
        "thousands":      ",",
        "lengthMenu":     "表示行数 _MENU_ 件",
        "loadingRecords": "読み込み中です...",
        "processing":     "処理中です...",
        "search":         "検索: ",
        "zeroRecords":    "該当するデータがありません",
        "paginate": {
            "first":      "先頭",
            "last":       "最終",
            "next":       "次ページ",
            "previous":   "前ページ"
        }
    };
	$("[id^='dataTable-']").DataTable({
		"language":languageSetting,
        //"lengthMenu": [[25, 50, 100, -1], [25, 50, 100, "すべて表示"]],
        //"order": [],
        stateSave: true
	});
	//メインデータ一覧テーブル設定
    $("#dataTable-MainDataList").DataTable({
        destroy: true,
        "language":languageSetting,
        "columnDefs": [
            { "orderable": false, "targets": 4 }
        ]
    });


	//画像アップロードモーダル処理
	//--------------------------------------------------
    $('.uploadModalBtn').click(function(){
        var imageNum = $(this).data("imgnum");
        var imageName = 'img' + imageNum;
        console.log("imageName = %o", imageName);
        //モーダル内の値書き換え
        $("#imageNameInput").val(imageName);
        $("#UploadModal .panel-title > span").text("画像" + imageNum + "に");
        $("#upload-image").attr('name', imageName);

        $('#UploadModal').modal();
    });

	//画像アップロードモーダル内
	//--------------------------------------------------
	$("#upload-image").change(function(){
		console.log("Changed! upload-image");
		$(".uploadImageBtn").removeClass('disabled');
	});

	//二重投稿防止
	//--------------------------------------------------
	$('form').on('submit', function () {
		$(this).find('.notDoubleClick').attr('disabled', 'disabled');
	});



	//tooltip
	//--------------------------------------------------
	$("[title]").tooltip();

	// ログアウト
	$("#logout").click(function() {
		// 確認メッセージ
		if(confirm('本当にログアウトしますか？')) {
			location.href = "/ForRentSystem/back/logout";
			return false;
		}
		return false;
	});
});

function onSubmit(url, element) {
	location.href = url;
	$(element).attr("disabled", "disabled");
	return false;
};
