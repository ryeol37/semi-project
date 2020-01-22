<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 리스트</title>
</head>
<body>
<br>


	<table align="center" width="600" border="1" cellspacing="0" cellpadding="2">
		<tr align="center" bgcolor="#F3F3F3">
			<td width="200"><strong>회원아이디</strong></td>
			<td width="150"><strong>회원이름</strong></td> 
			<td width="250"><strong>전화번호</strong></td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="3"></td>
		</tr>
<!-- -->
	<s:iterator value="list" status="stat">
			<s:url id="viewURL" action="adminMemberDetailForm">
				<s:param name="m_id">
					<s:property value="m_id" />
				</s:param>
			<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
			
		<tr bgcolor="white" align="center">
			<td align="center"><s:a href="%{viewURL}"><s:property value="m_id" /></s:a></td>
			<td align="left">&nbsp;<s:property value="m_name" /></td>
			<td align="center"><s:property value="m_phone" />
			</td>
		</tr>
		
		</s:iterator>
		
		<tr bgcolor="black">
			<td height="0" colspan="3"></td>
		</tr>

<!-- -->
		<s:if test="list.size() <= 0">

			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="3">등록된 회원이 없습니다.<s:property value="m_id" /></td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="3"></td>
			</tr>

		</s:if> 
		
		<tr align="center">
		<td colspan="3"><s:property value="pagingHtml"  escape="false"></s:property></td></tr>
	</table>
	<br>
</body>
</html>