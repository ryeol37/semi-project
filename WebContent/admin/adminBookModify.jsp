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


  <form action="adminBookModifyAction.action" method="post" enctype="multipart/form-data">
		  <s:hidden name="b_no" value="%{resultClass.b_no}" />
		  <s:hidden name="currentPage" value="%{currentPage}" />
      <table width="800" border="0" cellspacing="1" cellpadding="1">
         <tr>
            <td align="right" colspan="2"><font color="#FF0000">*</font>�� �ʼ� �Է»����Դϴ�.</td>
         </tr>

         <tr bgcolor="#777777">
            <td height="1" colspan="2"></td>
         </tr>

         <tr>
            <td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font> ����  ����</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_name" id="b_name" theme="simple" value="%{resultClass.b_name}" cssStyle="width:370px" maxlength="30"/>
         </tr>

         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000">*</font> ����</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_writer" id="b_writer" theme="simple" value="%{resultClass.b_writer}" cssStyle="width:370px" maxlength="20"/>
         </tr>
         
         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000">*</font> ���ǻ�</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_pub" id="b_pub" theme="simple" value="%{resultClass.b_pub}" cssStyle="width:370px" maxlength="50"/>
          <!-- <td><input type="text" name="book_publisher" size="15" maxlength="10"/></td> -->
         </tr>

         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000">*</font> ���ǿ���</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_pubdate" theme="simple" value="%{resultClass.b_pubdate}" cssStyle="width:370px" maxlength="15"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_publish_dt" size="15" maxlength="10"/></td> -->
         </tr>

         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000"></font> ī�װ�</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_category" theme="simple" value="%{resultClass.b_category}" cssStyle="width:370px" maxlength="20"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>
         
         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000"></font> ������</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textfield name="b_count" theme="simple" value="%{resultClass.b_count}" cssStyle="width:370px" maxlength="20"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>
         
         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000"></font> ���� �Ұ�</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textarea name="b_intro" theme="simple" value="%{resultClass.b_intro}" cssStyle="width:370px" cols="15" rows="10"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>

         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000"></font> ���� �Ұ�</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textarea name="b_writerintro" theme="simple" value="%{resultClass.b_writerintro}" cssStyle="width:370px" cols="15" rows="10"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>
         
         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000"></font> ����</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:textarea name="b_list" theme="simple" value="%{resultClass.b_list}" cssStyle="width:370px" cols="15" rows="10"/>
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>
                  
         <tr>
            <td bgcolor="#F4F4F4"><font color="#FF0000">*</font> ���� �̹���</td>
            <td width="500" bgcolor="#FFFFFF">
            <s:file name="upload" theme="simple"/>
       
            <s:if test="resultClass.b_img != NULL">
			&nbsp; * <s:property value="resultClass.b_img" /> ������ ��ϵǾ� �ֽ��ϴ�. �ٽ� ���ε��ϸ� ������ ������ �����˴ϴ�.
			</s:if>
			
            <!-- <td bgcolor="#FFFFFF"><input type="text" name="book_image" size="15" maxlength="10"/></td> -->
         </tr>
      
         <tr>
         <td align="right" colspan="2">
          	<input name="submit" type="submit" value="�ۼ��Ϸ�" class="inputb">
             <input name="list" type="button" value="���" class="inputb" onClick="javascript:location.href='adminBookList.action?
		'&b_no=<s:property value="resultClass.b_no" />'">
          </td>
         </tr>
      </table>
   </form>

</body>
</html>