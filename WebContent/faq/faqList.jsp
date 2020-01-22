<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
   int i = 1;
%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>FAQ</title>

<%-- <script type="text/javascript">
   function idCheck() {
      var form = document.write;
      if (!form.member_id.value) {
         alert("!!!!");
         return false;
      }
   }
</script> --%>

</head>

<body><%-- 
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
         <th width="70">글번호</th>
         <th align="center" width="350">제목</th>
      </tr>
      <tr bgcolor="#777777">
         <td height="1" colspan="5"></td>
      </tr>

      <s:iterator value="list" status="stat">
      <s:url id="viewURL" action="faqDetail">
            <s:param name="f_no">
               <s:property value="f_no" />
            </s:param>
            <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>

         <tr bgcolor="white" align="center">
            <td><s:property value="listNo" /></td>
            <td align="center"><s:a href="%{viewURL}"><s:property value="f_subject" />
               </s:a></td>
         </tr>
         <tr bgcolor="black">
            <td height="0" colspan="5"></td>
         </tr>
      </s:iterator>

      <s:if test="list.size() <= 0">

         <tr bgcolor="#FFFFFF" align="center">
            <td colspan="5">등록된 FAQ가 없습니다.</td>
         </tr>
         <tr bgcolor="#777777">
            <td height="1" colspan="5"></td>
         </tr>

      </s:if>

      <form name="write" action="faqWriteForm.action" method="post">
         <tr align="right">
            <td colspan="5"><s:hidden name="m_id"
                  value="${session_id }" /> <s:if test="${ session_id != null }">
                  <input type="submit" value="글쓰기" onclick="return idCheck();" />
               </s:if></td>
         </tr>
      </form>
      <tr align="center">
         <td colspan="5"><s:property value="pagingHtml" escape="false"></s:property></td>
      </tr>
      <tr>
         <td colspan="5">
            <form>
               <select name="searchNum">
                  <option value="0">제목</option>
                  <option value="2">내용</option>
               </select>
               <s:textfield name="searchKeyword" theme="simple" value=""
                  cssStyle="width:120px" maxlength="20" />
               <input name="submit" type="submit" value="검색" class="inputb">
            </form>
         </td>
      </tr>
   </table> --%>
   <table class="type10" width="600" border="0" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th scope="cols" width="70">글번호</th>
        <th scope="cols" align="center" width="350">제목</th>
        <th scope="cols" width="70">등록날짜</th>
        <th scope="cols" width="70">조회수</th>
    </tr>
    </thead>
    <tbody>
          <s:iterator value="list" status="stat">
      <s:url id="viewURL" action="faqDetail">
            <s:param name="f_no">
               <s:property value="f_no" />
            </s:param>
            <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>

         <tr>
            <th class="nop"><s:property value="listNo" /></th>
            <td class="nopp" align="center"><s:a href="%{viewURL}"><s:property value="f_subject" />
               </s:a></td>
            <td class="nopp" align="center"><s:property value="f_regdate" /></td>
            <td class="nopp" align="center"><s:property value="f_readhit" /> </td>
         </tr>
        
      </s:iterator>

      <s:if test="list.size() <= 0">

         <tr bgcolor="#FFFFFF" align="center">
            <td colspan="5">등록된 FAQ가 없습니다.</td>
         </tr>
         <tr  class="nopp" bgcolor="#777777">
            <td height="1" colspan="5" ></td>
         </tr>

      </s:if>

      <form name="write" action="faqWriteForm.action" method="post">
         <tr align="right">
            <td colspan="5">
            <s:hidden name="m_id" value="${session_id }" /> 
            <s:if test="${ session_isadmin == 1 }">
            <input type="submit" value="글쓰기" onclick="return idCheck();" />
               </s:if></td>
         </tr>
      </form>
      <tr align="center">
         <td colspan="5" ><s:property value="pagingHtml" escape="false"></s:property></td>
      </tr>
      <tr align="center">
         <td colspan="5">
            <form>
               <select name="searchNum">
                  <option value="0">제목</option>
                  <option value="1">작성자</option>
                  <option value="2">내용</option>
               </select>
               <s:textfield name="searchKeyword" theme="simple" value=""
                  cssStyle="width:120px" maxlength="20" />
               <input name="submit" type="submit" value="검색" class="inputb">
            </form>
         </td>
      </tr>
    <!-- <tr>
        <th scope="row">항목명</th>
        <td>내용이 들어갑니다.</td>
    </tr>
    <tr>
        <th scope="row" class="even">항목명</th>
        <td class="even">내용이 들어갑니다.</td>
    </tr>
    <tr>
        <th scope="row">항목명</th>
        <td>내용이 들어갑니다.</td>
    </tr> -->
    </tbody>
</table>
</body>
</html>