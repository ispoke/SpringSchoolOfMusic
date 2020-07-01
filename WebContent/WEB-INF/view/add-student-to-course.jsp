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
		<h5>Select a course for:</h5>
			<form:form action="saveCourseForStudent" modelAttribute="student" method="POST">
				<!--  show the student in question -->
				<p><b>
					${student.firstName} ${student.lastName}</b>
					<br>
						${student.email} 
				</p>
			
			</form:form>
		</section>
		
	
			<!--  show the list of courses available -->
				<table>
				<tr>
					<th>Id</th>
					<th>Course title</th>
					<th>Instrument</th>
					<th>Level</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="course" items="${courses}">
					<c:url var="addToCourseLink" value="saveCourseForStudent">
					  	<c:param name="courseId" value="${course.id}"/> 		
					</c:url>
				
					<tr> 
						<td>${course.id}</td>
						<td>${course.title}</td>
						<td>${course.instrument}</td>
						<td>${course.level}</td>
						<!-- <td><a href = "${addToCourseLink}">Enroll on this course</a> </td>  -->
					</tr>
				</c:forEach>
				</table>
				
		<h5>Choose a Course ID from the list for this Student </h5>
		<form action="saveCourseForStudent" method="POST">
	
		<select name="course">
			<c:forEach var="course" items="${courses}">
				<option value = "${course.id}"> ${course.id}</option>
			</c:forEach>
		</select>
	  <input type= "submit" name="submit" value="Assign" />
	
	</form>				
	
		</div>
	
	</div>
</body>
</html>