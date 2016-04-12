<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie climatisation</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisation.js"></script>

</head>
<body>

	<c:choose>
		<c:when test="${not empty nom}">
			<div>${nom} est connecté</div><br/><br/>
			<a href="LogoutController">Logout</a>
			<br/>
		</c:when>
		<c:otherwise>
			<a href="LoginController">Login</a>
			<br/>
		</c:otherwise>
	</c:choose>	
	
	<a href="ListClimatisationController">Liste des climatisations</a>
	<br/>
	<br/>
	<br/>
	
	<form action="ClimatisationController" method="Post">
		<label>Nom appareil</label><input id="sourceNbId" type="text" value="${appareil}" name="appareil" /><span style = "color:red">${appareilVide}</span><span id ="nbId" style = "color:red"></span><br/>
		<label>Température</label><input type="text" value="${temperature}" name="temperature" /><span style = "color:red">${temperatureErreur}</span><br/>
		<label>Pression</label><input type="text" value="${pression}" name="pression" /><span style = "color:red">${pressionErreur}</span><span style = "color:red">${pressionNegative}</span><br/>
		<label>Taux d'humidité</label><input type="text" value="${taux}" name="taux" /><span style = "color:red">${tauxErreur}</span><span style = "color:red">${tauxExtreme}</span><br/>
		<input type="submit" value="Enregistrer" name="action" /><span style = "color:red">${sauvegardeErreur}</span>
	</form>
	  
</body>
</html>