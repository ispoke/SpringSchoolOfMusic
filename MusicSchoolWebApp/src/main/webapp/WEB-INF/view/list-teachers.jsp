<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> List Teachers </title>
	
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">
		<div id="header">
			<h2> Teachers at The School Of Music  </h2>
		</div>
</div>
<div style="clear; both;"></div>
<p>
	<a href="${pageContext.request.contextPath}/index.jsp">home</a>
</p>
	<div id="container">
	
		<div id="content">
		
			<!-- Button to add a new teacher  -->
			<!-- add css style  with class="add-button"-->
			<input type="button" value="Add Teacher"
				onclick="window.location.href='showFormForAddTeacher'; return false;"
				class="add-button" 
			/>
		
			<input type="button" value="Search Teacher"
				onclick="window.location.href='showSearchTeacherForm'; return false;"
				class="add-button" 
			/>
			<!--  Add HTML Table  -->
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Details</th>
					<th>Courses</th>
					<th>Actions</th>
				</tr>
			
				<c:forEach var="teacher" items="${musicTeachers}" >
					<!-- Construct a link with teacher id as an embedded variable -->
					<c:url var="getDetailsLink" value="showTeacherDetailsForm">
					  <c:param name="teacherId" value="${teacher.id}"/> 		
					</c:url>
					<c:url var="showCoursesLink" value="showCourses">
					  <c:param name="teacherId" value="${teacher.id}"/> 		
					</c:url>
					<c:url var="updateTeacherLink" value="updateTeacherForm">
					  <c:param name="teacherId" value="${teacher.id}"/> 		
					</c:url>
					<c:url var="deleteLink" value="deleteWithCare">
					  <c:param name="teacherId" value="${teacher.id}"/> 		
					</c:url>
					<tr>
						<!-- table data -->
						<td> ${teacher.id} </td>
						<td> ${teacher.firstName} </td>
						<td> ${teacher.lastName} </td>
						<td> ${teacher.email} </td>
						<td> <a href="${getDetailsLink}">details</a></td>
						<td> <a href="${showCoursesLink}">courses</a></td>
						<td> <a href="${updateTeacherLink}">update</a>
								|
							 <a href="${deleteLink}"
							 	onclick="if (!(confirm('Are you sure you want to delete this teacher?'))) return false">delete</a>
						</td>					
					</tr>
				</c:forEach>  
			</table>
		</div>
	</div>

</body>
</body>

</html>










