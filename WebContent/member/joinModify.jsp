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
        if(!userinput.m_jumin1.value  || !userinput.m_jumin2.value )
        {
            alert("�ֹε�Ϲ�ȣ�� �Է��ϼ���");
            return false;
        }
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

<form method="post" action="joinSuccess.action" name="userinput" onSubmit="return checkIt()">
  <table width="650" border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center">
       <font size="+1" ><b>ȸ������</b></font></td>
    </tr>
    <tr>
      <td width="250" ><b>���̵� �Է�</b></td>
      <td width="400" > </td>
    </tr> 

    <tr>
      <td width="250"> ����� ID</td>
      <td width="400">
        <input type="text" name="m_id" size="10" maxlength="12"> 
        &nbsp;&nbsp;<s:property value="resultClass.m_id" />
      </td>
    </tr>
    <tr>
      <td width="250"> ��й�ȣ</td>
      <td width="400" >
        <input type="password" name="m_pw" size="15" maxlength="12">
        &nbsp;&nbsp;<s:property value="resultClass.m_pw" />
      </td>
    <tr> 
      <td width="250">��й�ȣ Ȯ��</td>
      <td width="400">
        <input type="password" name="m_pwr" size="15" maxlength="12">
        &nbsp;&nbsp;<s:property value="resultClass.m_pwr" />
      </td>
    </tr>
    <tr>
      <td width="250" ><b>�������� �Է�</b></td>
      <td width="400" > </td>
    </tr> 
    <tr>
      <td width="250">����� �̸�</td>
      <td width="400">
        <input type="text" name="m_name" size="15" maxlength="10">
        &nbsp;&nbsp;<s:property value="resultClass.m_name" />
      </td>
    </tr>
     <tr> 
      <td width="250">�ֹε�Ϲ�ȣ</td>
      <td width="400"> 
        <input type="text" name="m_jumin1" size="7" maxlength="6">
        -&nbsp;<input type="text" name="m_jumin2" size="7" maxlength="7">
      </td>
    </tr>
    <tr>
      <td width="250">E-Mail</td>
      <td width="400">
        <input type="text" name="m_email" size="40" maxlength="30">
        &nbsp;&nbsp;<s:property value="resultClass.m_email" />
      </td>
    </tr>
    
    <tr>
      <td width="250">�޴���ȭ ��ȣ</td>
      <td width="400">
        <input type="text" name="m_phone" size="15" maxlength="10">
        <s:property value="resultClass.m_phone" />
         <font color=red size=2>-���� �Է��ϼ���.</font>
      </td>
    </tr>
    <tr>
<tr> 
       <td width="250">�����ȣ</td>
       <td> <input type="text" id="m_zipcode" name="m_zipcode" size="7">
               <input type="button" value="�����ȣã��" onClick="zipCheck()">
               &nbsp;&nbsp;<s:property value="resultClass.m_zipcode" /></td>
          </tr>
    <tr> 
       <td>�ּ�</td>
       <td><input type="text" id="m_addr1" name="m_addr1" size="70">
       &nbsp;&nbsp;<s:property value="resultClass.m_addr1" /></td>
    </tr>
    <tr> 
       <td>���ּ�</td>
       <td><input type="text" id="m_addr2" name="m_addr2" size="70">
       &nbsp;&nbsp;<s:property value="resultClass.m_addr2" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" >
          <input type="submit" name="confirm" value="���� �Ϸ�" >
          <input type="reset" name="reset" value="�ٽ� �Է�">
          <input type="button" value="���" onclick="javascript:location.href='main.action'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>