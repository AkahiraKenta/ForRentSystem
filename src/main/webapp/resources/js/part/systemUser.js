$(function(){
	$(".deleteSystemUser").click(function() {
		var result = confirm("システムユーザ情報を削除します。よろしいですか。");
		if (result == true) {
			location.href = "/ForRentSystem/back/callDeleteSystemUser?systemUserId="+$(this).parents().children("input").val();
		}
		return false;
	});

	// パスワード変更ダイアログ表示
	$('.editSystemUserPassword').click(function(){
		$("#message").text("");
		$('#selectModal').modal();
		$("#hiddenSystemUserId").val($(this).attr("id"));
	});

	$("#dialogEditSystemUserPassword").click(function() {
		// 入力値チェック
		if($("#systemUserNewPassword").val() != $("#systemUserNewPasswordConfirm").val()) {
			// 新しいパスワードの不一致
			// エラーメッセージ
			$("#errorMessage").text("新パスワードと、新パスワード(確認用)が一致しません。");
		} else {
			var result = confirm("パスワードを変更します。よろしいですか");
			if (result == true) {
				var systemUserId = $("#hiddenSystemUserId").val();
				$("#systemUserForm").ajaxSubmit({
					type: 'post',
					dataType: 'json',
					url: '/ForRentSystem/back/changePassword?systemUserId='+ $("#hiddenSystemUserId").val(),
					success: successGetCallBack,
					error: errorCallBack
				});
			}
		}
		return false;
	});

	var successGetCallBack = function(cdata) {
		if(cdata) {
			// パスワード更新完了
			$('#selectModal').modal('hide');
			$("#message").text("パスワードを更新しました。");

		} else {
			// falseの場合、現在のパスワードと入力したパスワードが不一致
			$("#errorMessage").text("登録されている現在のパスワードと、入力された現在のパスワードが一致しません。");
		}
		return false;
	};

	var errorCallBack = function(cdata) {
		alert("接続失敗。お手数ですが、再度ログインして再実行してください。");
	};
});
