<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카네스 블랙 카페</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<!--헤더의 내용이 다 들어감-->
<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<div id="container">
		<div id="menuAdmin">
			<h2 id="menuAdminH2">공지사항</h2>
			
			<!-- jstl을 사용하여 메니저일때 버튼이 보이게 설정 -->
			<c:if test="${MANAGER == true}">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/noticeAdd'">작성</button>
			</c:if>
			<div id="menuList">
			</div>
		</div>
	</div>
	
<!--푸터의 내용이 다 들어감-->	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>