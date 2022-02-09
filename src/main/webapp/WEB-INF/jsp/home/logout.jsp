<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../logout.html">
${sessionScope.loginUser}님<br>
<input type="submit" value="로그아웃">
</form>
</body>
</html>