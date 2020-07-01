<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  %response.sendRedirect("teacher/list");  % -->
<!DOCTYPE html>

<html>

<head>
	<title>School Home </title>
	
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
<div id="wrapper">
		<div id="header">
			<h3><i>Welcome To The School Of Music</i></h3>
		</div>
		<br>
		<article>School of Music administration is intended for use by administrators only. 
		It enables the administrator to quickly and easily add, update and delete courses, teachers and students
		as well as enroll students on courses or remove students from a course. 
		<br><br>
		
		Click on the links here to continue with administrative tasks:
		</article>
</div>
<div id="container">

	<section>
	<p>
		<a href="${pageContext.request.contextPath}/course/list">Courses</a>
	</p>
	</section>
	
	<section>
	<p>
		<a href="${pageContext.request.contextPath}/teacher/list">Teachers</a>
	</p>
	</section>
	
	<section>
	<p>
		<a href="${pageContext.request.contextPath}/student/list">Students</a>
	</p>
	</section>
	
</div>


</body>
</html>
