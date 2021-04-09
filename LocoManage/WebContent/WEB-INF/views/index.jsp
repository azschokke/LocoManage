<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Hello</h1>
	<form:form action="./addManufacturer" method="post" modelAttribute="manufacturer">
		<form:input path="name" placeholder="manufacturer"/>
		<input type="submit" value="submit" />
	</form:form>
	<form:form action="./addScale" method="post" modelAttribute="scale">
		<form:input path="scale" placeholder="scale"/>
		<input type="submit" value="submit" />
	</form:form>
	<form:form action="./addClassification" method="post" modelAttribute="classification">
		<form:input path="name" placeholder="classification"/>
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>