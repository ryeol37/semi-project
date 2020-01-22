<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%
   int i = 1;
%> --%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>공지사항</title>

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
   
   <table class="type11" width="600" border="0" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
       <th width="70">글번호</th>
         <th align="center" width="350">제목</th>
         <th width="70">작성자</th>
         <th width="80">작성일</th>
         <th width="80">조회수</th>
    </tr>
    </thead>
    <tbody>
      

       <s:iterator value="list" status="stat">
      <s:url id="viewURL" action="noticeDetail">
            <s:param name="n_no">
               <s:property value="n_no" />
            </s:param>
            <s:param name="currentPage">
               <s:property value="currentPage" />
            </s:param>
         </s:url>

         <tr bgcolor="white" align="center">
            <td class="nopp"><s:property value="listNo" /></td>
            <td class="nopp" align="center"><s:a href="%{viewURL}"><s:property value="n_subject" /></s:a></td>
            <td class="nopp" align="center"><s:property value="m_id" /></td>
            <td class="nopp" align="center"><s:property value="n_regdate" /></td>
            <td class="nopp"><s:property value="n_readhit" /></td>
         </tr>
         <tr bgcolor="black">
            <td height="0" colspan="5"></td>
         </tr>
      </s:iterator>

      <s:if test="list.size() <= 0">
      

         <tr bgcolor="#FFFFFF" align="center">
            <td colspan="5">등록된 공지사항이 없습니다.</td>
         </tr>
         <tr bgcolor="#777777">
            <td height="1" colspan="5"></td>
         </tr>

      </s:if>

      <form name="write" action="noticeWriteForm.action" method="post">
         <tr align="right">
            <td colspan="5"><s:if test="${ session_isadmin == 1 }">
                  <input class="search" type="submit" value="글쓰기" onclick="return idCheck();" />
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
                  <option value="1">작성자</option>
                  <option value="2">내용</option>
               </select>
               <s:textfield name="searchKeyword" theme="simple" value=""
                  cssStyle="width:120px" maxlength="20" />
               <input name="submit" type="submit" value="검색" class="inputb">
            </form>
         </td>
      </tr>
   </table>
</body>
</html>