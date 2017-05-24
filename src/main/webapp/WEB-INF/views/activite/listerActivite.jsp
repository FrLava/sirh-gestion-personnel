<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<title>SGP - App</title>
	</head>

	<body>
		<h1 style="text-align:center; margin:20px 0 30px 0">Les visites</h1>
		
		<table class="table table-striped">
			<thead>
	            <tr>
	                <th>Date/Heur</th>
	                <th>Libellé</th>
	            </tr>
	        </thead>
	        
	        <tbody>
	        	<c:forEach var="collabEvt" items="${listeActivites}">
	        	<tr>
	        		<td>${collabEvt.dateHeure}</td>
	        		<td>${collabEvt.typeString} ${collabEvt.matricule}</td>

	        	</tr>
	        	</c:forEach>
	        </tbody>
	        
		
		</table>
	</body>
</html>