<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<html>
<head>
<title>ȸ�� ����</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<body>

  <table width="650" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center">
       <font size="+1" ><b>ȸ�� ����</b></font></td>
    </tr>
    <tr>
      <td width="250" ><b>���̵� �н�����</b></td>
      <td width="400" > </td>
    </tr> 

    <tr>
      <td width="250"> ����� ID</td>
      <td width="400">

      ${ resultClass.m_id}
      </td>
    </tr>
    <tr>
      <td width="250"> ��й�ȣ</td>
      <td width="400" >
       ${ resultClass.m_pw}
      </td>
      </tr>
    <tr>
      <td width="250" ><b>��������</b></td>
      <td width="400" > </td>
    </tr> 
    <tr>
      <td width="250">����� �̸�</td>
      <td width="400">
        ${ resultClass.m_name}
      </td>
    </tr>
     <tr>
      <td width="250"> ����� �������</td>
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
      <td width="250">�޴���ȭ ��ȣ</td>
      <td width="400">
        ${ resultClass.m_phone}
      </td>
    </tr>
    <tr>
<tr> 
       <td width="250">�����ȣ</td>
       <td> ${resultClass.m_zipcode}
          </tr>
    <tr> 
       <td>�ּ�</td>
       <td>${resultClass.m_addr1}
    </tr>
    <tr> 
       <td>���ּ�</td>
       <td>${resultClass.m_addr2}
    </tr>
    <tr>
      <td colspan="2" align="center" >
          		
	<input name="list" type="button" value="����" class="inputb" 
		onClick="javascript:location.href='adminMemberDeleteAction.action?m_id='+
		'<s:property value="resultClass.m_id" />'"/>&nbsp&nbsp&nbsp
          <input type="button" value="���" onclick="javascript:location.href='adminMemberListForm.action'">
      </td>
    </tr>
  
  </table>

</body>
</html>