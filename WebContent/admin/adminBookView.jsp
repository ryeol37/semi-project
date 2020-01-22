<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<SCRIPT type="text/javascript">
	function idCheck() {
		var form = document.comWrite;
		if (!form.m_id.value) {
			alert("�α��� ���ּ���.");
			return false;
		}
	}

	function myBookPage() {
		if (document.getElementById("ID").value == "") {
			alert("���̵� �Է��ϼ���");
			loginForm.m_id.focus();
			return true;
		}
	}
	function btnClick() {
		alert("����");
	}

</script>

<link rel="stylesheet" type="text/css" href="style.css" media="all" />

</head>



<body>


	<table border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="left"><h2>���� �󼼺���</h2></td>
			<td align="right" />
			<td align="right"></td>
			<td align="right"><s:if test="${ session_isadmin == 1 }">
					<input name="list" type="button" value="����" class="inputb"
						onClick="javascript:location.href='adminBookModify.action?b_no='+
         '<s:property value="resultClass.b_no" />'" />

					<input name="list" type="button" value="����" class="inputb"
						onClick="javascript:location.href='adminBookDelete.action?b_no='+
         '<s:property value="resultClass.b_no" />'" />
				</s:if> <input name="list" type="button" value="�������" class="inputb"
				onClick="javascript:location.href='bookSearch.action?searchNum=0&searchKeyword='+
         '<s:property value="currentPage" />'" />
         
	         		<input name="list" type="button" value="������õ" class="inputb" 
		onClick="javascript:location.href='bookLike.action?b_like='+
		'<s:property value="resultClass.b_like" />&b_no=<s:property value="b_no" />'"/>
		</tr>
	</table>

	<table border="0" cellspacing="1">


		<tr>
			<td rowspan="4" align="center"><img
				src="./style/image/book/${ resultClass.b_img }" width="297"
				height="420" alt="�̹����� �����ϴ�" /></td>
		</tr>
		<tr>
			<td>�� �������� : <s:property value="resultClass.b_name" /></td>
		</tr>
		<tr>
			<td>�� ���� : <s:property value="resultClass.b_writer" /></td>
		</tr>
		<tr>
			<td>�� ���ǻ� : <s:property value="resultClass.b_pub" /></td>
		</tr>
		<tr>
			<td>�� ����� : <s:property value="resultClass.b_pubdate" /></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="left"><h3>��������</h3></td>
		</tr>
	</table>



	<table border="0" cellspacing="1">
		<tr>
		
			<td align="center">�ڷ����</td>
			<td align="center">�ݳ������� : </td>
			<tr>
				<form action="bookRentAction.action">
					<s:hidden name="b_no" value="${b_no}" />
					<s:if test="${resultClass.b_rentid == null}">
						<td align="center"><input type="submit" value="���� ����"></input></td>
					</s:if>
					<s:else>
						<td align="center"><input type="submit" value="���� �Ұ�" disabled></input></td>
					</s:else>

				</form>
				<td align="center"><s:date name="resultClass.b_indate"
						format="yyyy-MM-dd" /></td>
			</tr>
	</table>

	<div class="content">
		<pre>
���� �Ⱓ�� ��������� ���� 14�� �Դϴ�.
</pre>
	</div>

	<div class="content">
		<table border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td align="left"><h3>��������</h3></td>
			</tr>
		</table>

		<table border="0" cellspacing="1">
			<tr>
				<td width="100" height="50">�� ���� �Ұ� :</td>
				<td><s:property value="resultClass.b_intro" /></td>
			</tr>
			<tr>
				<td width="100" height="50">�� ���� ���� :</td>
				<td><s:property value="resultClass.b_list" /></td>
			</tr>

		</table>
	</div>

</body>
</html>