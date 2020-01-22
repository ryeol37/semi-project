<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	
<link rel="stylesheet" type="text/css" href="style.css" media="all" />	
 <script>
function idCheck() {
      
       var a = document.getElementsById("okok")
       
       if (a == null) {
         alert("로그인을 해주세요.");
         return false;
      }
    }

function show_alert() {
	alert("추천하였습니다!");
}
</script>
</head>
  
  <body>
  
  	<table class="type07" width="600" border="1" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th colspan="2" scope="cols">자유게시판</th>
    </tr>
    </thead>
    
	<tbody>
    <tr>
        <th scope="row">번호</th>
        <td><s:property value="resultClass.fb_no" /></td>
    </tr>	
     
      
     <tr>
        <th scope="row">제목</th>
        <td><s:property value="resultClass.fb_subject" /></td>
    </tr>	
      
    <tr>
        <th scope="row">글쓴이</th>
        <td><s:property value="resultClass.m_id" /></td>
    </tr>
    
    <tr>
        <th scope="row">조회수</th>
        <td><s:property value="resultClass.fb_readhit" /></td>
    </tr>
      
    <tr>
        <th scope="row">작성일</th>
        <td><s:property value="resultClass.fb_regdate" /></td>
    </tr>
    
    <tr>
        <th scope="row">내용</th>
        <td><s:property value="resultClass.fb_content" /></td>
    </tr>
    
     
      </tbody>
      </table>
        	
      
      <tr>
        <td align="right" colspan="2">
        
	        <s:url id="fmodifyURL" action="fboardModifyForm" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
					
	        <s:url id="fdeleteURL" action="fboardDelete" >
				<s:param name="no">
					<s:property value="no" />
				</s:param>
	        </s:url>
        <s:if test="${ session_isadmin == 1 }">
		
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='fboardModify.action?fb_no='+
		'<s:property value="resultClass.fb_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='fboardDelete.action?fb_no='+
		'<s:property value="resultClass.fb_no" />'"/>

       </s:if>	
    <s:elseif test="${ boo }">				
	<input name="list" type="button" value="수정" class="inputb" 
		onClick="javascript:location.href='fboardModify.action?fb_no='+
		'<s:property value="resultClass.fb_no" />'"/>
		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='fboardDelete.action?fb_no='+
		'<s:property value="resultClass.fb_no" />'"/>
    </s:elseif>
	<input name="list" type="button" value="목록" class="inputb"
		onClick="javascript:location.href='fboardList.action?currentPage='+
		'&fb_no=<s:property value="currentPage" />'"/>
		
     <%-- <input name="list" type="button" value="추천" class="inputb"
		onClick="javascript:location.href='fboardList.action?fb_like='+
		'&fb_no=<s:property value="currentPage" />'"/> --%>
		
		      <input name="list" type="button" value="추천" class="inputb" 
		onClick="javascript:location.href='fboardLikeAction.action?fb_like='+
		'<s:property value="resultClass.fb_like" />&fb_no=<s:property value="fb_no" />'"/>
		<s:property value="resultClass.fb_like"/>
		
<%-- 		<form id="fboardLikeForm" method="post" enctype="multipart/form-data" action="fboardLikeAction.action">
		<button type="button" title="추천" onClick="location.href='fboardLikeAction.action?fb_no=<s:property value="fb_no"/>'">좋아요</button>
        <s:property value="resultClass.fb_like"/>
		</form> --%>
		
        </td>
      </tr>
      
      <div>
		<table class="type08" >
			<thead>
				<tr>
				<td></td>
				
					<th>작성자</th><th>내용</th>
					<th colspan="3">작성일</th>
					<td></td>
				</tr>
			</thead>
			<s:iterator value="commentlist" status="stat">
			
				<tbody>
				
					<tr><td  width="300"></td>
						<td width="80" height="5" align="center"><b>${m_id} 님</b>&nbsp;&nbsp;
							</td>
						<td width="400" align="center" rowspan="2" "><s:property value="c_content" /></td>
						<td width=70><s:property value="c_regdate" /></td>
						<td width="20" rowspan="2"><s:if test="${session_id} == ${m_id}"></td> 
						<td><input name="list" type="button" value="삭제" class="inputb"
							onClick="javascript:location.href='commentDelete.action?c_no='+
         '<s:property value="c_no" />&fb_no=<s:property value="fb_no" />'"></td>
					</tr></s:if> 
				
				</tbody>
			</s:iterator>
			
		</table>

		<form name="comWrite" action="commentWrite.action" method="post">
			<table >
			<tr height="30"/>
			<td class="ppo"></td>
				<tr>
				<td width="300"></td>
					<td  rowspan="2"><s:hidden name="m_id"
							value="${session_id}" /> <br/><br/><br/>${session_id} 님<br> 
</td>
					<td><s:hidden name="c_no" value="%{resultClass.fb_no}" />
						<s:hidden name="fb_no" value="%{resultClass.fb_no}" /> <s:textarea
							name="c_content" cols="80" rows="3" /></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><s:if test="${ session_id != null }"><input name="submit"
						type="submit" value="작성완료" onclick="return idCheck();" /></td></s:if>
				</tr>
			</table>
	</div>
	</form>

  </table>
  
 </body>
</html>