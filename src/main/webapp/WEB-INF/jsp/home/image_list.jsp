<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty LIST }">
	등록된 게시글이 없습니다.
</c:if>
<c:if test="${ ! empty LIST }">
<table>
<tr>
	<td align="center">
		<b>${startRow}~${endRo}/${count}</b>
	</td>
</tr>
</table>
<table border="1" width="100%">
<tr>
	<th>이미지</th><th>글제목</th><th>작성자</th><th>작성일</th>
	<th>다운로드</th>
</tr>
<c:forEach items="${LIST}" var="write">
<tr>
	<td><img src="${pageContext.request.contextPath}/WEB-INF/upload/${write.image_name}"
	width="50" height="50"
	></td>
	<td>
		<a>${write.title}</a>
	</td>
	<td>${write_name}</td>
	<td>${write.register_date}</td>
	<td>${write.image_name}</td>
	<td><a>다운로드</a></td>
</tr>
</c:forEach>
</table>

</c:if>
</body>
</html>