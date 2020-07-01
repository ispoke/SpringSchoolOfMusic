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
			<h3><i>School Of Music - Students enrolled on this course </i></h3>
		</div>
	</div>
	<div id=container>
	<h5>Course:</h5>
		<form:form action="returnFromShowStudents" modelAttribute="course" method="POST">
			<p><b>${course.title} </b><br> ${course.instrument} ${course.level}<p>
		</form:form>
	<h5>Students:</h5>
		<div id=content>
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.email}</td>
					</tr>
				
				</c:forEach>
			</table>
		
		</div>
		<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/course/list">Return to Course List</a>
			</p>
	</div>
</body>
</html>