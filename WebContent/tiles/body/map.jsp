<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>������ å���� ���ô� ��</title>
</head>
<body>

<table class="contact" cellpadding="0" cellspacing="0">
				<tr>
					<th>�ּ�</th>
					<td>����Ư���� ������ ���ﵿ 33-33 ������ 3�� I��(T : 02-1588-5588)</td>
				</tr>
				<tr>
					<th>����</th>
					<td class="bus">
						���￪.������P&amp;SŸ�� ������<br>
						<img src="style/image/sub01/sub01_06_busB.jpg" alt="����"> 146 / 740 / 341 / 360 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="style/image/sub01/sub01_06_busR.jpg" alt="����"> 1100 / 1700 / 2000 / 7007 / 8001
					</td>
				</tr>
				<tr>
					<th>����ö</th>
					<td>����ö 2ȣ�� ���￪ 3���ⱸ 100m</td>
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
		
		// ��Ŀ�� ǥ���� ��ġ�Դϴ� 
		var position =  new daum.maps.LatLng(37.49901442259218, 127.03285217285156);

		// ��Ŀ�� �����մϴ�
		var marker = new daum.maps.Marker({
		  position: position,
		  clickable: true // ��Ŀ�� Ŭ������ �� ������ Ŭ�� �̺�Ʈ�� �߻����� �ʵ��� �����մϴ�
		});

		// �Ʒ� �ڵ�� ���� ��Ŀ�� �����ϴ� �ڵ忡�� clickable: true �� ����
		// ��Ŀ�� Ŭ������ �� ������ Ŭ�� �̺�Ʈ�� �߻����� �ʵ��� �����մϴ�
		// marker.setClickable(true);

		// ��Ŀ�� ������ ǥ���մϴ�.
		marker.setMap(map);

		// ��Ŀ�� Ŭ������ �� ��Ŀ ���� ǥ���� ���������츦 �����մϴ�
		var iwContent = '<div style="padding:5px;">CHARLIE & BOOK FACTORY</div>', // ���������쿡 ǥ��� �������� HTML ���ڿ��̳� document element�� �����մϴ�
		    iwRemoveable = true; // removeable �Ӽ��� ture �� �����ϸ� ���������츦 ���� �� �ִ� x��ư�� ǥ�õ˴ϴ�

		// ���������츦 �����մϴ�
		var infowindow = new daum.maps.InfoWindow({
		    content : iwContent,
		    removable : iwRemoveable
		});

		// ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
		daum.maps.event.addListener(marker, 'click', function() {
		      // ��Ŀ ���� ���������츦 ǥ���մϴ�
		      infowindow.open(map, marker);  
		});
	</script>
</body>
</html>