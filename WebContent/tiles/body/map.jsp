<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>찰리와 책공장 오시는 길</title>
</head>
<body>

<table class="contact" cellpadding="0" cellspacing="0">
				<tr>
					<th>주소</th>
					<td>서울특별시 강남구 역삼동 33-33 삼삼빌딩 3층 I반(T : 02-1588-5588)</td>
				</tr>
				<tr>
					<th>버스</th>
					<td class="bus">
						역삼역.포스코P&amp;S타워 정류장<br>
						<img src="style/image/sub01/sub01_06_busB.jpg" alt="지선"> 146 / 740 / 341 / 360 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="style/image/sub01/sub01_06_busR.jpg" alt="간선"> 1100 / 1700 / 2000 / 7007 / 8001
					</td>
				</tr>
				<tr>
					<th>지하철</th>
					<td>지하철 2호선 역삼역 3번출구 100m</td>
				</tr>
				<tr><td colspan="2" class="contact_map"><div id="gangnam_map"></div></td></tr>
			</table>
			<table class="contact" cellpadding="0" cellspacing="0">
</table>



<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a27e6b20453dc4e28c825b673ea8e57"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(37.49901442259218, 127.03285217285156),
	
			level: 3
		};
		var map = new daum.maps.Map(container, options);
		
		// 마커를 표시할 위치입니다 
		var position =  new daum.maps.LatLng(37.49901442259218, 127.03285217285156);

		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
		  position: position,
		  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
		});

		// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
		// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
		// marker.setClickable(true);

		// 마커를 지도에 표시합니다.
		marker.setMap(map);

		// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div style="padding:5px;">CHARLIE & BOOK FACTORY</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		// 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
		    content : iwContent,
		    removable : iwRemoveable
		});

		// 마커에 클릭이벤트를 등록합니다
		daum.maps.event.addListener(marker, 'click', function() {
		      // 마커 위에 인포윈도우를 표시합니다
		      infowindow.open(map, marker);  
		});
	</script>
</body>
</html>