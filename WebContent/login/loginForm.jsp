<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/jquery.query-2.1.7.js"></script>
<script type="text/javascript" src="style/js/rainbows.js"></script>
<script>
   function error_msg() {
      if (document.getElementById("ID").value == "") {
         alert("아이디를 입력하세요");
         loginForm.m_id.focus();
         return false;
      } else if (document.getElementById("PW").value == "") {
         alert("비밀번호를 입력하세요");
         loginForm.m_pw.focus();
         return false;
      }
      return true;
   }
</script>
<style>
html {
   margin: 0;
   padding: 0;
   border: 0;
}

body, div, span, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote,
   pre, a, abbr, acronym, address, code, del, dfn, em, img, q, dl, dt, dd,
   ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot,
   thead, tr, th, td, article, aside, dialog, figure, footer, header,
   hgroup, nav, section, background{
   margin: 0;
   padding: 0;
   border: 0;
   font-weight: inherit;
   font-style: inherit;
   font-size: 100%;
   font-family: inherit;
   vertical-align: baseline;
}

article, aside, dialog, figure, footer, header, hgroup, nav, section {
   display: block;
}

body {
   line-height: 1.5;
   background: white;
}

table {
   border-collapse: separate;
   border-spacing: 0;
}

caption, th, td {
   text-align: left;
   font-weight: normal;
   float: none !important;
}

table, th, td {
   vertical-align: middle;
}

blockquote:before, blockquote:after, q:before, q:after {
   content: '';
}

blockquote, q {
   quotes: "" "";
}

a img {
   border: none;
}

:focus {
   outline: 0;
}

html {
   min-height: 100%;
}

body {
   height: 100%;
   position: relative;
   font-family: Arial, Helvetica, sans-serif;
   color: #888;
   font-size: 13px;
   line-height: 20px;
   min-width: 998px;
   border-top: 3px solid #919191;
   background: url(.style/image/login/BG.jpg) repeat;
}

#loginform {
   padding: 70px 0 0 0px;
   height: 100%;
}

#loginform {
   width: 350px;
   margin: auto;
   position: relative;
}

#loginformtop {
   background-image : url(style/image/login/wrapper_top.png); no-repeat;
   height: 22px;
}

#loginformmiddle {
   background-image : url(style/image/login/wrapper_middle.png); repeat-y;
   height: 240px;
}

#loginformbottom {
   background-image : url(style/image/login/wrapper_bottom.png); no-repeat;
   height: 22px;
}

#loginform h2 {
   margin-left: 20px;
   font-size: 20px;
   font-weight: bold;
   font-family: Myriad Pro;
   text-transform: uppercase;
   position: absolute;
   text-shadow: #fff 2px 2px 2px;
}

#username_input {
   margin-left: 25px;
   position: absolute;
   width: 300;
   height: 50px;
   margin-top: 40px;
}

#username_inputleft {
   float: left;
   background-image: url(style/image/login/input_left.png); no-repeat;
   width: 12px;
   height: 50px;
}

#username_inputmiddle {
   float: left;
   background-image: url(style/image/login/input_middle.png); repeat-x;
   width: 276px;
   height: 50px;
}

#username_inputright {
   float: left;
   background-image: url(style/image/login/input_right.png); no-repeat;
   width: 12px;
   height: 50px;
}

#ID {
   display:block;
	width:276px;
	height:45px;
	background:transparent;
	border:0;
	color:#bdbdbd;
	font-family:helvetica, sans-serif;
	font-size:14px;
	padding-left:20px;
}

#PW {
   display: block;
   width: 276px;
   height: 45px;
   background: transparent;
   border: 0;
   color: #bdbdbd;
   font-family: helvetica, sans-serif;
   font-size: 14px;
   padding-left: 20px;
}

#url_user {
   position: absolute;
   display: block;
   margin-top: -28px;
   float: left;
   padding-right: 10px;
}

#password_input {
   margin-left: 25px;
   position: absolute;
   width: 300;
   height: 50px;
   margin-top: 100px;
}

#password_inputleft {
   float: left;
   background-image: url(style/image/login/input_left.png); no-repeat;
   width: 12px;
   height: 50px;
}

#password_inputmiddle {
   float: left;
   background-image: url(style/image/login/input_middle.png); repeat-x;
   width: 276px;
   height: 50px;
}

#password_inputright {
   float: left;
   background-image: url(style/image/login/input_right.png); no-repeat;
   width: 12px;
   height: 50px;
}

#url_password {
   display: block;
   position: absolute;
   margin-top: -32px;
   float: left;
   margin-left: 4px;
}

#submit {
   float: left;
   position: relative;
   padding: 0;
   margin-top: 160px;
   margin-left: 25px;
   width: 300px;
   height: 40px;
   border: 0;
}

#submit1 {
   position: absolute;
   z-index: 10;
   border: 0;
}

#submit2 {
   position: absolute;
   margin-top: 0px;
   border: 0;
}

#links_left {
   float: left;
   position: relative;
   padding-top: 5px;
   margin-left: 25px;
}

#links_left a {
   color: #bbb;
   font-size: 11px;
   text-decoration: none;
   transition: color 0.5s linear;
   -moz-transition: color 0.5s linear;
   -webkit-transition: color 0.5s linear;
   -o-transition: color 0.5s linear;
}

#links_left a:hover {
   color: #292929;
}

#links_right {
   float: right;
   position: relative;
   padding-top: 5px;
   margin-right: 25px;
}

#links_right a {
   color: #bbb;
   font-size: 11px;
   text-decoration: none;
   transition: color 0.5s linear;
   -moz-transition: color 0.5s linear;
   -webkit-transition: color 0.5s linear;
   -o-transition: color 0.5s linear;
}

#links_right a:hover {
   color: #292929;
}

#powered {
   float: right;
   position: relative;
   padding-top: 3px;
   margin-right: 5px;
   font-size: 11px;
}

#powered a {
   color: #aaa;
   font-size: 11px;
   text-decoration: none;
   transition: color 0.5s linear;
   -moz-transition: color 0.5s linear;
   -webkit-transition: color 0.5s linear;
   -o-transition: color 0.5s linear;
}

#powered a:hover {
   color: #292929;
}
</style>
</head>
<body>

   <div id="loginform">
      <div id="loginformtop"></div>
<form action="checkIdAction.action">
      <div id="loginformmiddle">

         <h2>Login</h2>

         <div id="username_input">

            <div id="username_inputleft"></div>
            
               <div id="username_inputmiddle">

                  <input type="text" name="m_id" id="ID" value="Please ID"
                     onclick="this.value = ''"> <img id="url_user"
                     src="style/image/login/mailicon.png" alt="">

               </div>

               <div id="username_inputright"></div>
         </div>

         <div id="password_input">

            <div id="password_inputleft"></div>

            <div id="password_inputmiddle">

               <input type="password" name="m_pw" id="PW" value="Password" onclick="this.value = ''"> <img
                  id="url_password" src="style/image/login/passicon.png" alt="">

            </div>

            <div id="password_inputright"></div>

         </div>

         <div id="submit">

            <input type="image" src="style/image/login/sing_in.png" id="submit2"
               value="Sign In" onClick="return error_msg();" alt="checkIdAction.action">


         </div>
         <div id="links_left">
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="findIdForm.action">Forgot your Id?</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="findPwForm.action">Forgot your Password?</a>
         </div>
         <div id="links_right">
            <a href="joinForm.action">Not a Member Yet?</a>
         </div>
      </div>
      </form>
      <div id="loginformbottom"></div>
   </div>

</body>
</html>