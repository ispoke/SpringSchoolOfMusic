<!-- Support for Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Teacher</title>
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-teacher-style.css" />
</head>

<body>
	<div id="wrapper">
		<div id=header>
			<h2><i>School Of Music Admin </i></h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Teacher</h3>
		<form:form action="saveTeacher" modelAttribute="teacher" method="POST">
			<table>
				<tbody>
					<!--  labels and input text fields -->
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
											
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Next" class="save" /></td>
					</tr>		
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/teacher/list">Cancel</a>
			</p>
	</div>
	
</body>

</html>












