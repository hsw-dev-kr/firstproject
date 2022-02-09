<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<div align="center">
<h3>게시판 글쓰기</h3>
<form:form modelAttribute="bbs" method="post" action="../bbs/write.html">
제목<form:input path="title"/>
<font color="red"><form:errors path="title"/></font><br>
글내용<form:textarea path="content" rows="5" cols="30"/>
<font color="red"><form:errors path="content"/></font><br>
<input type="submit" value="글쓰기">
<input type="reset" value="지우기">
</form:form>
</div>
</body>
</html>