<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${RESULT == 'nobody'}">
<h3 align="center">글을 올리시려면 로그인을 해야 합니다.</h3>
</c:if>
<c:if test="${ITEM == 'nobody' }">
<h3 align="center">상품을 올리려면 로그인 해야합니다.</h3>
</c:if>
<form:form modelAttribute="user" method="post" action="../login/frame.html">
아이디<form:input path="user_id" size="15"/>
<font color="red"><form:errors path="user_id"/></font>
<br>
비밀번호<form:password path="password" size="15"/>
<font color="red"><form:errors path="password"/></font>
<br><input type="submit" value="로그인">
</form:form>
</body>
</html>