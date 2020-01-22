<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<html>
<head>
<title>회원 정보</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<body>

  <table width="650" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center">
       <font size="+1" ><b>회원 정보</b></font></td>
    </tr>
    <tr>
      <td width="250" ><b>아이디 패스워드</b></td>
      <td width="400" > </td>
    </tr> 

    <tr>
      <td width="250"> 사용자 ID</td>
      <td width="400">

      ${ resultClass.m_id}
      </td>
    </tr>
    <tr>
      <td width="250"> 비밀번호</td>
      <td width="400" >
       ${ resultClass.m_pw}
      </td>
      </tr>
    <tr>
      <td width="250" ><b>개인정보</b></td>
      <td width="400" > </td>
    </tr> 
    <tr>
      <td width="250">사용자 이름</td>
      <td width="400">
        ${ resultClass.m_name}
      </td>
    </tr>
     <tr>
      <td width="250"> 사용자 생년월일</td>
      <td width="400">
        ${ resultClass.m_jumin1}
      </td>
    </tr>
    <tr>
      <td width="250">E-Mail</td>
      <td width="400">
        ${ resultClass.m_email}
      </td>
    </tr>
  
    <tr>
      <td width="250">휴대전화 번호</td>
      <td width="400">
        ${ resultClass.m_phone}
      </td>
    </tr>
    <tr>
<tr> 
       <td width="250">우편번호</td>
       <td> ${resultClass.m_zipcode}
          </tr>
    <tr> 
       <td>주소</td>
       <td>${resultClass.m_addr1}
    </tr>
    <tr> 
       <td>상세주소</td>
       <td>${resultClass.m_addr2}
    </tr>
    <tr>
      <td colspan="2" align="center" >
          		
	<input name="list" type="button" value="삭제" class="inputb" 
		onClick="javascript:location.href='adminMemberDeleteAction.action?m_id='+
		'<s:property value="resultClass.m_id" />'"/>&nbsp&nbsp&nbsp
          <input type="button" value="취소" onclick="javascript:location.href='adminMemberListForm.action'">
      </td>
    </tr>
  
  </table>

</body>
</html>