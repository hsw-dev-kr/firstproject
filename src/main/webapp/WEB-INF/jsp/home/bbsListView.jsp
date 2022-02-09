<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/home/jsp_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
<div align="center">
<h3 align="center">게시글 목록</h3>
<table border="1">
<tr>
	<th width="60">글번호</th><th width="260">제목</th>
	<th width="80">작성자</th>
	<th width="110">등록날짜</th>
</tr>
<c:forEach items="${BBS_LIST}" var="bbs">
<tr>
	<td align="center">${bbs.seqno}</td>
	<td align="center">
	<a href="../read/readDetail.html?SEQNO=${bbs.seqno}">${bbs.title}</a></td>
	<td align="center">${bbs.id}</td>
	<td align="center">${bbs.bbs_date}</td>
</tr>
</c:forEach>
</table>
<c:forEach begin="1" end="${pageCnt}" var="page">
	<a href="../read/read.html?pageNo=${page}">${page}</a>
</c:forEach>
</div>
</body>
</html>