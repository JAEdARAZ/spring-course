<!-- specify the Spring namespace for Form Tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<!-- not student/processForm since we are already inside student (student/showForm in main-menu) -->
	<form:form action="processForm" modelAttribute="student">
	
		<!-- path: name of attributes in Student class -->
		First name: <form:input path="firstName" /><br>
		Last name: <form:input path="lastName" /><br>
		Country: <form:select path="country" items="${student.countryOptions}" /><br><br>
			
	 	<input type="submit" value="Submit" />
	
	</form:form>
		 

</body>

</html>