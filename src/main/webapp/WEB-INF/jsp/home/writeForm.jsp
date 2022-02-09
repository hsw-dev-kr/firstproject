<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판 글쓰기 화면</title>
</head>
<body>
<form:form modelAttribute="writing" action="../write/write.html" 
	method="post"	enctype="multipart/form-data">
<form:hidden path="order_no"
		value="${writing.order_no + 1 }"/>
		
<c:if test="${ ! empty writing.group_id }">
<form:hidden path="group_id"
		value="${writing.group_id }"/>
</c:if>

<c:if test="${ ! empty writing.parent_id }">
<form:hidden path="parent_id"
		value="${param.parent_id }"/>
</c:if>
	
<table border="1" width="100%">
<tr><td>글제목</td><td><form:input path="title"
size="40" value="${title }"/>
<form:errors path="title"/></td></tr>
<tr><td>닉네임</td><td><form:input path="writer_name" 
size="20"/>
<form:errors path="writer_name"/></td></tr>
<tr><td>이메일</td><td><form:input path="email"
size="20"/></td></tr>
<tr><td>암 호</td><td><form:password path="password" 
size="20"/>
<form:errors path="password"/></td></tr>
<tr><td>이미지</td><td><input type="file" 
name="image" size="40"/></td></tr>
<tr><td>글내용</td><td><form:textarea row="8" cols="40"
path="content"></form:textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="등 록"/>
</td></tr>
</table>
</form:form>
</body>
</html>