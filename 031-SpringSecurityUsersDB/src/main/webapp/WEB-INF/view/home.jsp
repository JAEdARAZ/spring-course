<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- so the properties from the User can be accessed (Spring Security) -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
</head>

<body>
	<h1>Hello World from Jaimito!</h1>
	
	<hr>
		User: <security:authentication property="principal.username" />
		Role(s): <security:authentication property="principal.authorities" />
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/managerMenu">Managers menu</a>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/adminMenu">Admins menu</a>
	</security:authorize>
	
	<br><br>
	
	<!-- add logout with form, since logouts with Spring Security need to be submitted this way -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>

</html>