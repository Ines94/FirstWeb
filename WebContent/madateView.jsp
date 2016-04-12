<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage de la date du jour</title>
</head>
<body>
	<h1>
	${dateDuJour} <br/>
	Il est ${heureDuJour} heures ${minuteDuJour} minutes.
	</h1>
	<br/>
	<h2>
	 Les données mesurées par le capteur sont :
	 <br/>
	 ${clim1.temperature}<br/>
	 ${clim1.temperatureFarenheit}<br/>
	 ${clim1.pression}<br/>
	 ${clim1.nomAppareil}<br/>
	</h2>
</body>
</html>