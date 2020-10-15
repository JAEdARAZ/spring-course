<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<title>List Customers</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>	
	</div><br>
	
	
	
	<div id="container">
		<div id="content">
		
		<!-- onclick calls the Spring Controller Mapping -->
		<div>
			<input type="button" value="Add Customer"
			   onclick="window.location.href='showAddForm'; return false;" 
			/>
		</div><br>

		<!-- customers table -->
		<table class="table table-bordered table-striped" style="text-align:center;">
			<thead class="thead-dark">
				<tr class="d-flex">
					<th class="col-3">First Name</th>
					<th class="col-3">Last Name</th>
					<th class="col-4">Email</th>
					<th class="col-2"></th>			
				</tr>
			</thead>
			
			<!-- loop and print customers -->
			<c:forEach var="tempCustomer" items="${customers}">
			
				<!-- build an update link adding a variable with the customer id. The value is a requestedMapping -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<!-- delete link -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<tr class="d-flex">
					<td class="col-3">${tempCustomer.firstName}</td>
					<td class="col-3">${tempCustomer.lastName}</td>
					<td class="col-4">${tempCustomer.email}</td>
					<td class="col-2">
						<div>
							<button onclick="window.location.href='${updateLink}'; return false;" class="btn btn-info mr-2">
								<i class="fas fa-pencil-alt"></i>
							</button>
							<button onclick="window.location.href='${deleteLink}'; return false;" class="btn btn-danger ml-2 ">
								<i class="fas fa-minus"></i>
							</button>
						</div> 
						
					</td>
				</tr>
			</c:forEach>
		</table>
		
		</div>	
	</div>

</body>

</html>