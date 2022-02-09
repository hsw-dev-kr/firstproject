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
	<table align="center" style="width: 100%; background-color: orange;">
		<tr>
			<td><h2 align="center">MY HOME에 오신것을 환영합니다.</h2></td>
		</tr>
	</table>
	<table style="border: 1px solid blue; vertical-align: top;">
		<tr>
			<td style="width: 190px; height: 300px; border: 1px solid blue; vertical-align: top;">
				<fieldset>
				<!-- 서버가 include를 할수있게 webapp에 맵핑을 찾게 도와줬다. ../ 한개는 상위폴더를뜻함-->
				
					<c:choose>
						<c:when test="${sessionScope.loginUser != null }">
							<jsp:include page="logout.jsp" />
						</c:when>
						<c:when test="${HEADER != null}">
							<jsp:include page="${HEADER }" />
						</c:when>
						<c:otherwise>
<%-- 							<jsp:include page="../login/login.html" /> --%>
							<jsp:include page="../../../login/login.html" />
						</c:otherwise>
					</c:choose>
				</fieldset> 
				<a href="../home/intro.html?BODY=intro.jsp">자기소개</a><br/>
				<a href="../bbs/bbsTemplate.html">게시글 쓰기</a><br/> 
				<a href="../read/read.html">게시글 보기</a><br/> 
				<a href="../item/template.html">상품정보 등록</a><br/> 
				<a href="../read/item.html">상품정보 보기</a><br/>
				<a href="../cart/cartShow.html">장바구니 보기</a><br/>
				<a href="../write/writeForm.html">이미지 게시판 작성</a><br/>
			    <a href="../write/writeList.html">이미지 게시판 목록</a>
			</td>
			<td style="width: 650px; border: 1px solid blue;">
				<c:choose>
					<c:when test="${BODY != null }">
						<jsp:include page="${BODY }" />
					</c:when>
					<c:otherwise>
						BODY가 없다.
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	<div id="clock"></div>
	<div align="center" style="font-size: 20px; background-color: green;">
		2019. Copyright. 타이거</div>
</body>
</html>