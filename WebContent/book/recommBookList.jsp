<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%
   int i = 1;
%> --%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>��õ����</title>

<script type="text/javascript">
   function idCheck() {
      var form = document.write;
      if (!form.m_id.value) {
         alert("!!!!");
         return false;
      }
   }
</script>

</head>

<body>
   <table width="600" border="0" cellspacing="0" cellpadding="2">
      <tr>
         <td align="center"><h2></h2></td>
      </tr>
      <tr>
         <td height="20"></td>
      </tr>
   </table>


   <table width="720" border="0" cellspacing="0" cellpadding="2">
      <tr align="center" bgcolor="#F3F3F3">
         <th width="70">�۹�ȣ</th>
         <th align="center" width="350">����</th>
         <th width="70">�ۼ���</th>
         <th width="80">�ۼ���</th>
         <th width="80">��ȸ��</th>
      </tr>
      <tr bgcolor="#777777">
         <td height="1" colspan="5"></td>
      </tr>

      <s:iterator value="list" status="stat">
      <s:url id="viewURL" action="bookView">
            <s:param name="b_no">
               <s:property value="b_no" />
            </s:param>
            <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>

         <tr bgcolor="white" align="center">
            <td><s:property value="listNo" /></td>
            <td align="center"><s:a href="%{viewURL}"><s:property value="b_name" /></s:a></td>
            <td align="center"><s:property value="m_id" /></td>
            <td align="center"><s:property value="b_like" /></td>
            <td><s:property value="b_count" /></td>
         </tr>
         <tr bgcolor="black">
            <td height="0" colspan="5"></td>
         </tr>
      </s:iterator>

      <s:if test="list.size() <= 0">
      

         <tr bgcolor="#FFFFFF" align="center">
            <td colspan="5">��ϵ� �Խñ��� �����ϴ�.</td>
         </tr>
         <tr bgcolor="#777777">
            <td height="1" colspan="5"></td>
         </tr>

      </s:if>

      <%-- <form name="write" action="noticeWriteForm.action" method="post">
         <tr align="right">
            <td colspan="5"><s:hidden name="n_id"
                  value="${session_id }" /> <s:if test="${ session_id != null }">
                  <input type="submit" value="�۾���" onclick="return idCheck();" />
               </s:if></td>
         </tr>
      </form> --%>
      <tr align="center">
         <td colspan="5"><s:property value="pagingHtml" escape="false"></s:property></td>
      </tr>
      <tr>
         <td colspan="5">
            <form>
               <select name="searchNum">
                  <option value="0">����</option>
                  <option value="1">�ۼ���</option>
                  <option value="2">����</option>
               </select>
               <s:textfield name="searchKeyword" theme="simple" value=""
                  cssStyle="width:120px" maxlength="20" />
               <input name="submit" type="submit" value="�˻�" class="inputb">
            </form>
         </td>
      </tr>
   </table>
</body>
</html>