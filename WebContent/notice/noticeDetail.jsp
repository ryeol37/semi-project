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
  
  	<!-- <table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  			<td align="center"><h2>공지사항</h2></td>
  		</tr>
  		<tr>
  			<td height="20"></td>
  		</tr>
  	</thead> -->
	
	<div>
	
	 <table class="type07" width="600" border="1" cellspacing="0" cellpadding="0">
	 <thead>
	 <tr>
	     <th colspan="2" scope="cols">공지사항</th>
	 </tr>
	 </thead>
	 
     <tbody>
      <tr>
         <th scope="row">번호</th>
         <td><s:property value="resultClass.n_no"/></td>
      </tr>
      
      <tr>
         <th scope="row">제목</th>
         <td><s:property value="resultClass.n_subject"/></td>
      </tr>
      
      <tr>
         <th scope="row">조회수</td>
         <td><s:property value="resultClass.n_readhit"/></td>
      </tr>
      
      <tr>
         <th scope="row">작성일</td>
         <td><s:property value="resultClass.n_regdate"/></td>
      </tr>
      
       <tr>
         <th scope="row">내용</td>
         <td><s:property value="resultClass.n_content"/></td>
      </tr>
      </tbody></table>
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
		'&n_no<s:property value="currentPage" />'"/>

        </td>
      </tr>

  </table>
 </body>
</html>