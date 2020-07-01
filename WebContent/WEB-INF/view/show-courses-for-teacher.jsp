<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Courses By Teacher </title>
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
			<h3><i>School Of Music - Teacher's Courses </i></h3>
		</div>
	</div>
	<div id=container>
	<h5>Teacher:</h5>
		<!-- Show the Teacher's name -->
		<form:form action="returnFromShowCourses" modelAttribute="teacher" method="POST">
			<p><b>${teacher.firstName} ${teacher.lastName}</b> <br>${teacher.email}<p>
		
		</form:form>
	<h5>Courses:</h5>
		<div id=content>
			<table>
				<tr>
					<th>Course Id</th>
					<th>Title</th>
					<th>Instrument</th>
					<th>Level</th>
				</tr>
				
				<c:forEach var="course" items="${courses}">
					<tr>
						<td>${course.id}</td>
						<td>${course.title}</td>
						<td>${course.instrument}</td>
						<td>${course.level}</td>
					</tr>
				
				</c:forEach>
			</table>
		
		</div>
		<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/teacher/list">Return to Teacher List</a>
			</p>
	</div>
</body>
</html>