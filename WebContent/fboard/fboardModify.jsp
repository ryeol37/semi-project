<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���ۼ�</title>
	<SCRIPT type="text/javascript">
		function validation() {
		
			var frm = document.forms(0);
			
			if(frm.title.value == "") {
				alert("������ �Է����ּ���.");
				return false;
			} 
			
			else if(frm.content.value == "") {
				alert("������ �Է����ּ���.");
				return false;			
			} 
			

			return true;
		}
	</SCRIPT>
</head>
<body>
<table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  		</tr>
  	</table>
  
  		
		<form action="fboardModifyAction.action" method="post" enctype="multipart/form-data">
		  <s:hidden name="fb_no" value="%{resultClass.fb_no}" />
		  <s:hidden name="currentPage" value="%{currentPage}" />
		
       <table width="600" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="right" colspan="2"><font color="#FF0000">*</font>�� �ʼ� �Է»����Դϴ�.</td>
        </tr>
        
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
				
        <tr>
          <td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>����</td>
          <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="fb_subject" theme="simple" value="%{resultClass.fb_subject}" cssStyle="width:370px" maxlength="50"/>
          </td>
        </tr>
 
         <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
      
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
 
		<tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  ���� </td>
          <td bgcolor="#FFFFFF">
            <s:textarea name="fb_content" theme="simple" value="%{resultClass.fb_content}" cols="50" rows="10" />
          </td>
        </tr>
        
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        
        <tr>
          <td height="10" colspan="2"></td>
        </tr>
        
        
        <tr>
          <td align="right" colspan="2">
          	<input name="submit" type="submit" value="�ۼ��Ϸ�" class="inputb">
             <input name="list" type="button" value="���" class="inputb" onClick="javascript:location.href='fboardList.action?currentPage=<s:property value="currentPage" />'">
          </td>
        </tr>


    </table>
    </form>

</body>
</html>