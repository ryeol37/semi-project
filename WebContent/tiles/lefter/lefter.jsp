 <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
	<section class="loginform cf">
		<form name="login" action="checkIdAction.action" method="get" accept-charset="utf-8">
			<ul>
				<li>
					
					<s:if test="${ session_id == null }">
					<label for="ID">ID</label><br>
					<input type="ID" name="m_id" placeholder="아이디를 입력하세요">
				</li>
				<br>
				<li>
					<label for="password">Password</label>
					<br>
					<input type="password" name="m_pw" placeholder="비밀번호"></li>
				<li>
					<input type="submit" value="Login">&nbsp;&nbsp;
					<input type="button" value="Sign" onclick="javascript:location.href='joinAgree.action'">
				</li>
			</ul>
		
	
					</s:if>
					 <s:else>
					 ${ session_id }님 로그인 되셨습니다.
                   <input type="button" value="마이페이지" align="left" onclick="javaScript:location.href='myPage.action'">&nbsp;&nbsp;
				<input type="button" value="로그아웃" align="right" onclick="javascript:location.href='logout.action'">
				 <%-- <a href="logout.action">로그아웃 (${ session_id })</a> --%>
                     </s:else>
					
				
 </form>     
    </section>
 
 <%--  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script> --%>
</body>
</html>