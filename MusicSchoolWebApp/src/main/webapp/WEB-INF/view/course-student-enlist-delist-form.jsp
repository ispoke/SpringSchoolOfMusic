<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<title> Add Student to Course</title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h4> Add student to a course</h4>
		</div>
	</div> 
	<div id="container">
		<div id="content">
		<section>
		<h5>Course:</h5>
			<form:form action="saveStudentToCourse" modelAttribute="course" method="POST">
				<!--  show the course -->
				<p><b>
					${course.title} </b>
					<br>
						${course.instrument} ${course.level} 
				</p>
			
			</form:form>
		</section>
		
	
			<!--  show the list of students available -->
				<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="student" items="${students}">
					<c:url var="addToCourseLink" value="saveStudentToCourse">
					  	<c:param name="studentId" value="${student.id}"/> 		
					</c:url>
					<c:url var="removeFromCourseLink" value="delistStudentFromCourse">
						<c:param name="studentId" value="${student.id}" />
					</c:url>
					<tr> 
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.email}</td>
						<td><a href = "${addToCourseLink}">Enroll</a> 
						 |
						    <a href = "${removeFromCourseLink}">Remove</a></td>
					</tr>
				</c:forEach>
				</table>
				
		</div>
	
	</div>
	
	<div style="clear; both;"></div>
	<p>
		<a href="${pageContext.request.contextPath}/course/list">Cancel</a>
	</p>
	
</body>
</html>