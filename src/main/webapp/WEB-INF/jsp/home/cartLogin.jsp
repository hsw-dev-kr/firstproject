<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트 로그인 화면 (윈도우)</title>
</head>
<body>
<c:if test="${RESULT == 'nocart' }">
	<h3><font color="red">
		장바구는 담으시려면 로그인을 해주세요.
	</font></h3>
</c:if>
<form:form modelAttribute="user" method="post" action="../cart/login.html">
아이디:<form:input path="user_id" size="12"/>
<font color="red">
	<form:errors path="user_id"/>
</font><br>
비밀번호<form:password path="password" size="15"/>
<font color="red">
	<form:errors path="password"/>
</font><br><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form:form>
</body>
</html>