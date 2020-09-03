<!DOCTYPE>
<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>

<body>

	<h2>${homePage}</h2>

	<hr>
	
	<a href="showForm">${helloWorldForm}</a>

	<br><br>
	<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />

	<br><br>

	<button type="submit" onclick="doSomeWork()" class="btn btn-primary">Click me</button>

</body>

</html>