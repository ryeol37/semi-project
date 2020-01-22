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
  
  
  
   <table class="type07" width="600" border="1" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th colspan="2" scope="cols">도서신청</th>
    </tr>
    </thead>
  
  	<!-- <table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  			<td align="center"><h2>도서신청</h2></td>
  		</tr>
  		<tr>
  			<td height="20"></td>
  		</tr>
  	</table> -->
	

<!-- <table width="600" border="0" cellspacing="0" cellpadding="0">
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr> -->
	  
	  <tbody>
	  <tr>
	     <th scope="row">번호</th>
	     <td><s:property value="resultClass.nb_no"/></td>
	  </tr>
	  
	  <tr>
	     <th scope="row">제목</th>
	     <td><s:property value="resultClass.nb_subject"/></td>
	  </tr>
	  
	  <tr>
	      <th scope="row">글쓴이</th>
	      <td><s:property value="resultClass.m_id"/></td>
	  </tr>
	  
	  <tr>
	      <th scope="row">조회수</th>
	      <td><s:property value="resultClass.nb_readhit"/></td>
	  </tr>
	  
	  <tr>
	      <th scope="row">작성일</th>
	      <td><s:property value="resultClass.nb_regdate"/></td>
	  </tr>
	  
	  <tr>
	      <th scope="row">내용</th>
	      <td><s:property value="resultClass.nb_content"/></td>
	  </tr>
	  </tbody>
	  </table>
    
      
      <tr>
        <td align="right" colspan="2">
        
	        <s:url id="fmodifyURL" action="needbookModifyForm" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
					
	        <s:url id="fdeleteURL" action="needbookDelete" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
<s:if test="${ session_isadmin == 1 }">
		
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='needbookModify.action?nb_no='+
		'<s:property value="resultClass.nb_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='needbookDelete.action?nb_no='+
		'<s:property value="resultClass.nb_no" />'"/>

</s:if>	
<s:elseif test="${ boo }">				
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='needbookModify.action?nb_no='+
		'<s:property value="resultClass.nb_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='needbookDelete.action?nb_no='+
		'<s:property value="resultClass.nb_no" />'"/>
</s:elseif>
	<input name="list" type="button" value="목록" class="inputb"
		onClick="javascript:location.href='needbookList.action?currentPage='+
		'<s:property value="currentPage" />'"/>

        </td>
      </tr>

  </table>
 </body>
</html>