$(function(){
    //初期設定
    $("#carouselInner").css("width",139*$("#carouselInner ul.column li").size()+"px");
    $("#carouselInner ul.column").css("width",139*$("#carouselInner ul.column li").size()+"px");
    $("#carouselInner ul.column:last").prependTo("#carouselInner");
    $("#carouselInner").css("margin-left","0px")

    //初期表示時は、5個以上要素がある場合のみ、「進むボタン」活性
    if ($("#carouselInner ul.column li").size() > 5) {
    	$("#carouselNext").show();
    } else {
    	$("#carouselNext").hide();
    }
    // 戻るボタン非表示
    $("#carouselPrev").hide();

    //戻るボタン
    $("#carouselPrev").click(function(){
        $("#carouselNext,#carouselPrev").hide();
        $("#carouselInner").animate({
            marginLeft : parseInt($("#carouselInner").css("margin-left"))+139+"px"
        },"nomal","swing" ,
        function(){
        	if ( parseInt( $("#carouselInner").css("margin-left") ) == 0) {
        		// 初期に戻った場合は、「戻る」は、非表示
        		$("#carouselPrev").hide();
        		$("#carouselNext").show();
        	} else {
        		$("#carouselNext,#carouselPrev").show();
        	}

            $("#carouselInner ul.column:last").prependTo("#carouselInner");

        })
    })
    //進むボタン
    $("#carouselNext").click(function(){
        $("#carouselNext,#carouselPrev").hide();
        $("#carouselInner").animate({
            marginLeft : parseInt($("#carouselInner").css("margin-left"))-139+"px"
        },"nomal","swing" ,
        function(){
            $("#carouselInner ul.column:first").appendTo("#carouselInner");
            // 最後の要素か判定

            if ( ( ( $("#carouselInner ul.column li").size() - 5) * 139 * -1)  + "px" ==  $("#carouselInner").css("margin-left") ) {
            	$("#carouselNext").hide();
            } else {
            	$("#carouselNext").show();
            }

            $("#carouselPrev").show();
        })
    })

})