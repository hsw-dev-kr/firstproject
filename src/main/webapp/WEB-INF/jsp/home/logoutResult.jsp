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
<c:choose>
	<c:when test="${sessionScope.loginUser == null}">
	정상적으로 로그아웃 되었습니다.
	</c:when>
	<c:otherwise>
	정상적으로 로그아웃되지 않았습니다.<br/>
	관리자에게 문의해 주세요.
	</c:otherwise>
</c:choose>
</body>
</html>