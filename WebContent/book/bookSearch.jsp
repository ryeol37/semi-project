<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>�˻�</title>

<script>
function emulAcceptCharset(form){
	if (form.canHaveHTML){
		document.charset = form.acceptCharset;
	}	
}
</script>

<!-- <link rel="stylesheet" type="text/css" href="style.css" media="all" />	 -->
</head>
<body>

	<table align="center" width="600" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center"><h2></h2></td>
		</tr>
		<tr>
			<td height="20"></td>
		</tr>
			<tr align="center">
		<td height="100" colspan="5">	
			<form action="bookSearch.action" accept-charset="euc-kr" onsubmit="emulAcceptCharset(this)"  >
				<select name="searchNum" >
					<option value="0">��ü</option>
					<option value="1">������</option>
					<option value="2">����</option>
					<option value="3">���ǻ�</option>
				</select>
				<s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:300px" maxlength="50" />
				<input name="submit" type="submit" value="�˻�" class="inputb">
			</form>
		</td>
		</tr>
		<tr>
		<td height="70"></td>
		</tr>
	</table>

</body>
</html>