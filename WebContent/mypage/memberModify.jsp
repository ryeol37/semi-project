<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<html>
<head>
<title>ȸ�� ���� ����</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript">

	
   
    function checkIt() {
        var userinput = eval("document.userinput");
        if(!userinput.m_id.value) {
            alert("ID�� �Է��ϼ���");
            return false;
        }
       
        if(!userinput.m_pw.value ) {
            alert("��й�ȣ�� �Է��ϼ���");
            return false;
        }
        if(userinput.m_pw.value != userinput.m_pwr.value)
        {
            alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
            return false;
        }
      
        if(!userinput.m_name.value) {
            alert("����� �̸��� �Է��ϼ���");
            return false;
        }
       /*  if(!member_birth.value)
        {
            alert("��������� �Է��Ͻÿ�");
            return false;
        } */
    }
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function zipCheck() {
        new daum.Postcode({
            oncomplete: function(data) {
                var fullAddr = '';
                var extraAddr = '';


                if (data.userSelectedType === 'R') {
                    fullAddr = data.roadAddress;

                } else {
                    fullAddr = data.jibunAddress;
                }

                
                if(data.userSelectedType === 'R'){
                   
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                   
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

        
                document.getElementById('m_zipcode').value = data.zonecode; 
                document.getElementById('m_addr1').value = fullAddr;


                document.getElementById('m_addr2').focus();
            }
        }).open();
    }
</script> 

<body>

<form action ="memberModifyAction.action" method="post"  name="userinput" onSubmit="return checkIt()">
  <table width="650" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center">
       <font size="+1" ><b>ȸ�� ���� ���� ${resultClass.m_id}</b></font></td>
    </tr>
    <tr>
      <td width="250" ><b>���̵� �Է�</b></td>
      <td width="400" > </td>
    </tr> 

    <tr>
      <td width="250"> ����� ID</td>
      <td width="400">
        ${resultClass.m_id}
        <input type="hidden" name="m_id" value="${resultClass.m_id}"/>
      </td>
    </tr>
    <tr>
      <td width="250"> ��й�ȣ</td>
      <td width="400" >
        <input type="password" name="m_pw" size="15" value="${resultClass.m_pw}" maxlength="12">
      </td>
    <tr> 
      <td width="250">��й�ȣ Ȯ��</td>
      <td width="400">
        <input type="password" name="m_pwr" size="15" value="${resultClass.m_pw}" maxlength="12">
      </td>
    </tr>
    <tr>
      <td width="250" ><b>�������� �Է�</b></td>
      <td width="400" > </td>
    </tr> 
    <tr>
      <td width="250">����� �̸�</td>
      <td width="400">
        <input type="text" name="m_name" size="15" value="${resultClass.m_name}" maxlength="10">
      </td>
    </tr>
     <tr>
      <td width="250"> ����� �������</td>
      <td width="400">
        <input type="text" name="m_jumin1" size="6" value="${resultClass.m_jumin1}" maxlength="6">
        - <input type="text" name="m_jumin2" size="7" value="${resultClass.m_jumin2}" maxlength="7">
      </td>
    </tr>
    
    <tr>
      <td width="250">E-Mail</td>
      <td width="400">
        <input type="text" name="m_email" size="40" value="${resultClass.m_email}" maxlength="30">
      </td>
    </tr>
    <tr>
      <td width="250">�޴���ȭ ��ȣ</td>
      <td width="400">
        <input type="text" name="m_phone" size="15" value="${resultClass.m_phone}" maxlength="11">
      </td>
    </tr>
    <tr>
<tr> 
       <td width="250">�����ȣ</td>
       <td> <input type="text" id="m_zipcode" value="${resultClass.m_zipcode}" name="m_zipcode" size="7">
               <input type="button" value="�����ȣã��" onClick="zipCheck()">
          </tr>
    <tr> 
       <td>�ּ�</td>
       <td><input type="text" id="m_addr1" name="m_addr1" value="${resultClass.m_addr1}" size="70">
    </tr>
    <tr> 
       <td>���ּ�</td>
       <td><input type="text" id="m_addr2" name="m_addr2" value="${resultClass.m_addr2}" size="70"></td>
    </tr>
    <tr>
      <td colspan="2" align="center" >
          <input type="submit" name="confirm" value="���� �Ϸ�">
          <input type="button" value="���" onclick="javascript:location.href='mainAction.action'">
      </td>
    </tr>
  
  </table>
</form>
</body>
</html>