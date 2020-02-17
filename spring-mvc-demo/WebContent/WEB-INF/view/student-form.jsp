<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name: <form:input path="lastName"/>
		
		<br><br>
		
		Country: <form:select path="country">
		
			<form:options items="${student.countryOptions}"/>
		
		</form:select>
		
		<br><br>
		
		Favourite Language: <form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguageOptions}"/>
		
		<br><br>
		
		operating Systems : 
		Linux: <form:checkbox path="operatingSystems" value="Linux"/>
			Windows: <form:checkbox path="operatingSystems" value="Windows"/>
			Mac: <form:checkbox path="operatingSystems" value="Mac"/>
		
	
		<input type="submit" value="Submit">
	
	
	</form:form>

</body>
</html>