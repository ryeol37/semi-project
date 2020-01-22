<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var fullAddr = ''; // ���� �ּ� ����
                var extraAddr = ''; // ������ �ּ� ����

                // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
                if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                    fullAddr = data.roadAddress;

                } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
                    fullAddr = data.jibunAddress;
                }

                // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
                if(data.userSelectedType === 'R'){
                    //���������� ���� ��� �߰��Ѵ�.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // �ǹ����� ���� ��� �߰��Ѵ�.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('m_zipcode').value = data.zonecode; //5�ڸ� �������ȣ ���
                document.getElementById('m_addr1').value = fullAddr;

                // Ŀ���� ���ּ� �ʵ�� �̵��Ѵ�.
                document.getElementById('m_addr2').focus();
            }
        }).open();
    }
</script>

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

    // ���̵� �ߺ� ���θ� �Ǵ�
     function openConfirmid(userinput) {
        // ���̵� �Է��ߴ��� �˻�
        if (userinput.m_id.value == "") {
            alert("���̵� �Է��ϼ���");
            return false;
        }
        // url�� ����� �Է� id�� �����մϴ�.
        url = "confirmId.action?m_id=" + userinput.m_id.value ;
       
        // ���ο� �����츦 ���ϴ�.
        open(url, "confirm",
        "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=500");
    }
	
     function openConfirmEmail(userinput) {
         // email�� �Է��ߴ��� �˻�
         if (userinput.m_email.value == "") {
             alert("�̸��ϸ� �Է��ϼ���");
             return false;
         }
         // url�� ����� �Է� email�� �����մϴ�.
         url = "confirmEmail.action?m_email=" + userinput.m_email.value ;
        
         // ���ο� �����츦 ���ϴ�.
         open(url, "confirm",
         "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=500");
     }
     
     function ic(name){
    	 document.getElementById('ic').value = name;
     }
     
     function ec(email){
    	 document.getElementById('ec').value = email;
     }
     
     function openC() {
         if (userinput.ic.value == "a") {
             alert("���̵� �ߺ�Ȯ���� ���ּ���");
             return false;
         }
         if (userinput.ec.value == "a") {
             alert("�̸��� �ߺ�Ȯ���� �ϼ���");
             return false;
         }
     }
     
     function checkid(name){
             document.getElementById('m_id').value = name;
         }
    	 
     
     
     function checkemail(email){
    	 document.getElementById('m_email').value = email;
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
        <input type="text" id="m_id" name="m_id" size="10" maxlength="12">
        <input type="hidden" id="ic" name="ic" value="a">
        <input type="button" name="confirm_id" value="�ߺ�Ȯ��" OnClick="openConfirmid(this.form)">
      </td>
    </tr>
    <tr>
      <td width="250"> ��й�ȣ</td>
      <td width="400" >
        <input type="password" id="m_pw" name="m_pw" size="15" maxlength="12">
      </td>
    <tr> 
      <td width="250">��й�ȣ Ȯ��</td>
      <td width="400">
        <input type="password" name="m_pwr" size="15" maxlength="12">
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
      </td>
    </tr>
     <tr> 
      <td width="250">�ֹε�Ϲ�ȣ</td>
      <td width="400"> 
        <input type="text" id="m_jumin1" name="m_jumin1" size="6" maxlength="6">
        -&nbsp;<input type="text" id="m_jumin2" name="m_jumin2" size="7" maxlength="7">
      </td>
    </tr>
    <tr>
      <td width="250">E-Mail</td>
      <td width="400">
        <input type="text" name="m_email" id="m_email" size="40" maxlength="30">
        <input type="hidden" id="ec" name="ec" value="a">
        <input type="button" name="confirm_email" value="�̸��� Ȯ��" OnClick="openConfirmEmail(this.form)">
      </td>
    </tr>
   
    <tr>
      <td width="250">�޴���ȭ ��ȣ</td>
      <td width="400">
        <input type="text" name="m_phone" size="15" maxlength="11">
        <font color=red size=2>-���� �Է��ϼ���.</font>
      </td>
    </tr>
  
<tr> 
       <td width="250">�����ȣ</td>
       <td>
       <input type="text" id="m_zipcode" name="m_zipcode" placeholder="�����ȣ">
		<input type="button" onclick="sample6_execDaumPostcode()" value="�����ȣ ã��">  
       </td>
</tr>
         
    <tr> 
       <td>�ּ�</td>
       <td><input type="text" id="m_addr1" name="m_addr1" placeholder="�ּ�" size="70"></td>
    </tr>
    <tr> 
       <td>���ּ�</td>
       <td><input type="text" id="m_addr2" name="m_addr2" placeholder="���ּ�" size="70"></td>
    </tr>
    <tr>
      <td colspan="2" align="center" >
          <input type="submit" name="confirm" value="��   ��" OnClick="return openC()">
          <input type="reset" name="reset" value="�ٽ��Է�">
          <input type="button" value="���Ծ���" onclick="javascript:location.href='mainAction.action'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>