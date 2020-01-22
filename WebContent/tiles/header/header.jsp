<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Delphic | Creative Portfolio Template</title>
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<link rel="stylesheet" media="all" href="style/type/folks.css" />
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="style/css/ie7.css" media="all" />
<![endif]-->
<script type="text/javascript" src="style/js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/scripts.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var id="${sessionScope.memberLogin.m_id}";
	console.log("id : "+id);
})

function idCheck() {
       
       if (%{ session_id == null }) {
         alert("�α����� ���ּ���.");
         return false;
      }
    }
</script>
</head>
<body>
<s:hidden name="cklg" value="${session.id }"/>
   <div id="container">
      <!-- Begin Header Wrapper -->
      <div id="page-top">
         <div id="header-wrapper">
            <!-- Begin Header -->
            <div id="header">
               <div id="logo">
                  <a href="mainAction.action"><img src="./style/image/lgoo.jpg"
                     alt="logo img" width="100" height="100" /></a>
               </div>
               <!-- Logo -->
               <!-- Begin Menu -->
               <div id="menu-wrapper">
                  <div id="smoothmenu1" class="ddsmoothmenu">

                     <table width="100%" height="100%" cellpadding="0" cellspacing="0"
                        border="0">
                        <tr>
                           <td align="left">
                              <!--  <div id="logo"><a href="mainAction.action"><img src="./style/image/logo.jpg" alt="logo img"  /></a></div> -->
                           </td>
                           <td align="right"><a href="mainAction.action">home /</a>
                       						 <a href="siteMap.action">�Ѵ��� ���� /</a>
                       						  <s:if test="${ session_id == null }">
                                 
                                 <a href="joinAgree.action">ȸ������ /</a>
                                 <a href="loginForm.action">�α���</a>
                              </s:if> <s:else>
                                 <s:if test="${ session_isadmin == 1 }">
                                    <a href="admin.action">������������ /</a>
                                 </s:if>
                                 <s:else>
                                  	 ${session_id}�� ȯ��! /</a>
                                 </s:else>
                                 <a href="logout.action">�α׾ƿ� </a>
                              </s:else></td>
                        </tr>
                     </table>
                     <ul>
                
                        <li><a href="noticeList.action">������ �ȳ�</a>
                           <ul>
                              <li><a href="noticeList.action">��������</a></li>
                              <li><a href="intro.action">�̿� �ȳ�</a></li>
                              <li><a href="map.action">���ô� ��</a></li>
                              
                           </ul></li>
                        <li><a href="bookSearchForm.action">�ڷ�˻�</a>
                           <ul>
                              <li><a href="bookSearchForm.action">���հ˻�</a></li>
                              <li><a href="bookSearch.action?searchNum=4&searchKeyword=">��õ ����</a></li>
                              <li><a href="bookSearch.action?searchNum=5&searchKeyword=">�Ű� ����</a></li>
                           </ul></li>
                        <li><a href="fboardList.action">���հԽ���</a>
                           <ul>
                              <li><a href="fboardList.action">�����Խ���</a></li>
                              <li><a href="faqList.action">���ֹ��� ����</a></li>
                              <li><a href="needbookList.action">���� ��û</a>
                           </ul></li>
                           
                           <s:if test="${session_id == null }">
                           <li><a href="myPage.action" onClick="return idCheck();"/>���Ǽ���</a>
                           <ul>
                           <li><a href="myPage.action" onClick="return idCheck();">������������</a></li>
                           <li><a href="myRentList.action" onClick="return idCheck();">���� ��Ȳ</a></li>
                           <li><a href="myDeleteForm.action" onClick="return idCheck();">ȸ�� Ż��</a></li>
                           </ul></li>
                           </s:if>
                           
                        <%--    <s:hidden name="member_id" value="${session_id}" /> --%>
                           <s:else>
                           <li><a href="myPage.action">���Ǽ���</a>
                              <ul>
                                 <li><a href="myPage.action">������������</a></li>
                                 <li><a href="myRentList.action">���� ��Ȳ</a></li>
                                 <li><a href="myDeleteForm.action">ȸ�� Ż��</a></li>
                              </ul></li>
                              </s:else>
                     </ul>
                  </div>
               </div>
               <!-- End Menu -->
            </div>
            <!-- End Header -->
         </div>
      </div>
   </div>
   <div class="line"></div>
</body>
</html>