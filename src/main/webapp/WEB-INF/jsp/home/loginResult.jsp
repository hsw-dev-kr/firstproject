<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser != null }">
		로그인 되었습니다.
		${sessionScope.loginUser}님♥
	</c:when>
	<c:otherwise>
		로그인 되지 않았습니다.<br>
		아이디와 암호를 확인해주세요.
		<c:if test="${cartLogin == 'YES' }">
			<a href="../cart/login.html">■다시 로그인하기</a>
		</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartLogin == 'success' || imageLogin == 'SUCCESS'}">
		<script type="text/javascript">
			self.close();opener.window.location.reload();
		</script>
	</c:when>
	
</c:choose>
</body>
</html>