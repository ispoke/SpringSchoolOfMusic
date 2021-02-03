<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> List Courses </title>
		<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2> School Of Music - Courses </h2>
		</div>
	</div>
<div style="clear; both;"></div>
<p>
	<a href="${pageContext.request.contextPath}/index.jsp">home</a>
</p>
	<div id="container">
	
		<div id="content">
		
			<!-- Button to add a new course  -->
			<!-- add css style  with class="add-button"-->
			<input type="button" value="Add Course"
				onclick="window.location.href='showFormForAddCourse'; return false;"
				class="add-button" 
			/>
		
			<!--  Add HTML Table  -->
			<table>
				<tr>
					<th>Course Title</th>
					<th>Instrument</th>
					<th>Level</th>
					<th>Teacher </th>
					<th>Assign teacher</th>
					<th>Actions</th>
					<th>Students</th>
				</tr>
				
				<!-- Loop through the collection and print each item -->
				<c:forEach var="theCourse" items="${musicCourses}">
				<!-- construct a link with course id as an embedded variable -->
				
				<c:url var="assignTeacherLink" value="assignTeacherForm">
					  <c:param name="courseId" value="${theCourse.id}"/> 		
				</c:url>
				<c:url var="updateCourseLink" value="updateCourseForm">
					<c:param name="courseId" value="${theCourse.id}"></c:param>
				</c:url>
				<c:url var="deleteCourseLink" value="deleteCourse">
					  <c:param name="courseId" value="${theCourse.id}"/> 		
				</c:url>
				<c:url var="showStudentsLink" value="showStudentsEnrolled">
					  <c:param name="courseId" value="${theCourse.id}"/> 		
				</c:url>
				<c:url var="addStudentLink" value="addStudentToCourse">
					  <c:param name="courseId" value="${theCourse.id}"/> 		
				</c:url>
				<c:url var="removeStudentLink" value="removeStudentFromCourse">
					  <c:param name="courseId" value="${theCourse.id}"/> 		
				</c:url>
					<tr>
						<!-- jsp expression language to get table data-->
						<td> ${theCourse.title} </td>  
						<td> ${theCourse.instrument} </td>
						<td> ${theCourse.level} </td>
						<td> ${theCourse.teacher.firstName}  ${theCourse.teacher.lastName}</td>
						<td> <a href="${assignTeacherLink}">(re)-assign a teacher</a> </td>
							
						<td>	 <a href="${updateCourseLink}">update</a> 
							| 
							<a href="${deleteCourseLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">delete</a>
						</td>
						<td><a href="${showStudentsLink}"><i>show</i></a>
							| <a href="${addStudentLink}"><i>add</i></a>
							| <a href="${removeStudentLink}"><i>remove</i></a>
						</td>
						
					</tr>
				</c:forEach>
			
			</table>
		</div>
	
	</div>
</body>

</html>









