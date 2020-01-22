<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	
<link rel="stylesheet" type="text/css" href="style.css" media="all" />	
	
</head>
  
  <body>
  
  	<table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  			<td align="center"><h2>공지사항</h2></td>
  		</tr>
  		<tr>
  			<td height="20"></td>
  		</tr>
  	</table>
	
	<div class="content">
<table width="600" border="0" cellspacing="0" cellpadding="0">
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
			
      <tr>
        <td bgcolor="#F4F4F4">  번호 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.n_no" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td width="100" bgcolor="#F4F4F4">  제목</td>
        <td width="500" bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="n_subject" />
        </td>
      </tr>
      							
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
          
      <tr>
        <td bgcolor="#F4F4F4">  내용 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.n_content" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  조회수 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.n_readcount" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  작성일 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.n_readhit" />
        </td>
      </tr>

      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>	
      </tr>
      
      <tr>
        <td height="10" colspan="2"></td>
      </tr>
	</div>	
      
      
      <tr>
        <td align="right" colspan="2">
        
	        <s:url id="noticeURL" action="noticeModifyForm" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
					
	        <s:url id="noticeURL" action="noticeDelete" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
<s:if test="${ session_isadmin == 1 }">
		
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='noticeModify.action?n_no='+
		'<s:property value="resultClass.n_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='noticeDelete.action?n_no='+
		'<s:property value="resultClass.n_no" />'"/>

</s:if>	
<s:elseif test="${ boo }">				
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='noticeModify.action?n_no='+
		'<s:property value="resultClass.n_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='noticeDelete.action?n_no='+
		'<s:property value="resultClass.n_no" />'"/>
</s:elseif>
	<input name="list" type="button" value="목록" class="inputb"
		onClick="javascript:location.href='noticeList.action?currentPage='+
		'<s:property value="currentPage" />'"/>

        </td>
      </tr>

  </table>
 </body>
</html>