<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>대출내역</title>
</head>


<body>
	<table width="800" border="0" cellspacing="0" cellpadding="2">
		<tr align="center">
			<th>도서번호</th>
			<th>도서명</th>
			<th>대여자</th>
			<th>대여일</th>
			<th>반납예정일</th>
		</tr>
		
        
		<s:iterator value="list" status="stat">
			<s:url id="viewURL" action="bookView">
				<s:param name="b_no">
					<s:property value="b_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
	
		<tr align="center">
			<td><s:property value="b_no" /></td>
			<td align="left">&nbsp;<s:a href="%{viewURL}">
				<s:property value="b_name" />
				</s:a></td>
			<td align="center"><s:property value="b_rentid" /></td>
			<td align="center"><s:property value="b_outdate" /></td>
			<td align="center"><s:property value="b_indate" /></td>
			<td>
			<form action="myRentReturnAction.action">
			<s:hidden name="b_no" value="${b_no}" />
			<input type="submit" value="대출반납" />
			</form>
			</td>
		</tr>
		</s:iterator>
		
		<s:if test="${b_no == null }"></s:if>
		<s:if test="list.size() <= 0">
		<td colspan="5" align="center"> <h3>대출내역이 존재하지 않습니다.</td>
		</s:if>
		
	</table>

</body>
</html>