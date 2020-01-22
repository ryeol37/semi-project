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
         alert("로그인을 해주세요.");
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
                       						 <a href="siteMap.action">한눈에 보기 /</a>
                       						  <s:if test="${ session_id == null }">
                                 
                                 <a href="joinAgree.action">회원가입 /</a>
                                 <a href="loginForm.action">로그인</a>
                              </s:if> <s:else>
                                 <s:if test="${ session_isadmin == 1 }">
                                    <a href="admin.action">관리자페이지 /</a>
                                 </s:if>
                                 <s:else>
                                  	 ${session_id}님 환영! /</a>
                                 </s:else>
                                 <a href="logout.action">로그아웃 </a>
                              </s:else></td>
                        </tr>
                     </table>
                     <ul>
                
                        <li><a href="noticeList.action">도서관 안내</a>
                           <ul>
                              <li><a href="noticeList.action">공지사항</a></li>
                              <li><a href="intro.action">이용 안내</a></li>
                              <li><a href="map.action">오시는 길</a></li>
                              
                           </ul></li>
                        <li><a href="bookSearchForm.action">자료검색</a>
                           <ul>
                              <li><a href="bookSearchForm.action">통합검색</a></li>
                              <li><a href="bookSearch.action?searchNum=4&searchKeyword=">추천 도서</a></li>
                              <li><a href="bookSearch.action?searchNum=5&searchKeyword=">신간 도서</a></li>
                           </ul></li>
                        <li><a href="fboardList.action">통합게시판</a>
                           <ul>
                              <li><a href="fboardList.action">자유게시판</a></li>
                              <li><a href="faqList.action">자주묻는 질문</a></li>
                              <li><a href="needbookList.action">도서 신청</a>
                           </ul></li>
                           
                           <s:if test="${session_id == null }">
                           <li><a href="myPage.action" onClick="return idCheck();"/>나의서재</a>
                           <ul>
                           <li><a href="myPage.action" onClick="return idCheck();">개인정보관리</a></li>
                           <li><a href="myRentList.action" onClick="return idCheck();">대출 현황</a></li>
                           <li><a href="myDeleteForm.action" onClick="return idCheck();">회원 탈퇴</a></li>
                           </ul></li>
                           </s:if>
                           
                        <%--    <s:hidden name="member_id" value="${session_id}" /> --%>
                           <s:else>
                           <li><a href="myPage.action">나의서재</a>
                              <ul>
                                 <li><a href="myPage.action">개인정보관리</a></li>
                                 <li><a href="myRentList.action">대출 현황</a></li>
                                 <li><a href="myDeleteForm.action">회원 탈퇴</a></li>
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