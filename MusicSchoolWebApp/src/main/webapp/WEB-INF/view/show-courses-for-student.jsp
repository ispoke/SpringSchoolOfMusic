<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Courses For Student </title>
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
			<h3><i>School Of Music - Courses For This Student </i></h3>
		</div>
	</div>
	<div id=container>
	<h5>Student:</h5>
		<!-- Show the Student's name -->
		<form:form action="returnFromShowCourses" modelAttribute="student" method="POST">
			<p><b>${student.firstName} ${student.lastName}</b> <br>${student.email}<p>
		
		</form:form>
	<h5>is enrolled in the following courses:</h5>
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
				<a href="${pageContext.request.contextPath}/student/list">Return to Student List</a>
			</p>
	</div>
</body>
</html>