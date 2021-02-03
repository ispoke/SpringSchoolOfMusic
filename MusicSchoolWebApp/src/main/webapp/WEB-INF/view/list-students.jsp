<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> List of Students </title>
	
	<!--  reference css style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2> School Of Music - Students </h2>
		</div>
	</div>
	<div style="clear; both;"></div>
	<p>
		<a href="${pageContext.request.contextPath}/index.jsp">home</a>
	</p>
	<div id="container">
	
		<div id="content">
		
			<!-- Button to add a new student  -->
			<!-- add css style  with class="add-button"-->
			<input type="button" value="Add Student"
				onclick="window.location.href='showFormForAddStudent'; return false;"
				class="add-button" 
			/>

			<!--  Add HTML Table  -->
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Courses</th>
					<th>Updates</th>
				</tr>
				
				<c:forEach var="student" items="${students}">
				<c:url var="addCourseLink" value="addStudentToCourse">
					  <c:param name="studentId" value="${student.id}"/> 		
				</c:url>
				<c:url var="removeFromCourseLink" value="removeStudentFromCourse">
					  <c:param name="studentId" value="${student.id}"/> 		
				</c:url>
				<c:url var="showCourseLink" value="showCoursesForStudent">
					  <c:param name="studentId" value="${student.id}"/> 		
				</c:url>
				<c:url var="updateStudentLink" value="updateStudent">
					  <c:param name="studentId" value="${student.id}"/> 		
				</c:url>
				<c:url var="deleteStudentLink" value="deleteStudent">
					  <c:param name="studentId" value="${student.id}"/> 		
				</c:url>
				 <tr>
				 	<td> ${student.id}</td>
					<td> ${student.firstName}</td>
					<td> ${student.lastName}</td>
					<td> ${student.email}</td>
					<td> <a href="${showCourseLink}">show</a>
					  <!-- |	 <a href="${addCourseLink}">add</a>
					  |	 <a href="${removeFromCourseLink}">remove</a>  -->
					 </td>
					<td><a href="${updateStudentLink}">update</a> 
					|
						<a  href="${deleteStudentLink}"
							 	onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">delete</a>
					</td>
				 </tr>
				</c:forEach>
				
			</table>
		</div>
	
	</div>
	
</body>

</html>