<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login/style.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<div id="login-container-wrapper">
		<div id="login-container">
			<h2>로그인</h2>
			
			<!-- localhost:8080/login으로 username, password 넘어감 -->
			<form action="${pageContext.request.contextPath}/login" method="post">
				<div class="input-group">
					<label for="username">아이디</label>
					<input type="text" id="username" name="username" required/>
				</div> 
				<div class="input-group">
					<label for="password">비밀번호</label>
					<input type="password" id="password" name="password" required/>
				</div>
				<button type="submit" id="login-button">로그인</button>
			</form>
			
			<div id="register-link">
				<!-- lcalhost:8080/register까지 이동 -->
				<a href="${pageContext.request.contextPath}/registerPage">회원가입</a>	
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>