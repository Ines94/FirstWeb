<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session</title>
</head>
<body>
	<a href="ClimatisationController">Saisie climatisation</a>
	
	<form action="LoginController" method="Post">
		<label>Nom : </label><input type="text" value="${nom}" name="nom" /><span style = "color:red">${nomVide}</span><br/>
		<input type="submit" value="Login" name="action" />
	</form>

</body>
</html>