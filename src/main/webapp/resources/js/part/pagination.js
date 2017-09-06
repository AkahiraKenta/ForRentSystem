/**
 * ページング用JS
 */

$(function() {
	// 一覧表示全要素取得
	var itemList = $('#target').children('tr');
	$("#demo_pag1").bs_pagination({
		currentPage: 1,
		totalPages: Math.ceil($(itemList).size() / 10),
		rowsPerPage: 10,
		onLoad: function() {

			// 画面初期表示処理
			// 現在の1ページに表示する件数を取得
			var displayCount = $('#rows_per_page_demo_pag1').val();

			$(itemList).each(function(i, item) {
				// 要素でループ
				if (i < displayCount) {
					// 表示対象は何も処理しない
					return true;
				}
				// 非表示対象にdisplay:noneを付与
				$(item).attr('style', 'display:none;');
			});

			// ページジャンプ項目,表示件数項目を削除
			$('.input-group').remove();
		},

		onChangePage: function(event, data) {
			// ページ変更時処理
			// 現在の1ページに表示する件数を取得
//			data.rowsPerPage;
			// 現在のページ
//			data.currentPage;
			// 表示する要素番号（先頭）
			var beginElementNumber = data.currentPage * data.rowsPerPage - data.rowsPerPage;
			// 表示する要素番号（最後）
			var endElementNumber = data.currentPage * data.rowsPerPage;

			$(itemList).each(function(i, item) {
				// 要素でループ
				if (i >= beginElementNumber && i < endElementNumber) {
					// 非表示対象にdisplay:noneを削除
					$(item).attr('style', '');
					return true;
				}
				// 非表示対象にdisplay:noneを付与
				$(item).attr('style', 'display:none;');
			});
		}
	});
});