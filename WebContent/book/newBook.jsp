<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�������</title>
</head>
<body>

   <table border="0" cellspacing="0" cellpadding="2">
      <tr>
         <td align="center"><h2></h2></td>
      </tr>
      <tr>
         <td height="10"></td>
      </tr>
   </table>
   <s:iterator value="list" status="stat">
      <s:if test="${session_isadmin == 1 }">
         <s:url id="viewURL" action="adminBookView">
            <s:param name="b_no">
               <s:property value="b_no" />
            </s:param>
         <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>
         </s:if>
         <s:else>
          <s:url id="viewURL" action="bookView">
            <s:param name="b_no">
               <s:property value="b_no" />
            </s:param>
         <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>
</s:else>
   <table border="0" cellspacing="0">
      <tr>
         <td rowspan="6" align="left" valign="top"><s:property value="b_no" />
         </td>
      </tr>
      <tr>
        <td rowspan="6" width="160" align="center"><img src="./style/image/book/${ b_imgcopy }" alt="�̹����� �����ϴ�" width="210" height="297" /></td>
      </tr>
      <tr>
         <td colspan="3" width="450"><b><s:a href="%{viewURL}"><s:property value="b_name" /></s:a></b></td>
      </tr>
      <tr>
         <td colspan="3">�� ���� : <s:property value="b_writer" /></td>
      </tr>
      <tr>
         <td width="400">�� ���ǻ� : <s:property value="b_pub" /></td>
         <td colspan="2" width="350">����� : <s:property value="b_pubdate" /></td>
      </tr>
     <tr>
         <td width="500">�� �ڷ���� :
         <s:hidden name="b_rentid" />
         <s:if test="${ b_rentid == null }">
                ���Ⱑ��
         </s:if>
         <s:else>
                ������
         </s:else>
		</td>
         <td colspan="2" width="300">�ݳ������� : <s:property value="b_indate" /></td>
      </tr>
   </table>
<table>
      <tr>
         <td height="10" colspan="6"></td>
      </tr>
</table>
      </s:iterator>

      <s:if test="list.size() <= 0">

         <tr align="center">
            <td colspan="5">��ϵ� �Խù��� �����ϴ�.</td>
         </tr>
         <tr>
            <td height="1" colspan="5"></td>
         </tr>

      </s:if>
   
      <tr align="center">
      <td colspan="5"><s:property value="pagingHtml"  escape="false"></s:property></td></tr>
</body>
</html>