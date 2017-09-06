$(document).ready(function(){

    // 地図に反映ボタンのイベント登録
    // 画面によってボタンがない場合はあるので、要素が存在する場合のみ実施
    if ($("#googleMapUpdateButton").size()) {
    	$("#googleMapUpdateButton").click(function() {
        	// 住所から、緯度・経度を取得し、地図位置を更新する。
        	getGeoCode();
        });
    }

 });

// ドラッグ可能・不可能のフラグ
var draggableFlag;

/**
 * GoogleMap表示処理
 * ※ページ読み込み完了時に実行する関数
 */
 function initialize() {

	 if ($("#latitude").val() == "") {
		 $("#latitude").val(35.681382);
   		 $("#longitude").val(139.766084);
   		 $("#latitudeView").val(35.681382);
   		 $("#longitudeView").val(139.766084);
	 } else {
		 $("#latitudeView").val($("#latitude").val());
   		 $("#longitudeView").val($("#longitude").val());
	 }
     // 初期位置
     var initialPlace = new google.maps.LatLng($("#latitude").val(), $("#longitude").val());

     // マップ表示
     var gMap = new google.maps.Map(document.getElementById("map"), {
         center: new google.maps.LatLng($("#latitude").val(), $("#longitude").val()),
         rotateControl: false,
         streetViewControl: false,
         panControl: false,
         mapTypeControl: false,
         zoom:18,
         mapTypeId: google.maps.MapTypeId.ROADMAP
     });

     // ドラッグできるマーカーを表示
     var marker = new google.maps.Marker({
         position: new google.maps.LatLng($("#latitude").val(), $("#longitude").val()),
         title: "",
         draggable: draggableFlag
     });
     marker.setMap(gMap)    ;

     // マーカーのドロップ（ドラッグ終了drag end)時のイベント
     google.maps.event.addListener( marker, 'dragend', function(ev){
         $("#latitude").val(ev.latLng.lat());
         $("#longitude").val(ev.latLng.lng());
         $("#latitudeView").val(ev.latLng.lat());
         $("#longitudeView").val(ev.latLng.lng());
     });
 }

/**
 * 郵便番号変更時にGoogleMapのピンの位置を同期させる処理
 */
 function getGeoCode() {
	var geocoder = new google.maps.Geocoder();

	var selectedProvinveVal = $('#province').val();

	if ($('#province').val() == "") {

		return false;
	}

	var selectedCityVal = $("#city")[0].options[$("#city").val()].text;
	var selectedTownArea = $("#townArea")[0].options[$("#townArea").val()].text;
	var selectedTownAreaBelow = $('#townAreaBelow').val();

	var addressStr = selectedProvinveVal + selectedCityVal + selectedTownArea + selectedTownAreaBelow;
	geocoder.geocode(
		{ address: addressStr },
		function( results, status ) {
			if( status == google.maps.GeocoderStatus.OK ) {
				//alert(results[0].geometry.location.lat());
				//alert(results[0].geometry.location.lng());
				$("#latitude").val(results[0].geometry.location.lat());
				$("#longitude").val(results[0].geometry.location.lng());
				initialize();
			}
			else {
				alert( '入力した住所に該当するエリアがありませんでした。：' + status );
			}
		}
	);
}

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
	// ストリートビュー表示
	var svp = new google.maps.StreetViewPanorama(
		document.getElementById("stv"), {
			position : mapCenter
		});
	map.setStreetView(svp);

	// マーカー表示
	new google.maps.Marker({
		position:mapCenter,
		map:map,
		animation : google.maps.Animation.DROP	// アイコン動き
		// icon: "v.png"	// アイコン画像
	});
}
