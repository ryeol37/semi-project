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
         alert("로그인을 해주세요.");
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
         <li><a href="adminBookList.action">도서목록</a></li>
         <li><a href="adminBookWriteForm.action">도서등록</a></li>
         <li><a href="faqList.action">게시판 목록</a></li>
         
         <li><a href="noticeWriteForm.action">공지사항 등록</a></li>
         
         <li><a href="faqWriteForm.action">자주묻는질문 등록</a></li>
         <li><a href="adminMemberListForm.action">회원정보 관리</a></li>
         <li><a href="rentCheck.action">회원 대출 현황</a></li>
      </ul>
   </div>




   <%--  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script> --%>
</body>
