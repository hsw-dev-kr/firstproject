<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 목록</title>
</head>
<body>
<div align="center">
	<table>
		<tr>
			<th>코드</th><th>상품이름</th><th>상품가격</th><th>상품정보</th><th>원산지</th>
		</tr>
		<tr>
			<td>${ITEM.code}</td><td>${ITEM.name}</td>
			<td>
				<fmt:formatNumber groupingUsed="true">${ITEM.price}
				</fmt:formatNumber></td>
				<td>${ITEM.info}</td><td>${ITEM.origin}</td>
		</tr>
	</table>
</div>
</body>
</html>