<!DOCTYPE html>
<html>
<head>
<title>Spring MVC Demo</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
	<h2>Spring MVC Demo - Home Page</h2>

	<a href="hello/showForm">Hello World Form</a>
	<br>
	<br>

	<img alt="Spring Logo"
		src="${pageContext.request.contextPath}/resources/images/spring-logo.png">
	<br>
	<br>

	<input type="button" onclick="dosomework()" value="click me">

	<a href="student/showForm">Student Form</a>
	<br><br>
	
	<a href="customer/showForm">Customer Form</a>
		<br><br>

</body>
</html>