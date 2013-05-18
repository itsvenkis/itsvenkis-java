login here
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
</head>
<body>
	<form:form method="POST" commandName="user">
		<table border = "1">
		<tr>
		<td>
		User Name:
		</td>
		<td>
		<form:input path="userName" id="userName"/>
		</td>
		</tr>
		<tr>
		<td>
		Password:
		</td>
		<td>
		<form:password path="password" id="password"/>
		</td>
		</tr>
		<tr>
		<td>
		<input type="submit" value="login" />
		</td>
		</tr>
		</table>
	</form:form>
</body>
</html>