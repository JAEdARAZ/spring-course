<!-- specify the Spring namespace for Form Tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Customer Registration Form</title>
	<style>.error {color: red}</style>
</head>

<body>

	<form:form action="processForm" modelAttribute="customer">
	
		<!-- path: name of attributes in Customer class -->
		First name: <form:input path="firstName" /><br>
		
		Last name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" /><br>
		
		Coupons: <form:input path="freeCoupons" />
		<form:errors path="freeCoupons" cssClass="error" /><br>
		
		Course Code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" /><br>
			
	 	<input type="submit" value="Submit" />
	
	</form:form>
		 

</body>

</html>