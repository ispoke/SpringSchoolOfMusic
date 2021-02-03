<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> Teacher Search Result </title>
	
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h3> Result Of Teacher Search </h3>
		</div>
	</div>
		<div id="container">
			
		<div id="content">
		
			<!--  Add HTML Table  -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
			
				<c:forEach var="teacher" items="${teachersFound}" >
					<tr>
						<!-- table data -->
						<td> ${teacher.firstName} </td>
						<td> ${teacher.lastName} </td>
						<td> ${teacher.email} </td>					
					</tr>
				
				</c:forEach>
			</table>
		</div>
		<br>
		<p>
				<a href="${pageContext.request.contextPath}/teacher/list">Return</a>
		</p>
	</div>	
</body>
</html>