<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Manager Menu</title>
</head>

<body>
	<h1>This menu is just available for MANAGERS</h1>
	
	<hr>

	<p>
		User: <security:authentication property="principal.username" />
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<a href="${pageContext.request.contextPath}/">Back to Main Menu</a>
	
	<br><br>
	
	<!-- add logout with form, since logouts with Spring Security need to be submitted this way -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>

</html>