jQuery(document).ready(function(){
   jQuery("#fContactArticleForm").validationEngine();

   $("#registConfirmContactArticleLink").click(function() {
	   if($("#errorMailAddress").text() != "") {
		   return false;
	   }

	   if(jQuery("#fContactArticleForm").validateSubmit($("#fContactArticleForm"))) {
		   document.fContactArticleForm.submit();
		   return false;
	   }
   });

   // 再確認用メールアドレスのエラーチェック
   $("#reconfirmation").blur(function() {
	   if ($(this).val() != $("#mailAddress").val()) {
		   $("#errorMailAddress").text("メールアドレスが再確認用と一致しません。")
	   } else {
		   $("#errorMailAddress").text("");
	   }
   });
});
