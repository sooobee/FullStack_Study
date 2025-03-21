<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 프로젝트</title>
</head>
<body>

	<h1>JSP Project</h1>

	<c:set var="name" value="bii"/>
	<c:set var="age" value="20"/>
	
	<c:out value="${name} 은/는 "/>
	
	<c:if test="${age>=20}">
		<p>${name}은/는 성인 입니다.</p>
	</c:if>
	
	<c:choose>
		<c:when test="${age>20}">
			21살 이상 입니다.
		</c:when>
		
		<c:when test="${age==20}">
			20살 입니다.
		</c:when>
		
		<c:otherwise>
			미성년자 입니다.
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>