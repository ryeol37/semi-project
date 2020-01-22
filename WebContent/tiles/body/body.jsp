<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Charlie</title>
<style>
.sch_smit {
	width: 54px; height: 35px;
	margin: 0; border: 0;
	background: #EEEEEE;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}
input[type=text]{width:500px;height:35px;margin:32px auto 70px;}
.body {
   height: 90px;
}


table.type09 {
    border-collapse: collapse;
    text-align: left;
    height: auto; width: 200px;

}

table.type09 thead th{
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    height: auto; width: 50px;
}
table.type09 thead td{
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    height: auto; width: 100px;
    background:#D5D5D5;
}
table.type09 tbody {
    width: 1000px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    height: auto; width: 600px;
}
</style>
<link href="style/css/bootstrap.min.css" rel="stylesheet">
<link href="style/css/carousel.css" rel="stylesheet">
</head>
<body>
   <table width="300" cellpadding="0" cellspacing="0">
      <tr>
         <td colspan="2" height="10"></td>
      </tr>
      <tr>
         <td colspan="2" height="10"></td>
      </tr>
      <tr>
         <td colspan="2" height="10"></td>
      </tr>
   </table>
  <div align="center">
   ����˻�
   <span class="select_box01">
												
					</span>
   </div>
      <div id="mainSearch" align="center">
      <form action="bookSearch.action">
      <select iname="searchNum">
							<option value="0">��ü</option>
							<option value="1">������</option>
							<option value="2">����</option>
							<option value="3">���ǻ�</option>
						</select>
      <span class="inputb"><input type="text" id="mainSearch" name="searchKeyword" value="" code="" maxLength="1000" autocomplete="off" style="ime-mode:active; hcet-mode:rim;" class="input_text" placeholder="�˻�� �Է��ϼ���!"/></span>
      <span>
      <input name="submit" type="submit" value="�˻�" class="inputb">
      </span>
      </form>
					
      </div>
  


<table>
   <tr>
   <td>
      <div id="recommend" align="left">
      <table class="type09">
             <thead>
             	<tr>
             	<th colspan="4" align="center">
             	<h2><b><strong>��õ����</strong></b></h2>
             	</th></tr>
               <tr align="center">
               <td colspan="2" class="td1"> <strong>���� ����</strong> </td>
               <td class="td1"> <strong>����</strong> </td>
               </tr>
            </thead>
            <tbody>
               <s:iterator value="list2" status="stat">
                  <s:if test="${session_isadmin == 1 }">
                     <s:url id="viewURL" action="bookView">
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
                  <tr bgcolor="black" align="center">

                     <td colspan="2" align="center">&nbsp;<s:a href="%{viewURL}">
                           <s:property value="b_name" />
                           <s:hidden value="${ b_no }"/>
                        </s:a></td>
                     <!--    <td align="center"><s:property value="member_id" /></td> -->
                     <td align="center"><s:property value="b_writer" /></td>
                  </tr>
                  </s:iterator>
               </tbody>
            </table>
         </div>
      </td>
      <td>
      <div id="newbook" align="center">
            <table class="type09">
             <thead>
             <tr align="center">
             	<th colspan="4" align="center">
             	<h2><b><strong>�Ű�����</strong></b></h2>
             	</th>
             </tr>
            <tr align="center">
               <td colspan="2" class="td1"> <strong>�Ű�����</strong> </td>
               <td class="td1"> <strong>����</strong> </td>
               </tr>
               </thead>
               <tbody>
               <s:iterator value="list3" status="stat">
                  <s:url id="viewURL" action="bookView">
                     <s:param name="b_no">
                        <s:property value="b_no" />
                     </s:param>
                     <s:param name="currentPage">
                        <s:property value="currentPage" />
                     </s:param>
                  </s:url>

                  <tr bgcolor="black" align="center">

                     <td colspan="2" align="left">&nbsp;<s:a href="%{viewURL}">
                          <s:property value="b_name" />
                           <s:hidden value="${ b_no }"/>
                        </s:a></td>
                     <!--    <td align="center"><s:property value="member_id" /></td> -->
                     <td align="center"><s:property value="b_writer" /></td>
                  </tr>
               </s:iterator>
               </tbody>
               <s:if test="list.size() <= 0">

                  <tr bgcolor="#FFFFFF" align="center">
                     <td colspan="5">��ϵ� �Խù��� �����ϴ�.</td>
                  </tr>
               </s:if>
            </table>
         </div>
         </td>
        <td>
      <div id="about" align="right">
            <table class="type09">
             <thead>
             <tr align="center">
             	<th colspan="4" align="center">
             	<h2><b><strong>��������</strong></b></h2>
             	</th>
             </tr>
            <tr align="center">
               <td colspan="2" class="td1"> <strong>��������</strong> </td>
               <td class="td1"> <strong>�ۼ���</strong> </td>
               </tr>
               </thead>
               <tbody>
               <s:if test="list.size() <= 0">
                  <tr bgcolor="#FFFFFF" align="center">
                     <td colspan="5">��ϵ� �Խù��� �����ϴ�.</td>
                  </tr>
               </s:if>
               <s:else>
               <s:iterator value="list" status="stat">
                  <s:url id="viewURL" action="noticeDetail.action">
                     <s:param name="n_no">
                        <s:property value="n_no" />
                     </s:param>
                     <s:param name="currentPage">
                        <s:property value="currentPage" />
                     </s:param>
                  </s:url>

                  <tr bgcolor="white" align="center">

                     <td colspan="2" align="left">&nbsp;<s:a href="%{viewURL}">
                           <s:property value="n_subject" />
                        </s:a></td>
                     <!--    <td align="center"><s:property value="member_id" /></td> -->
                     <td align="center"><s:property value="n_regdate" /></td>
                  </tr>
               </s:iterator>
               </s:else>
               </tbody>
               
            </table>
         </div>
         </td>
         <!-- End About -->
         </tr>
         </table>
      </div>


   
</body>
</html>