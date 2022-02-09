<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<c:choose>
	<c:when test="${SIZE == 'NO'|| CART_LIST == null }">
		장바구니가 비었습니다.
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th width="70">상품코드</th>
				<th width="250">상품이름</th>
				<th width="80">상품가격</th>
				<th width="50">상품갯수</th>
				<th width="100">금액</th>
				<th width="80">수정/삭제</th>
			</tr>
			<c:forEach items="${CART_LIST}" var="cart">
				<form action="../cart/modify.html" method="post">
					<input type="hidden" name="CODE" value="${cart.code}">
					<tr>
						<td>${cart.code}</td>
						<td>${cart.name}</td>
						<td><fmt:formatNumber groupingUsed="true">
							${cart.price}
						</fmt:formatNumber></td>
						<td><input type="text" name="NUMBER" value="${cart.num}" size="3"></td>
						<td><fmt:formatNumber groupingUsed="true">
							${cart.price * cart.num}
						</fmt:formatNumber></td>
						<td>
							<input type="submit" value="수정" name="BTN">
							<input type="submit" value="삭제" name="BTN">
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose><br>
<form action="" method="post">
	총합:
	<fmt:formatNumber groupingUsed="true">
		${totalAmount}
	</fmt:formatNumber>
	<input type="submit" value="결제하기">
	<input type="reset" value="취소">
</form>
</body>
</html>