$('#sortable').sortable();
$('#sortable').disableSelection();
$('#sortable').sortable({helper: helper1, cursor: "move", opacity: 0.5});
function helper1(e, tr) {
	var $originals = tr.children();
	var $helper = tr.clone();
	$helper.children().each(function(index) {
		$(this).width($originals.eq(index).width());
	});
	return $helper;
}

$('#sortable').bind('sortstop', function (e, ui) {
    // ソートが完了したら実行される。
	numberingSortNo();
})

function numberingSortNo() {
	var rows = $('#sortable .rank');
    for (var i = 0, rowTotal = rows.length; i < rowTotal; i += 1) {
        $($('.rank')[i]).text(i + 1);
    }
}
