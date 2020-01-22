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
  			<td align="center"><h2>FAQ</h2></td>
  		</tr>
  		<tr>
  			<td height="20"></td>
  		</tr>
  	</table>
	
	<div_>
    <table class="type07" width="600" border="1" cellspacing="0" cellpadding="0">
      <thead>
      
      <tr>
        <th colspan="2" scope="cols"><s:property value="resultClass.f_subject" /></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th class="no">글번호</th>
        <td class="no" align="center"><s:property value="resultClass.f_no" /></td>
    </tr>
    <tr>
        <td height="250" colspan="2" align="center"><s:property value="resultClass.f_content" /></td>
    </tr>
      </thead>
	</div>	
      
    <tr>
        <td align="right" colspan="2">
        
	        <s:url id="faqURL" action="faqModifyForm" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
					
	        <s:url id="faqURL" action="faqDelete" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url> 
<s:if test="${ session_isadmin == 1 }">
		
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='faqModify.action?f_no='+
		'<s:property value="resultClass.f_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='faqDelete.action?f_no='+
		'<s:property value="resultClass.f_no" />'"/>

</s:if>	
<s:elseif test="${ boo }">				
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='faqModify.action?f_no='+
		'<s:property value="resultClass.f_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='faqDelete.action?f_no='+
		'<s:property value="resultClass.f_no" />'"/>
</s:elseif> 

 	<input name="list" type="button" value="목록" class="inputb"
		onClick="javascript:location.href='faqList.action?currentPage='+
		'<s:property value="currentPage" />'"/>

        </td>
      </tr> 

  </table>
 </body>
</html>