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
		<h3>Course Update</h3>
		<form:form action="saveCourseUpdates" modelAttribute="course" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<!--  labels and input text fields -->
					<tr>
						<td><label>Course title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
					<tr>
						<td><label>Instrument:</label></td>
						<td><form:input path="instrument" /></td>
					</tr>
					<tr>
						<td><label>Level:</label></td>
						<td><form:input path="level" /></td>
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
				<a href="${pageContext.request.contextPath}/course/list">Cancel</a>
			</p>
	</div>
	
</body>

</html>