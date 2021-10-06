<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>My Homepage</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="/css/board.css"/>" />
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>게시판</h1>
				<table border="1" width="640">
					
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${ vo.no}</td>
							<td><a href="<c:url value="/board/${vo.no }"/>">${vo.title }</a></td>
							<td>${ vo.userName}</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<c:choose>
								<c:when test="${authUser.getNo() == vo.userNo }">
									<td><a href="<c:url value="/board/delete/${vo.no }"/>">삭제</a></td>
								</c:when>
								<c:otherwise>
									<td>삭제불가능</td>
								</c:otherwise>
							</c:choose>
						
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><a href="<c:url value="/board/write" />">글쓰기</a></td>
					</tr>
				</table>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>