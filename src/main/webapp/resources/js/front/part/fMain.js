$(function(){
	// 文字数が長すぎる部分を"..."表示させる処理
	$('.textOverflow1').each(function() {
	    var $target = $(this);

	    // オリジナルの文章を取得する
	    var html = $target.html();
	    // 空白文字削除
	    html = html.replace(/\s+/g, "");

	    // 対象の要素を、高さにautoを指定し非表示で複製する
	    var $clone = $target.clone();
	    $clone
	      .css({
	        display: 'none',
	        position : 'absolute',
	        overflow : 'visible'
	      })
	      .width($target.width())
	      .height('auto');

	    // DOMを一旦追加
	    $target.after($clone);

	    // 指定した高さになるまで、1文字ずつ消去していく
	    while((html.length > 0) && ($clone.height() > $target.height())) {
	    	if (html.match(/^(\w| |'|,|&)+$/)) {
	    		html = html.substr(0, html.length - 4);
	    	} else {
	    		html = html.substr(0, html.length - 2);
	    	}

	    	$clone.html(html + '...');
	    }

	    // 半角文字かつ20文字の場合、枠内に収まりきらないため、4文字削除する。
	    if (html.match(/^(\w| |'|,|&)+$/) && html.length == 20) {
	    	html = html.substr(0, html.length - 4);
	    	$clone.html(html + '...');
	    }

	    // 文章を入れ替えて、複製した要素を削除する
	    $target.html($clone.html());
	    $clone.remove();
	});

	// アクセスメニュー押下時
	$("[name=accessMenu]").click(function() {
		window.location.href = './companyInfo?accsess=accsessSection';
		return false;
	})
});

function onSubmit(form, element) {
	if ($(element).hasClass('double_click') ){
		alert("連続クリックは禁止しております。");
		$(element).removeClass('double_click');
		return false;
    }
	document.getElementById(form).submit();
	$(element).addClass('double_click');
	return false;
};

function onHref(url, element) {
	if ($(element).hasClass('double_click') ){
		alert("連続クリックは禁止しております。");
		$(element).removeClass('double_click');
		return false;
    }
	location.href = url;
	$(element).addClass('double_click');
	return false;
};
