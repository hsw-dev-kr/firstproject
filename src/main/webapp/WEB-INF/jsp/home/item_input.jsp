<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 등록화면</title>
</head>
<body>
<form:form modelAttribute="item" method="post" action="../item/itemSubmit.html">
<table border="1">
	<tr>
		<td>코드</td>
		<td><form:input path="code"/>
			<font color="red"><form:errors path="code"/></font>
		</td>
	</tr>	
	<tr>
		<td>이름</td>
		<td><form:input path="name"/>
			<font color="red"><form:errors path="name"/></font>	
		</td>
	</tr>
	<tr>
		<td>가격</td>
		<td><form:input path="price"/>
			<font color="red"><form:errors path="price"/></font>	
		</td>
	</tr>
	<tr>
		<td>정보</td>
		<td><form:input path="info"/>
			<font color="red"><form:errors path="info"/></font>	
		</td>
	</tr>
	<tr>
		<td>원산지</td>
		<td><form:input path="origin"/>
			<font color="red"><form:errors path="origin"/></font>	
		</td>								
	</tr>
</table>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form:form>
</body>
</html>