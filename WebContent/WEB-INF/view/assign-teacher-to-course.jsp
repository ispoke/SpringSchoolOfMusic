<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<title> Assign Teacher</title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
			<h4> Assign a Teacher to the Course: </h4>
	</div>
</div>
<div id="container">
	<div id="content">
	<!-- show the teacher list -->
	<section>
	<form:form action="assignTeacher" modelAttribute="course" method="POST">
		<form:hidden path="id"/>
		<table>
		<tr>
				<th>Course Title</th>
				<th>Instrument</th>
				<th>Level</th>
		</tr>
			<tr>
				<td><c:out  value="${course.title}"></c:out> </td>
				<td><c:out  value="${course.instrument}"></c:out> </td>
				<td><c:out  value="${course.level}"></c:out> </td>
			</tr>
		</table>
		
	</form:form>
	<h5>List of available music teachers</h5>
	<table>
		<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Instrument 1</th>
					<th>Instrument 2</th>
					<th>ID</th>
		</tr>
		
		<c:forEach var="teacher" items="${musicTeachers}">
			<tr>
				<td> ${teacher.firstName} </td>
				<td> ${teacher.lastName} </td>
				<td> ${teacher.teacherDetail.instrument1} </td>
				<td> ${teacher.teacherDetail.instrument2} </td>
				<td> ${teacher.id} </td>
			</tr>
		</c:forEach>
	</table>
	</section>
	
	<section>
	<h5>Choose a Teacher ID from the list for course </h5>
	
	<form action="assignTeacher" method="POST">
	
		<select name="teacher">
			<c:forEach var="teacher" items="${musicTeachers}">
				<option value = "${teacher.id}"> ${teacher.id}</option>
			</c:forEach>
		</select>
	  <input type= "submit" name="submit" value="Assign" />
	</form>
	</section>
	</div>
</div>
<div style="clear; both;"></div>
<p>
	<a href="${pageContext.request.contextPath}/course/list">Cancel</a>
</p>
		
</body>
</html>


