<!-- Support for Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Search Teacher</title>
	
	<!--  reference style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id=header>
			<h4><i>School Of Music Admin</i></h4>
		</div>
	</div>
	<div id=container>
	<h4>Search For a Teacher</h4>
	<form action="searchTeacher" method="post">
		 First Name: <input type = "text" name = "firstName" class="lookup-button">
         <br />
         
         Last Name: <input type = "text" name = "lastName" class="lookup-button"/>
         
         <!-- Id Number: <input type = "text" name = "teacherId" /> -->
         
         <input type = "submit" value = "search" class="add-button" />
	
	</form>
	</div>
</body>

</html>