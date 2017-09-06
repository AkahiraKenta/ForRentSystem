jQuery(document).ready(function(){
	jQuery("#fContactForm").validationEngine();


   $("#registConfirmContactLink").on('click', function() {
	   if($("#errorMailAddress").text() != "") {
		   return false;
	   }

	   if($("#fContactForm").validateSubmit($("#fContactForm"))) {
		   // エラーなければ画面遷移
		   $("#fContactForm").submit();
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