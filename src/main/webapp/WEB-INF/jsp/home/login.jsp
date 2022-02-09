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

<c:if test="${param.MSG1 == 'Y' }">
 	이미지게시글을 등록하려면, 로그인 해야 합니다.<br>
 	<form:form modelAttribute="guest" action="../login/imageLogin.html"
	method="post">
아이디 <form:input path="user_id" size="15"/>
	<font color="red">
	<form:errors path="user_id"/></font><br>
비밀번호<form:password path="password" size="15"/>
	<font color="red"><form:errors path="password"/></font>
	<br><input type="submit" value="로그인">
</form:form>
</c:if>
<!-- action의 시작 디렉토리 위치는 WEB-INF같다  -->
<c:if test="${param.RESULT == null && param.MSG1 != 'Y' }">
<form:form modelAttribute="guest" action="../login/frame.html"
	method="post">
아이디 <form:input path="user_id" size="15"/>
<font color="red"><form:errors path="user_id"/></font>
<br>
비밀번호<form:password path="password" size="15"/>
<font color="red"><form:errors path="password"/></font>
<br><input type="submit" value="로그인">
</form:form>
</c:if>
</body>
</html>