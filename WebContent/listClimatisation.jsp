<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste</title>
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

	<a href="ClimatisationController">Saisie climatisation</a>
	<br />
	<br />
	<br />
	
	<span style = "color:red">${rechercheDataErreur}</span>
	<ul>
		<c:forEach var="clim" items="${climatisations}">
			<!-- il appelle getNomAppareil -->
			<li>${clim.nomAppareil}--------${clim.pression}</li>
		</c:forEach>
	</ul>
</body>
</html>