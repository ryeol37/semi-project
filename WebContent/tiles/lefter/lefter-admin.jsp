<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CharlieBookTITLE</title>

<link href="style/custom/normalize.css" rel="stylesheet">
<link href="style/custom/style.css" rel="stylesheet">

<script type="text/javascript">
   function idCheck() {

      var a = document.getElementsByName("memberID").value;

      if (a == null) {
         alert("�α����� ���ּ���.");
         return false;
      }
   }
</script>
</head>
<body>
   <table cellpadding="0" cellspacing="0">
      <tr>
         <td colspan="2" height="30"></td>
      </tr>
   </table>
   <div class="leftMenu">
      <ul>
         <li><a href="adminBookList.action">�������</a></li>
         <li><a href="adminBookWriteForm.action">�������</a></li>
         <li><a href="faqList.action">�Խ��� ���</a></li>
         
         <li><a href="noticeWriteForm.action">�������� ���</a></li>
         
         <li><a href="faqWriteForm.action">���ֹ������� ���</a></li>
         <li><a href="adminMemberListForm.action">ȸ������ ����</a></li>
         <li><a href="rentCheck.action">ȸ�� ���� ��Ȳ</a></li>
      </ul>
   </div>




   <%--  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script> --%>
</body>
