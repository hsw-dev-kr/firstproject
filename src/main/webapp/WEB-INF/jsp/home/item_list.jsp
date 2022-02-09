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
<h3 align="center">게시글 목록</h3>
<table border="1">
<tr>
	<th width="60">코드</th><th width="260">상품명</th>
	<th width="80">상품가격</th>
	<th width="110">상품정보</th><th width="110">원산지</th>
</tr>
<c:forEach items="${ITEM_LIST}" var="item">
<tr>
	<td align="center">${item.code}</td>
	<td align="center">
	<a href="../read/ItemDetail.html?CODE=${item.code}">${item.name}</a></td>
	<td align="center">${item.price}</td>
	<td align="center">${item.info}</td>
	<td align="center">${item.origin}</td>
	<td><a href="#"onclick="window.open('../cart/cartAdd.html?code=${item.code}','cart','width=450, height=250').focus()">
		장바구니 담기</a></td>
</tr>
</c:forEach>
</table>
<c:forEach begin="1" end="${PAGE_CNT}" var="page">
	<a href="../read/item.html?pageNo=${page}">${page}</a>
</c:forEach>
</div>
</body>
</html>