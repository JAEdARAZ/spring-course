<!-- specify the Spring namespace for Form Tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>

<body>

	<!-- not student/processForm since we are already inside student (student/showForm in main-menu) -->
	<form:form action="processForm" modelAttribute="student">
	
		<!-- path: name of attributes in Student class -->
		First name: <form:input path="firstName" /><br>
		Last name: <form:input path="lastName" /><br><br>
			
	 	<input type="submit" value="Submit" />
	
	</form:form>
		 

</body>

</html>