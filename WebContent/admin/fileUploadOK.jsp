<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <p>
   <ul>
      <li>ContentType: <s:property value="uploadContentType" /></li>
      <li>FileName: <s:property value="uploadFileName" /></li>
      <li>File: <s:property value="upload" /></li>
   </ul>
   </p>
</body>
</html>