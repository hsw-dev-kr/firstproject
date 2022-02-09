<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<div align="center">
	<table>
		<tr>
			<th>글번호</th><th>글제목</th><th>글내용</th><th>작성자</th><th>작성일</th>
		</tr>
		<tr>
			<td>${BBS.seqno}</td><td>${BBS.title}</td>
			<td>${BBS.content}</td><td>${BBS.id}</td><td>${BBS.bbs_date}</td>
		</tr>
	</table>
</div>
</body>
</html>