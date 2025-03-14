<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP프로젝트 </title>
</head>
<body>

	<h1>JSP Project</h1>
	
	<%
		String name = "bii";
		int age = 25;
	%>
	
	<%! public int add(int a, int b){return a+b;} %>
	
	<p> name: <%=name %> </p>
	<p> age: <%=age %> </p>
	<p> 더하기 : <%=add(1,2) %> </p>
	
		
</body>
</html>