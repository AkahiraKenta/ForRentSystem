// ページ番号取得
function getPage(labelElement) {
	var pageNumber;
	if ($(labelElement).attr("id") == "prev") {
		pageNumber = parseInt(getCurrentPage()) -1;
	} else if ($(labelElement).attr("id") == "next") {
		pageNumber = parseInt(getCurrentPage()) + 1;
	} else {
		pageNumber = $(labelElement).attr("id").split("_")[1];
	}
	return pageNumber;
}

// 全件数取得
function getTotalNumber() {
	return $("#totalNumber").val();
}

// 現在のページ取得
function getCurrentPage() {
	return $("#currentPage").val();
}

// 表示件数取得
function getViewNumber() {
	return $("#viewNumber").val();
}

// 全ページ数取得
function geLastPageNumber() {
	return $("#pageTotalNumber").val();
}

// ページングURLにGET情報を埋め込む
function setHref(href) {
	var addHref = '?totalNumber=' + getTotalNumber() + '&viewNumber=' + getViewNumber()
		+ '&pageTotalNumber=' + geLastPageNumber();

	 $(".callPager").each(function(){
		 // 対象ページ番号取得
		 var pageNumber = getPage($(this).children("span"));
		 if ($(this).children("span").attr("id") == "prev" && pageNumber == 0) {
		 	$(this).removeAttr("href");
		 	$(this).css("color", "#000000");
		 	$(this).css("text-decoration", "none");
		 } else if ($(this).children("span").attr("id") == "next"
			 	&& pageNumber > geLastPageNumber()) {
			 $(this).removeAttr("href");
			 $(this).css("color", "#000000");
			 $(this).css("text-decoration", "none");
		 } else {
			// 遷移先
			 var resultHref = href + addHref + '&pageNumber=' + pageNumber;

			 $(this).attr('href', resultHref);
		 }
	 });
}