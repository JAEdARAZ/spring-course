<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Custom Login</title>
</head>

<body>
   <h3>Custom Login Page</h3>
   <!-- Spring Security Filters reads from data and authenticates the user (automatically) -->
   <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
   		<!-- check for login error (Spring Security will append '?error' to the URL) -->
   		<c:if test="${param.error != null}">
   			<i>Not a valid user/password</i>
   		</c:if>
   
   		<p>
   			User name: <input type="text" name="username" />
   		</p>
   		<p>
   			Password: <input type="text" name="password" />
   		</p>
   		
   		<input type="submit" value="login" />
   </form:form>
</body>

</html>