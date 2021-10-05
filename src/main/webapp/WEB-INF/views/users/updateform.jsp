<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="/css/user.css"/>" />
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<div id="wrapper">
			<div id="content">
	<h1>회원 정보 수정</h1>
	<form id="join-form" name="userUpdateForm"
		action='<c:url value="/user/update"/>' method="POST">
		 <input type="hidden" name="no" value="${authUser.getNo()}"><label for="name">이름</label>
		 <input type="text" name="name" placeholder="이름을 입력하십시오" value="${authUser.getName()}"><br>
		 
		 <label for="password">비밀번호</label>
		 <input type="password" name="password" placeholder="비밀번호를 입력하십시오"><br>
		 <label for="email">이메일</label>
		 <input type="text" name="email" placeholder="이메일을 입력하십시오" value="${authUser.getEmail() }">
		 
		 <button onclick="checkEmail(this, '<c:url value="/user/emailcheck"/>');event.preventDefault();">이메일중복확인</button>		 
		
	</form>
     </div>
     </div>
     </div>
</body>
</html>