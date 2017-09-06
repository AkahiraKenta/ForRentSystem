
$(function(){
	var selectProcessStatus = $("#selectProcessStatus").children("option");

	for (var i=0; i < selectProcessStatus.length; i++) {
		if ($("#processStatus").val() == selectProcessStatus[i].value) {
			selectProcessStatus[i].selected  = true;
		}
	}

	$("#updateProcessStatus").click(function() {
		var result = confirm("処理ステータスを更新します。よろしいですか");
		if (result == true) {
			document.location.href="/ForRentSystem/callUpdateContact?contactId="
				+ $("#contactId").val()
				+ "&processStatus="
				+ $("#selectProcessStatus option:selected").val();
		}
	})
});