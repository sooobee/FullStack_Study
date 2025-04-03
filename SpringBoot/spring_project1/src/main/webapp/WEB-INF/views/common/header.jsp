<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common/header.css">
</head>
<body>
<div id="header">
	<div style="text-align:left; float:left; cursor:pointer" onClick="location.href='${pageContext.request.contextPath}/'">
		CanesBlackCafe
	</div>
	
	<c:choose>
		<c:when test="${isAuthenticated != null && isAuthenticated == true}">
			<div style="float:right;">
				<a href="${pageContext.request.contextPath}/logout" 
				style="color:white;margin-right:15px;text-decoration:none; font-size:15px;">로그아웃</a>
			</div>
		</c:when>
		<c:otherwise>
			<div style="float:right;">
					<a href="${pageContext.request.contextPath}/loginPage"
					style="color:white;margin-right:15px;text-decoration:none; font-size:15px;">로그인</a>
				</div>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
