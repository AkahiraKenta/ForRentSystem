$(function(){
	 // すでにonloadがある場合でも気にせずgoogle mapを追加できます。
	 google.maps.event.addDomListener(window, 'load', mapCreate(35.6847794,139.7752288));
	/**
	 * 渡された緯度と経度を元に、googleMapとストリートビューを表示
	 */
	 function mapCreate(latitudeValue, longitudeValue){
		// ズーム
		var mapZoom = 16;
		// 地図の真ん中、アイコンの位置
		var mapCenter = new google.maps.LatLng(latitudeValue,longitudeValue);

		// マップ表示
		var map = new google.maps.Map(
			document.getElementById("gmap"),{
				zoom : mapZoom,
				center : mapCenter,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				streetViewControl : true
			}
		);

		// マーカー表示
		new google.maps.Marker({
			position:mapCenter,
			map:map,
			animation : google.maps.Animation.DROP	// アイコン動き
			// icon: "v.png"	// アイコン画像
		});
	}

	// 会社情報画面
	var url = $(location).attr('href');
	if (url.indexOf("?accsess=accsessSection") != -1) {
		var p = $("#accessSection").offset().top;
		$('html,body').animate({ scrollTop: p }, 'fast');
	}
});