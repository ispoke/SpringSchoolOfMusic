<!-- Support for Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Update Teacher Details</title>
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
	<div id=container>
	<h5>Teacher</h5>
		<!-- Show the Teacher's name -->
		<form:form action="saveUpdatesForTeacherDetails" modelAttribute="teacher" method="POST">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<tbody>
					<tr>
						<td><c:out value="${teacher.firstName}"></c:out></td>
						<td><c:out value="${teacher.lastName}"></c:out></td>
						<td><c:out value="${teacher.email}"></c:out></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
	<h5>Details</h5>
		<form:form action="saveUpdatesForTeacherDetails" modelAttribute="teacherDetails" method="POST">
			<!-- Associate the teacher details with the id. Otherwise lose context -->
			<!-- Don't forget it !!!! -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<!--  labels and input text fields -->
					<tr>
						<td><label>Instrument 1:</label></td>
						<td><form:input path="instrument1" /></td>
					</tr>
					<tr>
						<td><label>Instrument 2:</label></td>
						<td><form:input path="instrument2" /></td>
					</tr>
					<tr>
						<td><label>Web Page:</label></td>
						<td><form:input path="webpage" /></td>
					</tr>			
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
			
		</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/teacher/list">Return</a>
			</p>
	</div>
</body>
</html>