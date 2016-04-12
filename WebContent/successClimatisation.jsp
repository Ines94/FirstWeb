<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Succès climatisation</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty nom}">
			<div>${nom} est connecté</div><br/><br/>
			<a href="LogoutController">Logout</a>
			<br />
		</c:when>
		<c:otherwise>
			<a href="LoginController">Login</a>
			<br />
		</c:otherwise>
	</c:choose>

	<a href="ListClimatisationController">Liste des climatisations</a>
	<a href="ClimatisationController">Saisie climatisation</a>
	<br />
	<br />
	<br />

	<h1>
		Vous venez de saisir les données de :<br /> ${appareil}
	</h1>

</body>
</html>